class Solution {
    public boolean palindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(s.charAt(i));
            }
            else{
                continue;
            }
        }
        System.out.println(s);
        s=sb.toString().toLowerCase();
        System.out.println(s);
        boolean check=palindrome(s);
        return check;
    }
}