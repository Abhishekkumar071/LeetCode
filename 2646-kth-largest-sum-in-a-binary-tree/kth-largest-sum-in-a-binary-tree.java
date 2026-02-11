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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Long> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                sum += (long)temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            ans.add(sum);
        }
        Collections.sort(ans);
        if (ans.size() < k) return -1;
        return ans.get(ans.size()-k);
    }
}