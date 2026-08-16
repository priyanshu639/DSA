class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long max = 0;

        for (int i = 0; i < nums.length; i++) {

            // Add current element
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            sum += nums[i];

            // Remove element if window size > k
            if (i >= k) {

                int remove = nums[i - k];

                if (map.get(remove) == 1) {
                    map.remove(remove);
                } else {
                    map.put(remove, map.get(remove) - 1);
                }

                sum -= remove;
            }

            // Window size k and all elements distinct
            if (i >= k - 1 && map.size() == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}