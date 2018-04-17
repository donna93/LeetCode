import java.util.Arrays;

/**
 * 27. Remove Element
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying
 the input array in-place with O(1) extra memory.
 The order of elements can be changed. It doesn't matter what you leave beyond
 the new length.

 Example 1:
   Given nums = [3,2,2,3], val = 3,
   Your function should return length = 2, with the first two elements of nums being 2.
   It doesn't matter what you leave beyond the returned length.

 Example 2:
   Given nums = [0,1,2,2,3,0,4,2], val = 2,
   Your function should return length = 5, with the first five elements of nums
   containing 0, 1, 3, 0, and 4.
   Note that the order of those five elements can be arbitrary.

 注意返回的是新数组的长度 和 其前两个值。

  */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)return 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[res++] = nums[i];
            }
        }
        return res;
    }
    public static void main(String[]args){
        int[]nums1 = {3,2,2,3};
        int val1 = 3;
        System.out.println(removeElement(nums1,val1));
        System.out.println(Arrays.toString(nums1));

        int[]nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;
        System.out.println(removeElement(nums2,val2));
        System.out.println(Arrays.toString(nums2));
    }
}
