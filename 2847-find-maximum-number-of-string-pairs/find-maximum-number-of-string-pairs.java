class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String>set=new HashSet<>();
        for(String ele:words){
            set.add(ele);
        }
        int count=0;
        int startingSize=set.size();
        for(int i=0;i<words.length;i++){
          StringBuilder sb=new StringBuilder(words[i]);
          String st=sb.reverse().toString();
          if(!words[i].equals(st) && set.contains(st)) 
          {
            count++;
            set.remove(words[i]);
            set.remove(st);
            
            }
        }
        return count;
        
    }
}