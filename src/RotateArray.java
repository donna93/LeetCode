import java.util.Arrays;

/**
 * 189. Rotate Array
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int[]temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }
    public static void rotate2(int[] nums, int k){
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
    public static void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[]args){
        int[]nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        int[]nums1 = {1,2,3,4,5,6,7};
        int k2 = 3;
        rotate2(nums1,k2);
        System.out.println(Arrays.toString(nums1));
    }
}
