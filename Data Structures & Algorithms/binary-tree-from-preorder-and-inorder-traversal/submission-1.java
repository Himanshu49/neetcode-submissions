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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, preorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int sI, int eI, int sP, int eP){
        if(sI > eI){
            return null;
        }

        if(sI == eI){
            return new TreeNode(inorder[sI]);
        }

        TreeNode curr = new TreeNode(preorder[sP]);
        int posInInorder = findPosInInorder(inorder, preorder[sP], sI, eI);
        curr.left = buildTree(preorder, inorder, sI, posInInorder-1, sP+1, sP+(posInInorder-sI));
        curr.right = buildTree(preorder, inorder, posInInorder+1, eI, sP+(posInInorder-sI)+1, eP);
        return curr;
    }

    public int findPosInInorder(int[] inorder, int val, int start, int end){
        for(int i=start;i<=end;i++){
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }
}
