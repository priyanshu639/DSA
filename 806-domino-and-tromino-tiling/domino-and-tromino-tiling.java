class Solution {
    public int numTilings(int n) {

        long MOD = 1000000007;

        if (n == 1) return 1;
        if (n == 2) return 2;

        long dp0 = 1; // dp[i-3]
        long dp1 = 1; // dp[i-2]
        long dp2 = 2; // dp[i-1]

        for (int i = 3; i <= n; i++) {

            long current = (2 * dp2 + dp0) % MOD;

            dp0 = dp1;
            dp1 = dp2;
            dp2 = current;
        }

        return (int) dp2;
    }
}