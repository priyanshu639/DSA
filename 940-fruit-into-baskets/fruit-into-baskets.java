class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        
        int maxlen=0;
        int n=fruits.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(j<n){
            if(map.containsKey(fruits[j])){
                int freq=map.get(fruits[j]);
                map.put(fruits[j],freq+1);
            }
            else map.put(fruits[j],1);
            while(map.size()>2){
                int freq=map.get(fruits[i]);
                if(freq==1) map.remove(fruits[i]);
                else map.put(fruits[i],freq-1);
                i++; 
            }
             int len=j-i+1;
            maxlen=Math.max(maxlen,len);
            j++;

        }
        return maxlen;
    }
}