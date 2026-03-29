class Solution {
    public int minChanges(String s) {
        int n = s.length();

        int[] zero = new int[n];
        int[] one = new int[n];
        if (s.charAt(0) == '1')
            one[0] = 1;
        else
            zero[0] = 1;

        for (int i = 1; i < n; i++) {
            zero[i] = zero[i - 1];
            one[i] = one[i - 1];

            if (s.charAt(i) == '1')
                one[i]++;
            else
                zero[i]++;
        }

        int ans = 0, to = one[n - 1], tz = zero[n - 1];

        if (to == n || tz == n)
            return 0;

        ans = Math.min(to, tz);
        // for (int i = 1; i < n; i += 2) {
        //     ans = Math.min(ans,
        //             Math.min(zero[i], one[i]) + Math.min(tz - zero[i], to - one[i]));
        // }
        for(int p=2; p<n; p+=2){
            int cur = 0;
            if(n%p!=0) continue;
            for(int i=p-1; i<n; i+=p){
                if(i<p)cur += Math.min(one[i], zero[i]);

                else cur += Math.min(one[i]-one[i-p], zero[i]-zero[i-p]);
                // System.out.println(cur);
            }
            ans = Math.min(ans, cur);
        }
        // System.out.println(Arrays.toString(zero));
        // System.out.println(Arrays.toString(one));
        return ans;
    }
}