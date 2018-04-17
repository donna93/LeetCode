/**
 * 44. Wildcard Matching
 * Given an input string (s) and a pattern (p), implement wildcard
 * pattern matching with support for '?' and '*'.

   '?' Matches any single character.
   '*' Matches any sequence of characters (including the empty sequence).
   The matching should cover the entire input string (not partial).

 Note:
   s could be empty and contains only lowercase letters a-z.
   p could be empty and contains only lowercase letters a-z, and characters like ? or *.

 Example 1:
   Input:
   s = "aa"
   p = "a"
   Output: false
   Explanation: "a" does not match the entire string "aa".

 Example 2:
   Input:
   s = "aa"
   p = "*"
   Output: true
   Explanation: '*' matches any sequence.

 Example 3:
   Input:
   s = "cb"
   p = "?a"
   Output: false
   Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

 Example 4:
   Input:
   s = "adceb"
   p = "*a*b"
   Output: true
   Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

 Example 5:
   Input:
   s = "acdcb"
   p = "a*c?b"
   Output: false

 初始化：如果p位置是“*”，dp[][]的值从上面传下来 --> dp[0][j + 1] = dp[0][j]

 1. p.charAt(i) == '?' 或者 p.charAt(i) == s.charAr(i) --> dp[i + 1][j + 1] = dp[i][j]
 2. p.charAt(i) == '*'
                   a. *代表一个sequence --> dp[i + 1][j + 1] = dp[i + 1][j]
                   b. *代表一个空值 --> dp[i + 1][j + 1] = dp[i][j + 1]
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        if(s == null || p == null)return false;
        boolean[][]dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*'){
                dp[0][i + 1] = dp[0][i];
            }
        }
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[]args){
        String s1 = "aa";
        String p1 = "a";
//        Output: false
//        Explanation: "a" does not match the entire string "aa".

        String s2 = "aa";
        String p2 = "*";
//        Output: true
//        Explanation: '*' matches any sequence.

        String s3 = "cb";
        String p3 = "?a";
//        Output: false
//        Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

        String s4 = "adceb";
        String p4 = "*a*b";
//        Output: true
//        Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

        String s5 = "acdcb";
        String p5 = "a*c?b";
//        Output: false

        System.out.println(isMatch(s1,p1));
        System.out.println(isMatch(s2,p2));
        System.out.println(isMatch(s3,p3));
        System.out.println(isMatch(s4,p4));
        System.out.println(isMatch(s5,p5));
    }
}
