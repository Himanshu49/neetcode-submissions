/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    class Temp{
        int depth;
        boolean isBalanced;
        public Temp(int d,  boolean val)
        {
            depth = d;
            isBalanced = val;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        Temp res = isBalancedHelper(root);
        return res.isBalanced;
    }

    public Temp isBalancedHelper(TreeNode root) {
        if(root == null)
        {
            return new Temp(0,true);
        }
        Temp leftTree = isBalancedHelper(root.left);
        Temp rightTree = isBalancedHelper(root.right);
        Temp res = new Temp(Math.abs(leftTree.depth - rightTree.depth), false);
        if(!leftTree.isBalanced || !rightTree.isBalanced)
            return res;
        
        if(res.depth > 1)
            return res;
        res.isBalanced = true;
        res.depth = Math.max(leftTree.depth, rightTree.depth) +1;
        return res;
    }

}
