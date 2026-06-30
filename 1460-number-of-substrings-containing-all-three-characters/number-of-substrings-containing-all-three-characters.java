class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        int l=0;
        int[] arr = new int[3];
        for(int i=0; i<n; i++){
            arr[s.charAt(i)-'a']++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                ans+= (n-i);
                arr[s.charAt(l)-'a']--;
                l++;
            }
        }
        return ans;
    }
}