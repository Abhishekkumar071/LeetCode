class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ele : nums) {
            pq.offer(ele);
            if (pq.size() > 2) {
                pq.poll();
            }
        }

        int a = pq.poll();
        int b = pq.poll();

        return (a - 1) * (b - 1);
    }
}