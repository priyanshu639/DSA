class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        int i=0;
        int j=0;

        while(j<m && i<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            } 
            j++;
        }
        return i==n;
       
        
    }
}