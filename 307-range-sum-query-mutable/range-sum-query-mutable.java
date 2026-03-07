class NumArray {
    int[] seg;
    int n;
    private void build(int idx, int lo, int hi, int[] arr){
        if(lo==hi){
            seg[idx] = arr[lo];
            return;
        }
        int mid = (lo+hi)/2;
        build(2*idx+1, lo, mid, arr);
        build(2*idx+2, mid+1, hi, arr);
        seg[idx] = seg[2*idx+1]+seg[2*idx+2];
    }
    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4*n];
        build(0, 0, n-1, nums);
    }

    public void update(int idx, int val) {
        updateTree(0, 0, n-1, idx, val);
    }
    private void updateTree(int idx, int lo, int hi, int index, int val){
        if(lo==hi){
            seg[idx]=val;
            return;
        }
        int mid = (lo + hi)/2;
        if(index <= mid){
            updateTree(2*idx + 1, lo, mid, index, val);
        }
        else{
            updateTree(2*idx + 2, mid+1, hi, index, val);
        }
    
        // update parent
        seg[idx] = seg[2*idx + 1] + seg[2*idx + 2];
    }

    public int sumRange(int l, int r) {
        return query(0, 0, n-1, l, r);
    }
    private int query(int idx, int lo, int hi, int l, int r){
        if(hi<l || lo>r){
            return 0;
        }
        if(lo>=l && hi<=r){
            return seg[idx];
        }

        int mid = (lo+hi)/2;
        int left = query(2*idx+1, lo, mid, l, r);
        int right = query(2*idx+2, mid+1, hi, l, r);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */