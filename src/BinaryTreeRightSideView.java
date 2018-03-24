import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 * For example:
 * Given the following binary tree,
       1            <---
     /   \
    2     3         <---
    \     \
     5     4       <---
    You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer>res = new ArrayList<>();
        if(root == null)return res;
        helper(res, root, 0);
        return res;
    }
    public static void helper(List<Integer>res, TreeNode root, int level){
        if(root == null)return;
        if(level == res.size()){
            res.add(root.val);
        }
        helper(res,root.right,level + 1);
        helper(res, root.left, level +1);
    }
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(i == 0)res.add(cur.val);
                if(cur.right != null)queue.offer(cur.right);
                if(cur.left != null)queue.offer(cur.left);
            }
        }return res;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);root.right = new TreeNode(2);
        root.left.left = new TreeNode(3); root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4); root.left.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9); root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15); root2.right.right = new TreeNode(7);

        System.out.println(rightSideView2(root2));
        System.out.println(rightSideView2(root));
        System.out.println(rightSideView(root2));
        System.out.println(rightSideView(root));
    }
}
