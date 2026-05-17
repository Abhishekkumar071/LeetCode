class Solution {
    class Pair {
        int idx;
        int val;
        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, arr[start]));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.val<0) continue;
            if(curr.val==0) return true;
            arr[curr.idx] = -2;
            int l = curr.idx-curr.val;
            int r = curr.idx+curr.val;
            
            if(l>=0) q.offer(new Pair(l, arr[l]));
            if(r<n) q.offer(new Pair(r, arr[r]));
        }
        return false;
    }
}