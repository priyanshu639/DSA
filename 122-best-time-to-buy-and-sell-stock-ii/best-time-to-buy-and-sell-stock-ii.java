class Solution {
    public int helper(int[] prices,int idx,int flag,int dp[][]){
        int profit=0;
        if(idx>=prices.length) return 0;

        if(flag==0){
            if(dp[idx][flag]!=-1) return dp[idx][flag];
            int buy=-prices[idx]+helper(prices,idx+1,1,dp);
            int skip=helper(prices,idx+1,0,dp);
            profit=Math.max(buy,skip);

        }
        else{
            if(dp[idx][flag]!=-1) return dp[idx][flag];
            int sell=prices[idx] + helper(prices,idx+1,0,dp);
            int sellskip=helper(prices,idx+1,1,dp);
            profit=Math.max(sell,sellskip);
        }
        
        
        
        return dp[idx][flag]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int dp[][]=new int[n][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return  helper(prices,0,0,dp);
        
    }
}