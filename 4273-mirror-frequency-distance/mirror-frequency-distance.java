class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int ans = 0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)) {
                char rev = (char)(9-(ch-'0')+'0');

                if(map.containsKey(ch) && map.containsKey(rev)){
                    ans += Math.abs(map.get(ch)-map.get(rev));
                    map.remove(ch);
                    map.remove(rev);
                }
                else if(map.containsKey(ch)){
                    ans += map.get(ch);
                    map.remove(ch);
                }
                else if(map.containsKey(rev)){
                    ans += map.get(rev);
                    map.remove(rev);
                }
            }
            else{
                char rev = (char)(25-(ch-'a')+'a');

                if(map.containsKey(ch) && map.containsKey(rev)){
                    ans += Math.abs(map.get(ch)-map.get(rev));
                    map.remove(ch);
                    map.remove(rev);
                }
                else if(map.containsKey(ch)){
                    ans += map.get(ch);
                    map.remove(ch);
                }
                else if(map.containsKey(rev)){
                    ans += map.get(rev);
                    map.remove(rev);
                }
            }
        }
        return ans;
    }
}