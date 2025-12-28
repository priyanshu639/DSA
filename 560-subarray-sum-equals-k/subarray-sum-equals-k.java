class Solution {
    public int subarraySum(int[] nums, int k) {
        // this is optimal approach ,in bruteforce you firsst calculate all the possible subbaray the calulate sum of all and count++
        // first create prefix sum array 
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];

        }
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:nums){
            
            int rem=ele-k;
            if(ele==k)count++;
            if(map.containsKey(rem)) count=count+map.get(rem);
            if(map.containsKey(ele)){
                int freq=map.get(ele);
                map.put(ele,freq+1);  
            }
            else{
                map.put(ele,1);
            }
        }
        
        return count;
    }
}