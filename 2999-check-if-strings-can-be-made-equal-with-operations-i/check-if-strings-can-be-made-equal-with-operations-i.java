class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        for(int i=0; i<4; i++){
            if(s1.charAt(i)!=s2.charAt(i)&&s1.charAt(i)!=s2.charAt((i+2)%4)) return false;

            // if(s1.charAr)
        }
        return true;
    }
}