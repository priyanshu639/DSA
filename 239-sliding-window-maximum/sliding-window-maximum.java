class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] arr = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            // 1. Remove elements outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // 2. Remove smaller elements from the back
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // 3. Add current index
            dq.addLast(i);
            // 4. Window is ready
            if (i >= k - 1) {
                arr[index++] = nums[dq.peekFirst()];
            }
        }

        return arr;
    }
}