class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                boolean isBalance = true;
                int past=-1;
                for(int v: map.values()){
                    if(past==-1) past = v;
                    if(past!=v) isBalance = false;
                }
                if(isBalance){
                    ans=Math.max(ans, j-i+1);
                }
            }
            map.clear();
        }
        return ans;
    }
}