/**
 * 70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct
 * ways can you climb to the top?

 * Note: Given n will be a positive integer.
     Example 1:
     Input: 2
     Output:  2
     Explanation:  There are two ways to climb to the top.
     1. 1 step + 1 step
     2. 2 steps


     Example 2:
     Input: 3
     Output:  3
     Explanation:  There are three ways to climb to the top.
     1. 1 step + 1 step + 1 step
     2. 1 step + 2 steps
     3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n <= 2){
            return n;
        }else{
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
    public static int climbStairs2(int n){
        if(n == 1)return 1;
        int oneStep = 1, twoStep = 1, res = 0;
        for(int i = 2; i <= n; i++){
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }
        return res;
    }
    public static void main(String[]args){
        System.out.println(climbStairs(2));
        System.out.println(climbStairs2(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs2(3));
    }
}
