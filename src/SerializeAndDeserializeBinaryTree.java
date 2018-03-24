import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * For example, you may serialize the following tree
        1
      / \
    2   3
       / \
      4   5
   as "[1,2,3,null,null,4,5]"
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null)return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                res.append("null ");
                continue;
            }
            res.append(cur.val + " ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == "")return null;
        String[]res = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(res[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 0; i < res.length; i++){
            TreeNode cur = queue.poll();
            if(!res[i].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(res[i]));
                queue.offer(cur.left);
            }
            if(!res[++i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(res[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);root.right = new TreeNode(2);
        root.left.left = new TreeNode(3); root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4); root.left.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9); root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15); root2.right.right = new TreeNode(7);

        System.out.println(serialize(root2));
        System.out.println(serialize(root));
    }
}
