/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    /** DFS
     *  被围绕的区域不会存在在边界上，所以我们从边界上的O出发，
     *  找到和它连通的其他的O，将其标记。最后我们遍历整个board
     *  如果被标记成了其他字符，那说明它和边界的O是连通的，没有
     *  被包围，我们将其设回O，反之如果它还是O，那就是我们要找
     *  的，将其设为X。
     * 
     *  Union Find
     *  设置一个dummy结点，将所有边界上的O与dummy相连，如果一个O
     *  不在边界上，就搜索它的四周，将找到的其它O与它相连
     *  并查集建立好之后遍历整个board，将所有孤立的点设置为X
     */
    private static final int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }
        int rowNum = board.length;
        int colNum = board[0].length;

        UnionFind unionFind = new UnionFind(rowNum * colNum + 1);
        int dummy = rowNum * colNum;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (board[i][j] == 'O') {
                    int node = i * colNum + j;
                    if (i == 0 || i == rowNum - 1 || j == 0 || j == colNum - 1) {
                        unionFind.union(node, dummy);
                    } else {
                        for (int k = 0; k < dir.length; k++) {
                            int newRow = i + dir[k][0];
                            int newCol = j + dir[k][1];
                            if (newRow <  0 || newRow >= rowNum || newCol < 0 || newCol >= colNum || board[newRow][newCol] != 'O') {
                                continue;
                            }
                            unionFind.union(node, newRow * colNum + newCol);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                int node = i * colNum + j;
                if (!unionFind.isConnected(node, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int count) {
            this.parent = new int[count];

            for (int i = 0; i < count; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
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
            parent[rootP] = rootQ;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
// @lc code=end

/**
 * 
 *  DFS O(m * n)
 * 
 * public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }
        int rowNum = board.length;
        int colNum = board[0].length;

        for (int i = 0; i < rowNum; i++) {
            dfs(i, 0, board);
            dfs(i, colNum - 1, board);
        }
        for (int i = 0; i < colNum; i++) {
            dfs(0, i, board);
            dfs(rowNum - 1, i, board);
        }

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'Y';

        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }
 */
