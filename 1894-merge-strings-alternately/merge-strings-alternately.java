class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        String s="";
        int j=0;
        for(int i=0;i<n;i++){
            s+=word1.charAt(i);
            if(j<m){
                s+=word2.charAt(j);
                j++;
            }

        }
        if(j<m){
            for(int k=j;k<m;k++){
                s+=word2.charAt(k);
            }
        }
        return s;
        
    }
}