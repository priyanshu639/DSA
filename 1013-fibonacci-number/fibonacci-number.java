class Solution {
    // USING MEMOIZATION


    // public int helper(int n,int dp[]){
    //     if(n<=1)return n;
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n]=helper(n-1,dp)+helper(n-2,dp);
    // }
    // public int fib(int n) {
    //     // memoization
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //      return helper(n,dp);
        
    // }



    // USING TABULATION

        // public int fib(int n) {
    
        //     int dp[]=new int[n+1];
        //     dp[0]=0;
        //     dp[1]=1;
        //     for(int i=2;i<=n;i++){
        //         dp[i]=dp[i-1]+dp[i-2];
        //     }
            
        //     return dp[n];
        
        // }


        // USING SPACE OPTIMIZATION


           public int fib(int n) {
    
            if(n==0 || n==1 ) return n;
            int n1=0;
            int n2=1;
            int temp=0;
            for(int i=2;i<=n;i++){
                temp=n1+n2;
                n1=n2;
                n2=temp;
                
                
                

                
            }
            
            return temp;
        
        }
}