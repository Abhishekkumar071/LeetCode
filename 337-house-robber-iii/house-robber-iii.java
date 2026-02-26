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
    private int maxMoney(TreeNode root, HashMap<TreeNode, Integer> memo){
        if(root == null) return 0;

        if(memo.containsKey(root)){
            return memo.get(root);
        }

        // not take current node
        int not = maxMoney(root.left, memo) + maxMoney(root.right, memo);

        // take current node
        int take = root.val;

        if(root.left != null) {
            take += maxMoney(root.left.left, memo);
            take += maxMoney(root.left.right, memo);
        }

        if(root.right != null) {
            take += maxMoney(root.right.left, memo);
            take += maxMoney(root.right.right, memo);
        }

        int maxxx = Math.max(take, not);
        memo.put(root, maxxx);

        return maxxx;
    }
    
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return maxMoney(root, memo);
    }
}