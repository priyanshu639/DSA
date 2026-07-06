class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append('#');
            }

            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int res = 0;

        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append('#');
            }

            res += map.getOrDefault(sb.toString(), 0);
        }

        return res;
    }
}