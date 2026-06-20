class Solution {
    public List<Integer> goodDaysToRobBank(int[] s, int t) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length;
        if(t==0){
            for(int i=0; i<n; i++)ans.add(i);
            return ans;
        }
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=1; i<n; i++){
            if(s[i]<=s[i-1]) left[i]=left[i-1]+1;
        }
        for(int i=n-2; i>=0; i--){
            if(s[i]<=s[i+1]) right[i]=right[i+1]+1;
        }

        for(int i=t; i<n-t; i++){
            if(left[i]>=t && right[i]>=t) ans.add(i);
        }
        return ans;
    }
}