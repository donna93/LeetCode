/**
 * 72. Edit Distance
 * Given two words word1 and word2, find the minimum number of
 * steps required to convert word1 to word2. (each operation is
 * counted as 1 step.)

 * You have the following 3 operations permitted on a word:

 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 * 1. word1 == word2 ---> dp[i][j] = dp[i - 1][j - 1]
 * 2. word1 != word2:
 *                 insert: dp[i][j] = dp[i][j - 1] + 1;
 *                 replace: dp[i][j] = dp[i - 1][j - 1] + 1;
 *                 delete: dp[][] = dp[i - 1][j] + 1;
 *
 *       a b c d
 *     0 1 2 3 4
 *   a 1 0 1 2 3
 *   e 2 1 1 2 3
 *   c 3 2 2 2 3
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= len2; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1],dp[i - 1][j]),dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];

    }

    public static void main(String[]args){
        String word1 = "abcd";
        String word2 = "aef";

        System.out.println(minDistance(word1,word2));
    }
}
