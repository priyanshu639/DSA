import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -2);
        List<Integer> order = new ArrayList<>(n);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        parent[0] = -1;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            order.add(node);
            for (int nei : adj[node]) {
                if (parent[nei] == -2) {
                    parent[nei] = node;
                    stack.push(nei);
                }
            }
        }

        long[] sumMod = new long[n];
        for (int i = 0; i < n; ++i) {
            long v = values[i];
            sumMod[i] = ((v % k) + k) % k;
        }

        int cuts = 0;
        for (int i = order.size() - 1; i >= 0; --i) {
            int node = order.get(i);
            if (node != 0 && sumMod[node] % k == 0) cuts++;
            int p = parent[node];
            if (p >= 0) sumMod[p] = (sumMod[p] + sumMod[node]) % k;
        }

        return cuts + 1;
    }
}
