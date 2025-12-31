class Solution {
    public String LCS(String text1, String text2) {
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
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                s.append(text1.charAt(i-1));
                i--;
                j--;

            } 
            else if(dp[i-1][j]>dp[i][j-1]) i--;
            else j--;
            }
        
        s.reverse();
        // System.out.println(s);
        return s.toString();

        
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs=LCS(str1,str2);
        int i=0,j=0,k=0;
        String scs="";
        while(k<lcs.length()){
            while(str1.charAt(i)!=lcs.charAt(k)){
                scs+=(str1.charAt(i));
                i++;
            }
            while(str2.charAt(j)!=lcs.charAt(k)){
                scs+=(str2.charAt(j));
                j++;
            }
            scs+=(lcs.charAt(k));
            i++;j++;k++;

        }
        while(j<str2.length()){
            scs+=str2.charAt(j);
            j++;
        }
        while(i<str1.length()){
            scs+=str1.charAt(i);
            i++;
        }
        return scs;

        
    }
}