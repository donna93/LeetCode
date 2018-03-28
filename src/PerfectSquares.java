import java.util.Arrays;

/**
 * 279. Perfect Squares
 * Given a positive integer n, find the least number of perfect square
 * numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example,
 * given n = 12, return 3 because 12 = 4 + 4 + 4;
 * given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for(int i = 0; i < n + 1; i++){
            for(int j = 1; j * j <= i; j++){
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }
    public static void main(String[]args){
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}
