/**
 * 41. First Missing Positive
 * Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:
    Input: [1,2,0]
    Output: 3

 Example 2:
    Input: [3,4,-1,1]
    Output: 2

 Example 3:
    Input: [7,8,9,11,12]
    Output: 1
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)return 1;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                return i + 1;
            }
        }
        return nums.length;
    }
    public static void main(String[]args){
        int[]input1 = {1,2,0};
        int[]input2 = {3,4,-1,1};
        int[]input3 = {7,8,9,11,12};

        System.out.println(firstMissingPositive(input1));
        System.out.println(firstMissingPositive(input2));
        System.out.println(firstMissingPositive(input3));
    }
}
