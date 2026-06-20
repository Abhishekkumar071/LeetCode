class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findL(nums, target);
        if(first==-1) return new int[]{-1, -1};
        int last = findR(nums, target);
        return new int[]{first, last};
    }
    private int findL(int[] arr, int t){
        int n = arr.length;
        int f=-1;
        int l=0; 
        int r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]>=t) r=mid-1;
            else l=mid+1;
            if(arr[mid]==t) f=mid;
        }
        return f;
    }

    private int findR(int[] arr, int t){
        int n = arr.length;
        int f=-1;
        int l=0; 
        int r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]<=t) l=mid+1;
            else r=mid-1;
            if(arr[mid]==t) f=mid;
        }
        return f;
    }
}