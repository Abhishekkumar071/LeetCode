class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] f = new int[26];
        int[] s = new int[26];

        int n = s1.length();
        for(int i=0; i<n; i++)if(i%2==0) f[s1.charAt(i)-'a']++;

        for(int i=0; i<n; i++) if(i%2==0) s[s2.charAt(i)-'a']++;

        for(int i=0; i<26; i++) if(f[i]!=s[i])return false;

        Arrays.fill(f,0);
        Arrays.fill(s,0);
        for(int i=0; i<n; i++) if(i%2==1) f[s1.charAt(i)-'a']++;

        for(int i=0; i<n; i++) if(i%2==1) s[s2.charAt(i)-'a']++;

        for(int i=0; i<26; i++) if(f[i]!=s[i])return false;

        return true;
   
    }
}