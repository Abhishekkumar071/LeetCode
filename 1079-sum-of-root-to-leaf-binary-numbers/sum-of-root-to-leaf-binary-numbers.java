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
    private void findAllPath(TreeNode root, ArrayList<String> arr, StringBuilder sb){
        if(root==null)return;
        sb.append(Integer.toString(root.val));
        if(root.left==null && root.right==null){
            arr.add(sb.toString());
        }
        else{
            findAllPath(root.left, arr,  sb);
            findAllPath(root.right, arr, sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> arr = new ArrayList<>();
        findAllPath(root, arr, new StringBuilder());
        // System.out.println(arr);
        int sum = 0;
        for(String s : arr) {
            sum += Integer.parseInt(s, 2); // base 2 conversion
        }
        return sum;
    }
}