简单分析一下Queue和Priority Queue的源码

## Queue

首先需要明确的是```Queue```是一个继承了```Collection```的接口。

``` public interface Queue<E> extends Collection<E> { ```

它提供了几个简单的接口：

```
<tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link Queue#add add(e)}</td>
 *    <td>{@link Queue#offer offer(e)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link Queue#remove remove()}</td>
 *    <td>{@link Queue#poll poll()}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link Queue#element element()}</td>
 *    <td>{@link Queue#peek peek()}</td>
 *  </tr>
```
这六个接口分别实现了 Insert, Remove, Examine 三个功能，两两一组。其中 add(), remove(), element()
会在操作失败时抛出一个异常，而其它三个接口在操作失败时会返回一个特殊值，这是它们之间的区别。我们通过看
源码的注释可以很清晰地看到这一点。

```
/**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean add(E e);

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean offer(E e);

```

## Priority Queue

```Priority Queue ``` 也是和 ``` Queue ``` 是一个祖先，我们看源码可以知道 ```PriorityQueue ``` 继承了 ```AbstractQueue ``` 接口，而 ```AbstractQueue ``` 又继承了 ```AbstractCollection ``` ， 最后它又继承了```Collection```接口。经过这些复杂的继承，```PriorityQueue ``` 实现了几个 Queue 没有的接口，比如根据优先级
来出队列，将队列元素转化为数组等等。

优先级队列我们通常想到的就是可以使用堆这个数据结构来实现，果然，在源码中，我看到了堆的身影。

```
/**
     * Establishes the heap invariant (described above) in the entire tree,
     * assuming nothing about the order of the elements prior to the call.
     */
    @SuppressWarnings("unchecked")
    private void heapify() {
        for (int i = (size >>> 1) - 1; i >= 0; i--)
            siftDown(i, (E) queue[i]);
    }
```

我们来看优先级队列的构造方法

```
	public PriorityQueue(Collection<? extends E> c) {
        if (c instanceof SortedSet<?>) {
            SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
            this.comparator = (Comparator<? super E>) ss.comparator();
            initElementsFromCollection(ss);
        }
        else if (c instanceof PriorityQueue<?>) {
            PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
            this.comparator = (Comparator<? super E>) pq.comparator();
            initFromPriorityQueue(pq);
        }
        else {
            this.comparator = null;
            initFromCollection(c);
        }
    }
```
其中的几个init方法，都调用了最后的initFromCollection方法，而这个init的方法非常简单，就是实现了一个堆化的过程，调用了上面的heapify方法。因此，我们可以看出优先级队列的实现原理，其实就是维护了一个堆。

优先级队列中还有个值得注意的地方，在这个类中定义了一个final的静态成员：

``` private static final int DEFAULT_INITIAL_CAPACITY = 11; ```，而无参的优先级队列的构造是这样的：
``` 
public PriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }
```
也就是说，如果你不设置容量的话，默认的优先级队列的大小就是11，如果需要填入的数据超过了这个容量，优先级队列就有一个扩容的grow过程。

```
private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }

 ```
 每次扩容1.5倍，这个操作其实是比较浪费时间的，所以如果对数据的容量已经有一个预先的了解的话，最好在初始化的时候，直接给定一个容量大小。