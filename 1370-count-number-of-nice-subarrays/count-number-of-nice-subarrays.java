class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Method 2
        
        // this is prefixsum and hashmap approach 
        int n=nums.length, count=0;
        for(int i=0;i<n;i++)nums[i] %= 2;
        for(int i=1;i<n;i++)nums[i]+=nums[i-1];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            int a=0;
            if(map.containsKey(nums[i]-k)){
                a=map.get(nums[i]-k);
            }
            int b=0;
             if(map.containsKey(nums[i]-k+1)){
                b=map.get(nums[i]-k+1);
            }
            if(nums[i]==k)count+=b-a+1;
            if(nums[i]>k) count+=b-a;
        }

        return count;
    }
}