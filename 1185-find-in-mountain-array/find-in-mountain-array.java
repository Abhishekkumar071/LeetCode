/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int n = arr.length();
        int l = 0;
        int r = n-1;
        while(l!=r){
            int mid = l+(r-l)/2;
            if(arr.get(mid)<arr.get(mid+1)) l=mid+1;
            else r=mid;
        }
        int top=r;
        l=0;
        while(l!=r){
            int mid = l+(r-l)/2;
            int a = arr.get(mid);
            if(a==target) return mid;
            else if(a<target) l=mid+1; //ascen.
            else if(a>target) r=mid;
        }
        if(arr.get(l) == target) return l;
        l=top+1; r=n-1;
        while(l != r){
            int mid = l + (r - l) / 2;
            int a = arr.get(mid);
            if(a == target) return mid;
            else if(a > target) l = mid + 1; //desc
            else r = mid;                    
        }
        if(l < n && arr.get(l) == target) return l;

        return -1;
    }
}