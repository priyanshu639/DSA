class Solution {
    public boolean subsetsum(int nums[],int target,int i,int dp[][]){
        if(i==nums.length){
            if(target==0) return true;
            else return false;
        }
        
        if(dp[i][target]!=-1){
            
            return dp[i][target]==1;

        } 
        boolean ans=false;
        boolean skip=subsetsum(nums,target,i+1,dp);
        if(target-nums[i]<0) ans=skip;
        else{
             boolean pick=subsetsum(nums,target-nums[i],i+1,dp);
             ans=pick||skip;
        }
       
        if(ans==true) dp[i][target]=1;
        else dp[i][target]=0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        } 
        if(sum%2!=0) return false;
        // target varirs from target to 0 
        // index varies from 0 to i-1
        
        else{
            int dp[][]=new int[nums.length][(sum/2)+1];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
                }
            
            }
            return subsetsum(nums,(sum/2),0,dp);
        }



       
        
    }
}