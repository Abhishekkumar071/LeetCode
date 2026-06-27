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
    boolean is(TreeNode root, int v){
        if(root==null) return true;
        if(root.val!=v) return false;
        return is(root.left, v) && is(root.right, v);
    }
    public boolean isUnivalTree(TreeNode root) {
        return is(root, root.val);
    }
}