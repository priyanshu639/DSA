class Solution {
    static int sum;
    public int ways(int i ,int[] nums, int target,int res,int dp[][]) {
        if(i==nums.length){
            if(target==res)return 1;
            else return 0;
        }
        if(dp[i][res+sum]!=-1)return dp[i][res+sum];
        int add=ways(i+1 ,nums,target,res-nums[i],dp) ;
        int sub=ways(i+1 , nums, target,res+nums[i],dp); 
        return dp[i][res+sum]=add+sub;
        
    }

    public int findTargetSumWays(int[] nums, int target) {
        sum=0;
        int n=nums.length;
        for(int ele:nums)sum+=ele;
        int dp[][]=new int[n][2*sum+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return ways(0,nums,target,0,dp);
        
    }
}