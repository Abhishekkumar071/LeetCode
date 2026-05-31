class Solution {
    public boolean asteroidsDestroyed(int mas, int[] as) {
        Arrays.sort(as);
        long mass =mas;
        for(int i=0; i<as.length; i++){
            if(as[i]>mass) return false;
            mass+=as[i];
        }
        return true;
    }
}