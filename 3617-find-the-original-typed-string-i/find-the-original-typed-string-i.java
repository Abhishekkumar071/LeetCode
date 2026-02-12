class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        int n = word.length();
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            int len = j - i;
            if (len >= 2) {
                count += (len - 1); 
            }
            i = j;
        }

        return count ;
    }
}
