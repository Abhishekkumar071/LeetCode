/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean findPath(TreeNode root, TreeNode tar, List<TreeNode> path){
        if(root==null) return false;
        path.add(root);
        if(root==tar) return true;

        if(findPath(root.left, tar, path)||
        findPath(root.right, tar, path)) return true;

        else{
            path.remove(path.size()-1);
            return false;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        TreeNode lca = null;

        for(int i=0; i<Math.min(pPath.size(), qPath.size()); i++){
            if(pPath.get(i)==qPath.get(i)) lca=pPath.get(i);
            else break;
        }
        return lca;
    }
}