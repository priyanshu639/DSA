class Solution {
    public int palindrome(int i,int j,String s,int dp[][]) {

        if(i>j){
             return 0;
        }
        if(i==j) return 1;
        else{
            if(dp[i][j]!=-1) return dp[i][j];
            if(s.charAt(i)==s.charAt(j)){
                return dp[i][j]=2+palindrome(i+1,j-1,s,dp);
            }
            else{
                return dp[i][j]=Math.max(palindrome(i+1,j,s,dp),palindrome(i,j-1,s,dp));
            }
        }
        

    }

    public int longestPalindromeSubseq(String s) {
        int n=s.length();

        // int i and int n is variying 
        int dp[][]=new int[n][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }

        }
        return palindrome(0,n-1,s,dp);
        
    }
}