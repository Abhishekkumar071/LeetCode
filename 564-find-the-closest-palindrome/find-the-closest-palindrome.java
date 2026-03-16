class Solution {
    private long func(long l, boolean even){
        long val = l;
        if(!even) l/=10;
        while(l>0){
            val = val*10 + l%10;
            l/=10;
        }
        System.out.println(val);
        return val;
    }
    public String nearestPalindromic(String n) {
        List<Long> arr = new ArrayList<>();
        int len = n.length();
        long l = Long.parseLong(n.substring(0, len%2==0? len/2: (len/2)+1));
        
        arr.add(func(l, len%2==0));
        arr.add(func(l+1, len%2==0));
        arr.add(func(l-1, len%2==0));
        arr.add((long)Math.pow(10, len)+1);
        arr.add((long)Math.pow(10, len-1)-1);

        long diff = Long.MAX_VALUE;
        long original = Long.parseLong(n);
        long ans = 0L;
        for(long val: arr){
            if(val==original) continue;
            if(Math.abs(val-original)<diff){
                diff = Math.abs(val-original);
                ans = val;
            }
            if(Math.abs(val-original)==diff){
                ans = Math.min(ans, val);
            }
        }
        return String.valueOf(ans);
    }
}