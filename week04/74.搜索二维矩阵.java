import javax.print.attribute.standard.NumberUpSupported;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;
import javax.swing.text.rtf.RTFEditorKit;

/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int left = 0;
        int right = rowNum * colNum - 1;
        
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            int row = mid / colNum;
            int col = mid % colNum;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end

/**
 *  My first solution, O(logn), O(1)
 *  Easy to read but not clean
 * 
 * public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        boolean isExist = false;
        int up = 0;
        int down = matrix.length - 1;

        while (up <= down) {
            int mid = ((down - up) >> 1) + up;
            int len = matrix[mid].length;
            if (target >= matrix[mid][0] && target <= matrix[mid][len - 1]) {
                up = mid;
                isExist = true;
                break;
            }
            if (target < matrix[mid][0]) {
                down = mid - 1;
            } else if (target > matrix[mid][len - 1]) {
                up = mid + 1;
            }
        }

        if (!isExist) {
            return false;
        }

        int left = 0;
        int right = matrix[up].length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target == matrix[up][mid]) {
                return true;
            } else if (target > matrix[up][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
 */

 /** Also O(n),but clean
  * 
  * public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int left = 0;
        int right = rowNum * colNum - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            int row = mid / colNum;
            int col = mid % colNum;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
  */
