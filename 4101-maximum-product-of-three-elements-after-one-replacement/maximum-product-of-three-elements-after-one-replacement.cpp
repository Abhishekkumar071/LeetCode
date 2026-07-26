class Solution {
public:
    long long maxProduct(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int c = 1e5;
        int n = nums.size();
        long long aa = (long long)nums[n-1]*nums[n-2]*c;
        long long bb = (long long)nums[n-1]*nums[0]*-c;
        long long cc = (long long)nums[0]*nums[1]*c;
        return max(aa, max(bb, cc));
    }
};