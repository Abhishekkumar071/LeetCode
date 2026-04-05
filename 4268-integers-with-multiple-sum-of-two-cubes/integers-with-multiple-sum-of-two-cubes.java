class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        int limit = (int)Math.pow(n, 1.0/3.0)+1;

        for(int i=1; i<=limit; i++){
            int i3 = i*i*i;
            for(int j=i; j<=limit; j++){
                int sum = i3+ j*j*j;

                if(sum>n) break;
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue()>=2) ans.add(e.getKey());
        }
        Collections.sort(ans);
        return ans;
    }
}