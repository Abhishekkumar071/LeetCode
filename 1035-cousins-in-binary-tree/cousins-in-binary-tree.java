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
    int l;
    public boolean isCousins(TreeNode root, int x, int y) {
        l=0;
        level(root, x, 0);
        int l1=l;
        l=0;
        level(root,y, 0);
        return (l1==l) && !sameParent(root, x, y);
    }
    
    void level(TreeNode root, int x, int lvl){
        if(root==null) return;
        if(root.val==x){
            l=lvl;
            return;
        } 
        level(root.right, x, lvl+1);
        level(root.left, x, lvl+1);
    }
    boolean sameParent(TreeNode root, int x, int y){
        if(root==null) return false;

        if(root.left!=null && root.right!=null){
            if((root.left.val==x && root.right.val==y)||(root.left.val==y&& root.right.val==x)) return true;
        }
        return sameParent(root.left, x, y)||sameParent(root.right, x, y);
    }
}