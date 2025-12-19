class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int count =0;
        for(int i=0;i<nums.length;i++){
            int ele=nums[i] - rev(nums[i]);
                if(map.containsKey(ele)){
                int freq=map.get(ele);
                count+=freq;
                count %= 1000000007;//ato question mentioned
                map.put(ele,freq+1);
                } 
            else map.put(ele,1);

            }
             return count;
        
       
    
    }
    public int rev(int n){
        int reverse=0;
        while(n>0){
            reverse=reverse*10+n%10;
            n=n/10;
        }
        return reverse;
    }
}