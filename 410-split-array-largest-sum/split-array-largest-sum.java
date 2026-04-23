class Solution {
    private boolean cheack(int[] arr, int k, int i1){
        int s=1;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            if(sum+arr[i]<=i1){
                sum+= arr[i];
            }
            else{
                s++;
                sum=arr[i];
            }
        }
        return (s<=k);
    }
    public int splitArray(int[] arr, int k) {
        int n = arr.length;
        if(n<k) return -1;
        
        int min =Integer.MIN_VALUE;
        int max = 0;
        for(int ele: arr){
            if(min<ele) min=ele;
            max+=ele;
        }
        
        int res = -1;
        while(min<=max){
            int mid = ((max+min)/2);
            if(cheack(arr, k, mid)){
                res=mid;
                max = mid-1;
            }
            else min=mid+1;
        }
        return res;
    }
}