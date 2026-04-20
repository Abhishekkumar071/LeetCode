class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int a = 0;
        int b=0;
        for(int i=1; i<n-1; i++){
            if(colors.charAt(i)=='A' && colors.charAt(i-1)=='A' && colors.charAt(i+1)=='A') a++;
            if(colors.charAt(i)=='B' && colors.charAt(i-1)=='B' && colors.charAt(i+1)=='B') b++;
        }
        return a>b;
    }
}