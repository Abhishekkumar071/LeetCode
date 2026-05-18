class Solution {
    public int minJumps(int[] arr) {
        int step = 1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        if(n==1) return 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        q.offer(0);
        while (!q.isEmpty()) {
            int nn = q.size();
            for (int ss = 0; ss < nn; ss++) {
                int curr = q.poll();
                int left = curr - 1;
                int right = curr + 1;
                if (left == n - 1 || right == n - 1)
                    return step;
                if (left > 0 && !vis[left]) {
                    q.offer(left);
                    vis[left] = true;
                }
                if (right < n && !vis[right]) {
                    vis[right] = true;
                    q.offer(right);
                }
                if (map.containsKey(arr[curr])) {
                    for (int ele : map.get(arr[curr])) {
                        if (ele == n - 1)
                            return step;
                        if (!vis[ele])
                            q.offer(ele);
                        vis[ele] = true;

                    }
                }
                map.remove(arr[curr]);
            }
            step++;
        }
        return 1;
    }
}