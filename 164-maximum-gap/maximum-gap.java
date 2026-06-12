class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int Max=0;
        if (n<2) return 0;
        for(int i=0;i<n-1;i++){
            Max=Math.max(nums[i+1]-nums[i],Max);

        }
        return Max;
        
    }
}
