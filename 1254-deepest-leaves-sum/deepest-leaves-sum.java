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
    int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    void solve(TreeNode root, int l, int h, int[] sum){
        if(root==null) return;

        if(l==h) sum[0]+=root.val;
        solve(root.left, l+1, h, sum);
        solve(root.right, l+1, h, sum);
    }
    public int deepestLeavesSum(TreeNode root) {
        int h = height(root);
        int[] sum=new int[1];
        solve(root, 1, h, sum);
        return sum[0];
    }
}