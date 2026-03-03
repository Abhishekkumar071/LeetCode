class Solution {
    public int findKthLargest(int[] arr, int k) {
        int target = arr.length - k;
        int l = 0, r = arr.length - 1;
        
        while (l <= r) {
            
            int pivot = arr[l];
            
            int lt = l;      // less than pivot
            int gt = r;      // greater than pivot
            int i = l;
            
            while (i <= gt) {
                if (arr[i] < pivot) {
                    swap(arr, i++, lt++);
                } 
                else if (arr[i] > pivot) {
                    swap(arr, i, gt--);
                } 
                else {
                    i++;
                }
            }
            
            if (target < lt) {
                r = lt - 1;
            } 
            else if (target > gt) {
                l = gt + 1;
            } 
            else {
                return arr[target];
            }
        }
        return -1;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}