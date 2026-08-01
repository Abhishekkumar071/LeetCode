class Solution {
    class Pair{
        int sum,r,c;
        Pair(int r,int c,int sum){
            this.r=r;this.c=c;this.sum=sum;
        }
        Pair(){}
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                return a.sum-b.sum;
            }
        );
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        pq.add(new Pair(0,0,nums1[0]+nums2[0]));
        set.add("0,0");
        while(k>0){
            k--;
            Pair p=pq.poll();
            List<Integer> temp=new ArrayList<>();
            temp.add(nums1[p.r]);temp.add(nums2[p.c]);
            ans.add(temp);
            int i=p.r,j=p.c;
            String a = (i + 1) + "," + j;
            String b = i + "," + (j + 1);
            if(i<nums1.length-1 && !set.contains(a)) {
                set.add(a);
                pq.add(new Pair(p.r+1,p.c,nums1[p.r+1]+nums2[p.c]));
            }
            if(j<nums2.length-1 && !set.contains(b)) {
                set.add(b);
                pq.add(new Pair(p.r,p.c+1,nums1[p.r]+nums2[p.c+1]));
            }
        }
        return ans;
    }
}