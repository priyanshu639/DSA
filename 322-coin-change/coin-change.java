class Solution {
    // TABULATION METHOD 
    // BY ULTA CALL OF RECUSIVE APPROACH
    
    public int coinChange(int[] coins, int amount) {
        // i varies from coins.length to 0
        // amount varies from  0 to amount ;
        long dp[][]=new long[coins.length][amount+1];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++){
            
                long skip=(i>0)?dp[i-1][j] : (j==0) ? 0:Integer.MAX_VALUE;
                // if(i>0){
                //     skip=dp[i-1][j];
                // }
                // else{
                //     if(j==0) skip=0;
                //     else skip=Integer.MAX_VALUE;
                // }

                if(j-coins[i]<0)dp[i][j]=skip;
                else{
                long pick=1+dp[i][j-coins[i]];
                dp[i][j]=Math.min(skip,pick);
                }
            }


        int ans=(int)dp[coins.length-1][amount];
        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
        
    }
}