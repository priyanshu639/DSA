class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]= 1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                
            }
        }

        // YAHA PE HUM PRINT KARENGE LCS KO
        StringBuilder s = new StringBuilder("");
        int i=n;int j=m;
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)) s.append(text1.charAt(i-1));
            if(dp[i-1][j]>dp[i][j-1]) i--;
            else j--;
            }
        
        s.reverse();
        System.out.println(s);
        return dp[n][m];

        
    }
}