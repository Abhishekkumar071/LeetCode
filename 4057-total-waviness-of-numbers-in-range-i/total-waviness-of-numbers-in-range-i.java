class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int j=num1; j<=num2; j++){
            String str = Integer.toString(j);
            int n = str.length();
            if(n>=3){
                int count=0;
                for(int i=1; i<n-1; i++){
                    int f = str.charAt(i-1)-'0';
                    int m = str.charAt(i)-'0';
                    int s = str.charAt(i+1)-'0';
                    if((f<m&&s<m)||(f>m&&s>m)) count++;
                }
                ans+=count;
            }
        }
        return ans;
    }
}