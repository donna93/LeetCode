/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money
 of each house, determine the maximum amount of money you can rob tonight
 without alerting the police.
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int prevNo = 0;
        int curYes = 0;
        for(int num: nums){
            int temp = prevNo;
            prevNo = Math.max(prevNo, curYes);
            curYes = num + temp;
        }
        return Math.max(prevNo, curYes);
    }
    public static void main(String[]args){
        int[]nums = {100, 1, 1, 100};
        System.out.println(rob(nums));
    }
}
