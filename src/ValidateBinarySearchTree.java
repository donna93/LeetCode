import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).

   Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.
   Example 1:
       2
     / \
    1   3
   Binary tree [2,1,3], return true.
   Example 2:
       1
     / \
    2   3
   Binary tree [1,2,3], return false.
 */
public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        List<Integer>res = new ArrayList<>();
        res = preorder(root);
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < i; j++){
                if(res.get(i) > res.get(j))return false;
            }
        }return true;
    }
    public static List<Integer> preorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null)return list;
        list.addAll(preorder(root.left));
        list.add(root.val);
        list.addAll(preorder(root.right));
        return list;
    }

    public static boolean isValidBST2(TreeNode root){
        if(root == null)return true;
        return helper(root, null, null);
    }
    public static boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null)return true;
        if(min != null && min <= root.val)return false;
        if(max != null && max >= root.val)return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
        System.out.println(isValidBST2(root));

        TreeNode root2 = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root2));
        System.out.println(isValidBST2(root2));
    }
}
