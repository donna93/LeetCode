import java.util.TreeSet;

/**
 363. Max Sum of Rectangle No Larger Than K
 Given a non-empty 2D matrix matrix and an integer k, find
 the max sum of a rectangle in the matrix such that its sum
 is no larger than k.

 Example:
    Given matrix = [
                    [1,  0, 1],
                    [0, -2, 3]
                             ]
     k = 2
 The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2
 and 2 is the max number no larger than k (k = 2).
 */
public class MaxSumOfRectangleNoLarThanK {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0)return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for(int left = 0; left < n; left++){
            int[] sums = new int[m];
            for(int right = left; right < n; right++){
                for(int i = 0; i < m; i++){
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer>set = new TreeSet<>();
                int cur = 0;
                set.add(0);
                for(int sum : sums){
                    cur += sum;
                    Integer num = set.ceiling(cur - k);
                    if(num != null){
                        res = Math.max(res, cur - num);
                    }
                    set.add(cur);
                }
            }
        }
        return res;
    }
    public static void main(String[]args){
        int[][]matrix = {{1,  0, 1},
                         {0, -2, 3}};
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix,k));
    }
}
