class Solution {
    public int prefixConnected(String[] words, int k) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(String word: words){
            if(word.length()>=k){
                String sub = word.substring(0, k);
                map.put(sub, map.getOrDefault(sub, 0)+1);
            }
        }
        for(int val: map.values()){
            if(val>=2) ans++;
        }
        return ans;
    }
}