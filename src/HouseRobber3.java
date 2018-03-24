import sun.reflect.generics.tree.Tree;

/**
 * 337. House Robber III
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *    3
 *  / \
 * 2   3
 *  \   \
 *  3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *       3
 *     / \
 *    4   5
 *  / \   \
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobber3 {
    public static int rob(TreeNode root) {
        if(root == null)return 0;
        int val = 0;
        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(root.val + val,rob(root.left)+rob(root.right));
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);

        System.out.println(rob(root));
        System.out.println(rob(root2));
    }
}
