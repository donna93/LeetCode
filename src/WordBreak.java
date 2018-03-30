import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing
 * a list of non-empty words, determine if s can be segmented into
 * a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.

 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].

 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[]dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[]args){
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        list.add("zhang");
        list.add("dandan");
        String s1 = "zhangdandan";
        System.out.println(wordBreak(s,list));
        System.out.println(wordBreak(s1,list));
    }
}
