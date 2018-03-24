import java.util.Stack;

/**
 * 173.Binary Search Tree Iterator
   Implement an iterator over a binary search tree (BST).
   Your iterator will be initialized with the root node of a BST.

   Calling next() will return the next smallest number in the BST.

   Note: next() and hasNext() should run in average O(1) time and
   uses O(h) memory, where h is the height of the tree.

 * point: cur = cur.right;
 */
public class BinarySearchTreeIterator {
    public class BSTIterator {
        private TreeNode cur;
        private Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            while(!stack.isEmpty() || cur != null)
                return true;
            return false;
        }

        /** @return the next smallest number */
        public int next() {
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }
    }
}
