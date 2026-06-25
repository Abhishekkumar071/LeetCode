/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    void addAll(Node root, List<List<Integer>> ans, int l){
        if(root==null) return;
        if(l==ans.size()) ans.add(new ArrayList<>());
        ans.get(l).add(root.val);
        for(Node c: root.children){
            addAll(c, ans, l+1);
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        addAll(root, ans, 0);
        return ans;
    }
}