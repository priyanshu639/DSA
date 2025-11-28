class Solution {
    public void solve(String ip,String op,List<String>list){
        if(ip.length()==0){
            list.add(op);
            return;
        }
        char ch=ip.charAt(0);
        if(Character.isLetter(ch)){
            
            String op1=op+Character.toLowerCase(ch);
            String op2=op+Character.toUpperCase(ch);

            String rest = ip.substring(1);

            solve(rest,op1,list);
            solve(rest,op2,list);

        }

        else{
            String rest = ip.substring(1);

            solve(rest,op+ch,list);
        }

    }
    public List<String> letterCasePermutation(String s) {
        List<String>list=new ArrayList<>();

        solve(s,"",list);
        return list;
        
    }
}