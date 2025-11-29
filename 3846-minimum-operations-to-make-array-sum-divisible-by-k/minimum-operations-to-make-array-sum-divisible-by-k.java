class Solution {
    public int minOperations(int[] nums, int k) {
        long s = 0;
        for (int x : nums) s += x;
        return (int)(s % k);
    }
}
