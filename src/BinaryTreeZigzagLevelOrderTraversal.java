import java.util.*;
/**
 * 103.BinaryTreeZigzagLevelOrderTraversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        if(root == null)return res;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        int signal = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null)queue.offer(cur.left);
                if(cur.right != null)queue.offer(cur.right);
                if(signal == 1){
                    list.add(cur.val);
                }else{
                    list.add(0,cur.val);
                }
//                list.add(cur.val);
            }res.add(list);
            if (signal == 1) {
                signal = -1;
            }else{
                signal = 1;
            }
        }return res;
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

        System.out.println(zigzagLevelOrder(root).toString());
        System.out.println(zigzagLevelOrder(root2).toString());
//        System.out.println(levelOrderBottom2(root2).toString());
    }
}
