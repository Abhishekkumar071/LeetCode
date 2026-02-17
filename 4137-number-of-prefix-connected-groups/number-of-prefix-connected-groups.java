class Solution {
    public int prefixConnected(String[] words, int k) {
        int ans = 0;
        int n = words.length;
        boolean[] added = new boolean[n];
        for(int i=0; i<n; i++){
            if(words[i].length()<k) continue;
            String sub = words[i].substring(0, k);
            if(!added[i]){
                boolean found = false;
                added[i]=true;
                for(int j=i+1; j<n; j++){
                    if(words[j].length()<k) continue;
                    String sub1 = words[j].substring(0, k);
                    if(sub.equals(sub1)){
                        added[j]=true;
                        found=true;
                    }
                }
                if(found){
                    found=false;
                    ans++;
                }
            }
        }
        return ans;
    }
}