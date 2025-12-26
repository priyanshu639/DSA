class Solution {
    // using prefix sum 
    public int pivotIndex(int[] nums) {
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        int leftsum=0;
        int rightsum=0;
        for(int i=1;i<nums.length;i++){
            prefix[i]=nums[i]+prefix[i-1];      
        }
        for(int i=0;i<nums.length;i++){
            if(i>0)leftsum=prefix[i-1];
            rightsum=prefix[nums.length-1]-prefix[i];
            if(leftsum==rightsum) return i;
            
        }
        
        return -1;
    }
}