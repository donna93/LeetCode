/**
 * 10. Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Note:
 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "a*"
 Output: true
 Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 Example 3:

 Input:
 s = "ab"
 p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".
 Example 4:

 Input:
 s = "aab"
 p = "c*a*b"
 Output: true
 Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 Example 5:

 Input:
 s = "mississippi"
 p = "mis*is*p*."
 Output: false
 初始化：防止有a*这类在最前，并代表empty

 分三种情况：
     1. s.charAt(i) == p.charAt(j) --> dp[i + 1][j + 1] = dp[i][j];
     2. p.charAt(j) == '.'  --> dp[i + 1][j + 1] = dp[i][j];
     3. p.charAt(j) == '*'
            a. p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.'--> dp[i + 1][j + 1] = dp[i + 1][j - 1]
            b. p.charAt(j - 1) == s.charAt(i) --> dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]
 */

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if(s == null || p == null)return false;
        boolean [][]dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*' && dp[0][i - 1]){
                dp[0][i + 1] = true;
            }
        }
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(s.charAt(i) == p.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if(p.charAt(j) == '.'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.'){
                        dp[i + 1][j + 1] = dp[i + 1][j  - 1];
                    }else{
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i][j + 1] || dp[i + 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[]args){
        String s1 = "aa";
        String p1 = "a";
//        Output: false

        String s2 = "aa";
        String p2 = "a*";
//        Output: true
//        Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

        String s3 = "ab";
        String p3 = ".*";
//        Output: true
//        Explanation: ".*" means "zero or more (*) of any character (.)".

        String s4 = "aab";
        String p4 = "c*a*b";
//        Output: true
//        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

        String s5 = "mississippi";
        String p5 = "mis*is*p*.";

        System.out.println(isMatch(s1,p1));
        System.out.println(isMatch(s2,p2));
        System.out.println(isMatch(s3,p3));
        System.out.println(isMatch(s4,p4));
        System.out.println(isMatch(s5,p5));
    }
}
