import java.util.*;
/**
 * 107.BinaryTreeLevelOrderTraversal
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversal2 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        if(root == null)return res;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null)queue.offer(cur.left);
                if(cur.right != null)queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(0, list);
        }return res;
    }

    public static List<List<Integer>> levelOrderBottom2(TreeNode root){
        List<List<Integer>>res = new ArrayList<>();
        if(root == null)return res;
        helper(res,0,root);
        return res;
    }
    public static void helper(List<List<Integer>>res, int level, TreeNode root){
        if(root == null)return;
        if(level >= res.size()){
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level - 1).add(root.val);
        helper(res, level + 1, root.left);
        helper(res, level + 1, root.right);
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

        System.out.println(levelOrderBottom(root).toString());
        System.out.println(levelOrderBottom(root2).toString());
        System.out.println(levelOrderBottom2(root2).toString());
    }
}
