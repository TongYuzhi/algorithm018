import sun.tools.serialver.resources.serialver;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {

    class UnionFind {
        private int count;
        private int[] parent;
        private int[] size;

        public UnionFind(int count) {
            this.count = count;
            this.parent = new int[count];
            this.size = new int[count];

            for (int i = 0; i < count; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        private void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length < 1 || M[0].length < 1) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }
}
// @lc code=end

/**
 * Union Find
 * 
 * class UnionFind {
        int count;
        int[] parent;
        int[] size;

        public UnionFind(int count) {
            this.count = count;
            this.parent = new int[count];
            this.size = new int[count];

            for (int i = 0; i < count; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            
            if (rootP == rootQ) {
                return;
            }

            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
    }

    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
 */

/**
 *  DFS
 * 
 * public int findCircleNum(int[][] M) {
        if (M == null || M.length < 1) {
            return 0;
        }
        boolean[] visited = new boolean[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }
 */
