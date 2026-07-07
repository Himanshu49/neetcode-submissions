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
    int kthSmallest=0, count=0;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return kthSmallest;
    }

    public void kthSmallestHelper(TreeNode root, int k){
        if(root == null){
            return;
        }
        // if(count == k-1){
        //     kthSmallest = root.val;
        //     return;
        // }

        // move left
        kthSmallestHelper(root.left, k);
        if(count == k-1){
            kthSmallest = root.val;
            count++;
        }

        count++;

        // move right
        kthSmallestHelper(root.right, k);
    }
}
