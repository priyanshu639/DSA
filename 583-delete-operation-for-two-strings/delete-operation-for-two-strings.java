class Solution {
     public int helper(int m,int n,String text1, String text2,int dp[][]){
        if(m==0 || n==0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(text1.charAt(m-1)==(text2.charAt(n-1))){
            return 1 + helper(m-1,n-1,text1,text2,dp);
        }
       
        return dp[m][n]=Math.max(helper(m,n-1,text1,text2,dp),helper(m-1,n,text1,text2,dp));
       
    }
    public int minDistance(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int lcs=helper(m,n,text1,text2,dp);
        return (m+n)-2*lcs;
        
    }
       
    
}