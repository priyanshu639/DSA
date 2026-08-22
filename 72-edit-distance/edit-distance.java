class Solution {
    // USING DP
    public int helper(StringBuilder sb1, StringBuilder sb2,int i,int j,int dp[][]){
        if(i==-1  ){
            return j+1;
        }
        if(j==-1) return i+1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(sb1.charAt(i)==sb2.charAt(j)) return dp[i][j]= helper(sb1,sb2,i-1,j-1,dp);
        else{
            return dp[i][j]= 1+ Math.min(helper(sb1,sb2,i-1,j,dp),Math.min(helper(sb1,sb2,i,j-1,dp),helper(sb1,sb2,i-1,j-1,dp)));
        }

    }

    public int minDistance(String word1, String word2) {
        StringBuilder sb1=new StringBuilder(word1);
        StringBuilder sb2=new StringBuilder(word2);
        int n=sb1.length();
        int m=sb2.length();
        // M AND N ARE VARIYING 
        // m varies from m to 0 and n varies from n to 0
        int dp[][]=new int[n][m];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;

            }

        }
        return helper(sb1,sb2 ,n-1,m-1,dp);

    }
}