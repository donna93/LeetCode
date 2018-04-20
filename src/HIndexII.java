/**
 * 275. H-Index II
 Follow up for H-Index: What if the citations array is sorted in
 ascending order? Could you optimize your algorithm?

 用二分法，时间复杂度可得到优化
 example: [0, 1, 4, 5, 6]
 time: O(logn) space: O(1)
 */
public class HIndexII {
    public static int hIndex(int[] citations) {

        int len = citations.length;
        int start = 0; int end = citations.length - 1;
        while(start <= end){
            int mid = (end - start) / 2 + start;
            if(citations[mid] == len - mid ){
                return len - mid;
            }else if(citations[mid] > len - mid){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return len - start;
    }
    public static void main(String[]args){
        int[]citations = {0, 1, 4, 5, 6};
        System.out.println(hIndex(citations));
    }
}
