class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character,Integer>map1=new HashMap<>();//this is for first ocurence of character in string
         HashMap<Character,Integer>map2=new HashMap<>();//this is for last ocurrence of character in string
         for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map1.containsKey(ch)){
                map1.put(ch,i);
            }
            map2.put(ch,i);
         }

         

         int count=0;
         for(char ch:map1.keySet()){
            int map1Idx=map1.get(ch);
            int map2Idx=map2.get(ch);
            // hashset is using fo count the different number of character in a string from firatind to lastindx;
            
            HashSet<Character>set=new HashSet<>();
            for(int i=map1Idx+1;i<=map2Idx-1;i++){
                set.add(s.charAt(i));
            }
            count+=set.size();
         }

        return count;
    }
}