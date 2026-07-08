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
    int globalMax;
    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        dfsForMaxPathSum(root);
        return globalMax;
    }

    public int dfsForMaxPathSum(TreeNode root){
        if(root == null)
            return 0;
        int leftSum = dfsForMaxPathSum(root.left);
        int rightSum = dfsForMaxPathSum(root.right);

        globalMax = Math.max(globalMax, Math.max(root.val, Math.max(root.val+leftSum, Math.max(root.val+rightSum, root.val+leftSum+rightSum))));
        
        return Math.max(root.val+leftSum, Math.max(root.val, root.val+rightSum));
    }
}
