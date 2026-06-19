class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int i=0;
        while(i+1<n && arr[i]<arr[i+1])i++;
        return i;
    }
}