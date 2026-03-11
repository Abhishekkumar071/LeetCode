class Solution {
    public int minFlips(String s) {

        // two pattern "01...." or "10..."
        String s2 = s+s;  //for consider all rotation
        int n = s.length();
        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;
        for(int i=0; i<n; i++){
            int expect1 = (i % 2 == 0) ? 0:1;
            int expect2 = (i % 2 == 0) ? 1:0;
            if(s2.charAt(i)-'0'!=expect1)p1++;
            if(s2.charAt(i)-'0'!=expect2)p2++;
        }
        int i = 0;
        int j = n;
        while(j<2*n){
            int expect1 = (i % 2 == 0) ? 0:1;
            int expect2 = (i % 2 == 0) ? 1:0;
            if(s2.charAt(i)-'0'!=expect1)p1--;
            if(s2.charAt(i)-'0'!=expect2)p2--;

            expect1 = (j % 2 == 0) ? 0:1;
            expect2 = (j % 2 == 0) ? 1:0;
            if(s2.charAt(j)-'0'!=expect1)p1++;
            if(s2.charAt(j)-'0'!=expect2)p2++;
            ans = Math.min(ans, Math.min(p1,p2));
            i++;
            j++;
        }
        return ans;
    }
}

