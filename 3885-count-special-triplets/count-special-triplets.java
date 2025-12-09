import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        long MOD = 1000000007L;
        int n = nums.length;

        // Right map counts of all elements initially
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> leftMap = new HashMap<>();
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int curr = nums[j];
            rightMap.put(curr, rightMap.get(curr) - 1);  // remove current element from right side

            // find how many i < j have nums[i] == 2 * curr
            int leftCount = leftMap.getOrDefault(2 * curr, 0);

            // find how many k > j have nums[k] == 2 * curr
            int rightCount = rightMap.getOrDefault(2 * curr, 0);

            ans = (ans + (1L * leftCount * rightCount) % MOD) % MOD;

            // add current element to left side
            leftMap.put(curr, leftMap.getOrDefault(curr, 0) + 1);
        }

        return (int) ans;
    }
}
