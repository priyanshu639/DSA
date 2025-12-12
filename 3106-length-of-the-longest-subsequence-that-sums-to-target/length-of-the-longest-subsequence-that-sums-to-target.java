class Solution {

    public int subsetsum(List<Integer> nums, int target, int i, int dp[][]) {

        if (target == 0) return 0;              // perfect subsequence found
        if (i == nums.size()) return -1000000;  // impossible

        if (dp[i][target] != -1) {
            return dp[i][target];               // return stored result
        }

        int ans = -1000000;

        // skip current element
        int skip = subsetsum(nums, target, i + 1, dp);

        // pick current element (if possible)
        if (target - nums.get(i) < 0) {
            ans = skip;
        } else {
            int pick = subsetsum(nums, target - nums.get(i), i + 1, dp);
            if (pick >= 0) pick = pick + 1;     // add 1 to length
            ans = Math.max(skip, pick);
        }

        dp[i][target] = ans;
        return ans;
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int n = nums.size();
        int dp[][] = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = subsetsum(nums, target, 0, dp);
        if(ans<0) return -1;

        return  ans;
    }
}
