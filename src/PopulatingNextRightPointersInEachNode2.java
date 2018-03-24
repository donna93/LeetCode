/**
 * 17.PopulatingNextRightPointersInEachNode
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 *
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *       1
 *     /  \
 *    2    3
 *   / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 *
 */
public class PopulatingNextRightPointersInEachNode2 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        while(cur != null){
            while(cur != null){
                if(cur.left != null){
                    if(pre != null){
                        pre.next = cur.left;
                    }else head = cur.left;
                    pre = cur.left;
                }
                if(cur.right != null){
                    if(pre != null){
                        pre.next = cur.right;
                    }else head = cur.right;
                    pre = cur.right;
                }cur = cur.next;
            }
            cur = head;
            head = null;
            pre = null;
        }
    }
}
