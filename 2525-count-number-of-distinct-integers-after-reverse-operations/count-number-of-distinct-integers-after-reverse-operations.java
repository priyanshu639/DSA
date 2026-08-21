class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int ele:nums){
            set.add(ele);
            
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            
            int reverse=0;
            while(temp!=0){
                int lastdigit=temp%10;
                reverse=reverse*10+lastdigit;
                temp=temp/10;
                
            }
            set.add(reverse);
            

        }
    
        return set.size();
        
    }
}