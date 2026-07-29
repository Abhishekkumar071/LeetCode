class Solution {
    char[] arr = {'A', 'C', 'G', 'T'};
    int bfs(String s, String e, HashSet<String> set){
        Queue<String>  q = new LinkedList<>();
        q.offer(s);
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int ir=0; ir<size; ir++){
                String curr = q.poll();
                if(curr.equals(e)) return level;
                char[] sArr = curr.toCharArray();
                for(int i=0; i<sArr.length; i++){
                    char prev = sArr[i];
                    for(char ch: arr){
                        if(ch==prev) continue;
                        sArr[i]=ch;
                        String nn = new String(sArr);
                        // System.out.println(nn);
                        if(set.contains(nn)){
                            System.out.println(nn);
                            q.offer(nn);
                            set.remove(nn);
                        }
                        sArr[i]=prev;
                    }
                }
            }
            level++;
            
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