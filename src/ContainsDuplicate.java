import java.util.Arrays;
import java.util.HashSet;

/**
 * 217. Contains Duplicate
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice
 in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i]))return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1])return true;
        }return false;
    }
}
