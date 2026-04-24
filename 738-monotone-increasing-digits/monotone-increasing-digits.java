class Solution {
    public int monotoneIncreasingDigits(int n) {
        if (yes(n)) return n;

        char[] s = Integer.toString(n).toCharArray();
        int len = s.length;

        for (int i = len - 1; i > 0; i--) {
            int a = s[i] - '0';
            int b = s[i - 1] - '0';

            if (b > a) {
                s[i - 1] = (char)(b - 1 + '0');
                for (int j = i; j < len; j++) {
                    s[j] = '9';
                }
            }
        }

        return Integer.parseInt(new String(s));
    }

    // assuming this checks if digits are already monotone increasing
    boolean yes(int n) {
        String s = Integer.toString(n);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) return false;
        }
        return true;
    }
}