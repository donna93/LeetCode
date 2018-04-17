import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums
 being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int res = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[res - 2]){
                nums[res++] = nums[i];
            }
        }
        return res;
    }
    public static void main(String[]args){
        int[]nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
