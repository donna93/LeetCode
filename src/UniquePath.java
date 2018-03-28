/**
 * 62. Unique Paths
 * A robot is located at the top-left corner of a m x n
 * grid (marked 'Start' in the diagram below).

 * The robot can only move either down or right at any point
 * in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).

 * How many possible unique paths are there?
 */
public class UniquePath {
    public static int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            res[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            res[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {
        int[]res = new int[n];
        res[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                res[j] += res[j - 1];
            }
        }
        return res[n - 1];
    }

    //use math method to solve------ C(m,n): here m = count = m - n - 2; n = k = m - 1;
    //C(count, k) = count! / (count - k)! * k! = (count - k + 1) * (count - k + 2)... / k!
    public static int uniquePath3(int m, int n){
        int count = m + n - 2;
        int k = m - 1;
        double res = 1;

        for(int i = 1; i <= k; i++){
            res = res*(count - k + i)/i;
        }
        return (int)res;
    }

    public static void main(String[]args){
        System.out.println(uniquePath3(4,4));
        System.out.println(uniquePaths(4,4));
        System.out.println(uniquePaths2(3,7));
    }
}
