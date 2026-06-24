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
    long sum=0l;
    int countAll(TreeNode root, int t, HashMap<Long, Integer> map){
        if(root==null) return 0;
        sum+=root.val;
        int count=map.getOrDefault(sum-t, 0);
        map.put(sum, map.getOrDefault(sum, 0)+1);
      
        count+=countAll(root.left, t,map);
        count+=countAll(root.right, t, map);

        map.put(sum, map.get(sum)-1);
        if(map.get(sum)==0) map.remove(sum);
        sum-=root.val;
        return count;
    }
    public int pathSum(TreeNode root, int t) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return countAll(root, t, map);
    }
}