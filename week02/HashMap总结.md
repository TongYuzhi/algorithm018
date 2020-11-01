## HashMap总结

HashMap的结构由散列表+链表实现，在数据量到达一定阈值之后，链表会树化，形成红黑树，以更好地解决散列冲突。
我们知道，解决散列表的散列冲突主要有两个方法，一个是开放寻址法，一个是链表法。Java里，使用的是链表法。这
里就牵扯到了HashMap里一个重要的字段，Node[] table, 即哈希桶数组，它是一个Node类型的数组。

```
static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

```
Node是HashMap的一个内部类，实现了Map.Entry接口，本质是就是一个映射(键值对)，next就指向的是下一个结点。所以通过Node
类，可以实现一个散列冲突后的链表，以便我们查找数据。

当哈希桶数组很大的时候，散列冲突的概率会很小，因此，我们需要从两个角度入手，去控制散列冲突以及空间消耗。一个是哈希算法
，一个是扩容机制。

通过哈希算法，数组被分成一个一个桶，通过哈希值决定了键值对在这个数组中的寻址，哈希值相同的键值对，则以链表形式存储，如果链表大小超过阈值 ``` TREEIFY_THRESHOLD``` (也就是8)，链表就会被改造成树形结构。

我们可以通过HashMap的put()方法源码来看这个过程

```
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        // 步骤1：tab为空则创建
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
        // 步骤2：计算index，并对null做处理 
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
             // 步骤3：节点key存在，直接覆盖value
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
                // 步骤4：判断该链为红黑树
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                // 步骤5：该链为链表
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        //链表长度大于8转换为红黑树进行处理
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // key已经存在直接覆盖value
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        // 步骤5：超过最大容量 就扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```
put()方法主要就进行了这五个步骤。

由此我们可以看到使用散列表需要解决的一个最重要的问题，就是散列冲突的处理。如果数组容量很大，那相应的散列冲突的概率就会小，同时也占据了更大的空间，所以我们要通过灵活的扩容机制以及效率足够高的哈希函数来解决内存占用和散列冲突之间的矛盾。但是写出了足够好的哈希函数仍然不够，散列冲突是不可避免的。散列冲突之后的处理仍然也是个问题。Java的HashMap使用的是链表和红黑树，但是我们也可以使用跳表，使用B+树等等，要达到HashMap的O(1)的数据查找，我们就需要这样灵活的数据结构来处理散列冲突之后的数据堆砌问题。通过对HashMap源码的学习，我感受比较深的就是它通过位运算做的哈希函数处理、扩容的处理以及散
列冲突的解决，都是非常值得深入学习的方面。