import java.util.Arrays;

/**
 * 85. Maximal Rectangle
 * Given a 2D binary matrix filled with 0's and 1's, find
 * the largest rectangle containing only 1's and return its area.

 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 *
 * 】
 * height:
 * 1 0 1 0 0
 * 2 0 2 1 1
 * 3 1 3 2 2
 * 4 0 0 3 0
 *
 * left:
 * 0 0 2 0 0
 * 0 0 2 2 2
 * 0 0 2 2 2
 * 0 0 0 3 0
 * 由两个元素决定：上一行left[j]值，和边界curLeft值；取两个中最大
 *
 * right:
 * 1 5 3 5 5
 * 1 5 3 5 5
 * 1 5 3 5 5
 * 1 5 5 4 5
 * 类似地，初始化为5，由两个元素决定：上一行right[j]值，和边界curRight值；取两个之中最小；
 *
 * 注意填充Array：Array.fill(int[], Integer)方法
 *
 */
public class MaximamRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[]height = new int[n];
        int[]right = new int[n];
        int[]left = new int[n];
        Arrays.fill(right,n);

        for(int i = 0; i < m; i++){
            int curLeft = 0, curRight = n;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1')height[j]++;
                else height[j] = 0;
            }
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(curLeft, left[j]);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for(int j = n - 1; j > 0; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j],curRight);
                }else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for(int j = 0; j < n; j++){
                res = Math.max((right[j] - left[j]) * height[j], res);
            }
        }
        return res;
    }
    public static void main(String[]args){
        char[][]matrix = {{'1', '0', '1', '0', '0'},
                          {'1', '0', '1', '1', '1'},
                          {'1', '1', '1', '1', '1'},
                          {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
