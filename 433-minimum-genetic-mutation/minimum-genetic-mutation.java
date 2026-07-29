class Solution {
    public class Pair{
        String s;
        int l;
        Pair(String s, int l){
            this.s=s;
            this.l=l;
        }
    }
    char[] arr = {'A', 'C', 'G', 'T'};
    int bfs(String s, String e, HashSet<String> set){
        Queue<Pair>  q = new LinkedList<>();
        q.offer(new Pair(s, 0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String newS = curr.s;
            int level = curr.l;
            if(newS.equals(e)) return level;
            char[] sArr = newS.toCharArray();
            for(int i=0; i<sArr.length; i++){
                char prev = sArr[i];
                for(char ch: arr){
                    sArr[i]=ch;
                    String nn = new String(sArr);
                    // System.out.println(nn);
                    if(set.contains(nn)){
                        System.out.println(nn);
                        q.offer(new Pair(nn, level+1));
                        set.remove(nn);
                    }
                    sArr[i]=prev;
                }
            }
        }
        return -1;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for(String s: bank) set.add(s);
        if(!set.contains(endGene)) return -1;
        return bfs(startGene, endGene, set);
    }
}