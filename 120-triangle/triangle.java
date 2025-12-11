class Solution {
    // public int helper(int row,int col,List<List<Integer>> triangle,int dp[][]){
    //     if(row==triangle.size()-1){
            
    //         return triangle.get(row).get(col);
    //     }
    //     if(dp[row][col]!=Integer.MIN_VALUE){
    //         return dp[row][col];
    //     }
    //     int left=helper(row+1,col,triangle,dp);
    //     int right=helper(row+1,col+1,triangle,dp);
    //     dp[row][col]=triangle.get(row).get(col)+Math.min(left,right);
    //     return dp[row][col];
    // }
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     int dp[][]=new int[n][n];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(dp[i],Integer.MIN_VALUE);
    //     }

    //     return helper(0,0,triangle,dp);
        
        
    // }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i==n-1)dp[i][j]=triangle.get(i).get(j);  
                else{
                    dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }   

            }
        }
        return dp[0][0];

    }
}