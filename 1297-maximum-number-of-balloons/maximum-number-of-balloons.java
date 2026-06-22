class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('b',0);
        map.put('o',0);
        map.put('n',0);
        map.put('l',0);
        for(char ch: text.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            char ch = e.getKey();
            int v = e.getValue();
            if(ch=='l' || ch=='o') v/=2;
            ans=Math.min(ans, v);
        }
        return ans;
    }
}