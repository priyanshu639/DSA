class Solution {
    public int gcd(int n1,int n2){
        if(n2==0){
            return n1;
        }
        return gcd(n2,n1%n2);
    }
    public String gcdOfStrings(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        // Ye verify karta hai ki kya dono strings kisi same base pattern se bani hain ya nahi.
        if(!(str1+str2).equals(str2+str1))return "";

        
        String str="";
        int k=gcd(n,m);
        str=str1.substring(0,k);
        return str;
            
    }
}