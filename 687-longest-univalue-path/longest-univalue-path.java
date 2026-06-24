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
    int mx=0;
    int find(int v, TreeNode root){
        if(root==null) return 0;
        if(root.val!=v) return 0;
        int left = find(v, root.left);
        int right = find(v,root.right);
        mx = Math.max(mx, left+right);
        return 1+Math.max(left, right);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        int curr = find(root.val, root);
        mx = Math.max(mx, curr-1);
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);
        return mx;
    }
}