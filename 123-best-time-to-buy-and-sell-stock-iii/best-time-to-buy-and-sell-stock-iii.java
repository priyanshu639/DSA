class Solution {
    public int helper(int[] prices,int idx,int flag,int limit,int dp[][][]){
        int profit=0;
        if(idx>=prices.length) return 0;
        if(limit==0) return 0;

        if(flag==0){
            if(dp[idx][flag][limit]!=-1) return dp[idx][flag][limit];
            int buy=-prices[idx]+helper(prices,idx+1,1,limit,dp);
            int skip=0+helper(prices,idx+1,0,limit,dp);
            profit=Math.max(buy,skip);

        }
        else{
            if(dp[idx][flag][limit]!=-1) return dp[idx][flag][limit];
            int sell=prices[idx] + helper(prices,idx+1,0,limit-1,dp);
            int sellskip=0+helper(prices,idx+1,1,limit,dp);
            profit=Math.max(sell,sellskip);
        }
        
        
        
        return dp[idx][flag][limit]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);

            }
 
        }
        
        return  helper(prices,0,0,2,dp);
        
        
    }
}