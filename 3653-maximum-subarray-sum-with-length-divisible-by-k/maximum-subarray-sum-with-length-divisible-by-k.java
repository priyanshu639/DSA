class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minPref = new long[k];
        Arrays.fill(minPref, Long.MAX_VALUE);

        // virtual prefix at index -1 has sum = 0 and remainder = (k-1)
        int startRem = ((-1) % k + k) % k; // equals k-1
        minPref[startRem] = 0L;

        long pref = 0L;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            pref += nums[i];
            int rem = i % k;

            if (minPref[rem] != Long.MAX_VALUE) {
                ans = Math.max(ans, pref - minPref[rem]);
            }

            // update minimum prefix for this remainder
            minPref[rem] = Math.min(minPref[rem], pref);
        }

        return ans;
    }
}
