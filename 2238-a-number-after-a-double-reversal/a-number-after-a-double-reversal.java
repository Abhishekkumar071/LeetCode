class Solution {
    public boolean isSameAfterReversals(int num) {
        String s = Integer.toString(num);
        if(num==0) return true;
        else if(s.charAt(s.length() - 1)=='0')return false;
        else return true;
    }
}