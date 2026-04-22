class Solution {
    public List<String> twoEditWords(String[] qu, String[] di) {
        List<String> ans = new ArrayList<>();
        for(String q: qu){
            for(String d: di){
                int diff = 0;
                for(int i=0; i<q.length(); i++){
                    if(q.charAt(i)!=d.charAt(i)) diff++;
                    if(diff>2) break;
                }
                if(diff<=2){
                    ans.add(q);
                    break;
                }
            }
        }return ans;
    }
}