import java.util.*;

class Solution {

    public int[] prevSmall(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return prev;
    }

    public int[] nextSmall(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return next;
    }

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;

        int[] prev = prevSmall(arr);
        int[] next = nextSmall(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            ans = (ans + (long) arr[i] * left % MOD * right) % MOD;
        }

        return (int) ans;
    }
}