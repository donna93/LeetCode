/**
 * 111.MinimumDepthOfBinaryTree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 */
public class BinaryTreeLongestConsecutiveSequence {
    public static int minDepth(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 1;
        if(root.left == null || root.right == null)
            return Math.max(minDepth(root.left),minDepth(root.right)) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
