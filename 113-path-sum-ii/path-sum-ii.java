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
    List<List<Integer>> ans;
    void findAll(TreeNode root, List<Integer> path, int t){
        if(root==null) return;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(t==root.val){
                ans.add(new ArrayList<>(path));
            }
        }
        findAll(root.left, path, t-root.val);
        findAll(root.right, path, t-root.val);
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        findAll(root, new ArrayList<>(), targetSum);
        return ans;
    }
}