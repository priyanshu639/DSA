class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        max=Math.max(sum,max);
        for(int i=k;i<nums.length;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            max=Math.max(sum,max);
        }
        return max/k;

        
        
    }
}