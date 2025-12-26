class Solution {
    public long[] findPrefixScore(int[] nums) {
        long prefix[]=new long [nums.length];
        
        // conversion array
        int max=nums[0];
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            arr[i]=nums[i]+max;
            

        }
        prefix[0]=arr[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
            
        }
        return prefix;
        
    }
}