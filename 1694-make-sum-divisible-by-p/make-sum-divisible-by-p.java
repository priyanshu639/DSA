class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;

        int rem = (int)(total % p);
        if (rem == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // important base case

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            // what prefix do we need?
            int need = (int)((prefix - rem + p) % p);

            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }

            map.put((int)prefix, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}
