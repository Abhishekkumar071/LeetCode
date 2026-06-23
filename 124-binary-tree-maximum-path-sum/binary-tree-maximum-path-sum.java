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
    int ans = Integer.MIN_VALUE;
    private int max(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        int left = max(root.left);
        int right = max(root.right);
        if(left<0) left=0;
        if(right<0) right=0;
        ans = Math.max(ans, root.val+left+right);
        return root.val+Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        max(root);
        return ans;
    }
}