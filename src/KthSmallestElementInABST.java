import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to
 * find the kth smallest element in it.

    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Follow up:
    What if the BST is modified (insert/delete operations) often and
    you need to find the kth smallest
    frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInABST {
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer>list = new ArrayList<>();
        list = preorder(root);
        return list.get(k - 1);

    }
    public static List<Integer> preorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null)return list;
        list.addAll(preorder(root.left));
        list.add(root.val);
        list.addAll(preorder(root.right));
        return list;
    }
}
