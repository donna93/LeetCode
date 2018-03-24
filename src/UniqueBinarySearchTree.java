/**
 * 96. Unique Binary Search Trees
 * Given n, how many structurally
 * unique BST's (binary search trees) that store values 1...n?

   For example,
   Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
    3     2     1      1   3      2
   /     /       \                 \
  2     1         2                 3

   point:
   f(n) = f(0)*f(n - 1) + f(1)*f(n - 2) + f(2)*f(n - 3)...+f(n - 2)*f(1) + f(n - 1)*f(0);
 */
public class UniqueBinarySearchTree {
    public static int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
    public static void main(String[]args){
        System.out.println(numTrees(3));
    }
}
