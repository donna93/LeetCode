

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

   According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
   two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow
   a node to be a descendant of itself).”

                _______3______
               /              \
           ___5__          ___1__
         /      \        /      \
        6      _2       0       8
             /  \
            7   4
   For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of
   nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorOfABianryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)return root;
        return left == null ? right : left;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);



        System.out.println(lowestCommonAncestor(root, root.left ,root.right).val);
        System.out.println(lowestCommonAncestor(root, root.left.right,root.left.left).val);
        System.out.println(lowestCommonAncestor(root, root.left,root.left.right.right).val);
    }
}
