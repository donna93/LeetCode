/**
 * 45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at
 * the first index of the array.

 Each element in the array represents your maximum jump length at that position.
 Your goal is to reach the last index in the minimum number of jumps.

 Example:
 Input: [2,3,1,1,4]
 Output: 2

 Explanation: The minimum number of jumps to reach the last index is 2.
 Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Note:
 You can assume that you can always reach the last index.
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        if(nums == null || nums.length < 2)return 0;
        int curMaxArea = 0;
        int maxArea = 0;
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxArea = Math.max(maxArea, nums[i] + i);
            if(i == curMaxArea){
                res++;
                curMaxArea = maxArea;
            }
        }
        return res;
    }
    public static int jump2(int[]nums){
        if(nums == null || nums.length < 2)return 0;
        int curMaxArea = 0;
        int level = 0;
        int maxArea = 0;
        int i = 0;
        while(curMaxArea - i + 1 > 0){
            level++;
            for(; i <= curMaxArea; i++){
                maxArea = Math.max(maxArea, nums[i] + i);
                if(maxArea >= nums.length - 1){
                    return level;
                }
            }
            curMaxArea = maxArea;
        }return 0;
    }
    public static void main(String[]args){
        int[]nums1 = {2,3,1,1,4};
        int[]nums2 = {3,6,1,1,1,1,1,1,1,1,1};
        System.out.println(jump(nums1));
        System.out.println(jump(nums2));
        System.out.println(jump2(nums1));
        System.out.println(jump2(nums2));
    }
}
