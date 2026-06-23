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
    int sum=0;
    void solve(TreeNode root, int s){
        if(root==null)return;
        if(root.left==null && root.right==null){
            sum += (s*10+root.val);
        }
        solve(root.left, s*10+root.val);
        solve(root.right, s*10+root.val);
    }
    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        return sum;
    }
}