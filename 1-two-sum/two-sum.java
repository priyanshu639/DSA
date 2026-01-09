class Solution {

    // array approch 


    // public int[] twoSum(int[] nums, int target) {
    //     int ans[]=new int[2];
    //     for (int i=0;i<nums.length;i++){
    //         for(int j=i+1; j<nums.length;j++){
    //             if(nums[i] + nums[j] == target){
    //             ans[0]=i;
    //             ans[1]=j;
    //             break;
    //             }
    //         }
    //     }
    //     return ans;
    // }

    // hashmap appoach

     public int[] twoSum(int[] nums, int target) {
        int ans[]={-1,-1};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int remaining=target-nums[i];
            if(map.containsKey(remaining)){
                ans[0]=i;
                ans[1]=map.get(remaining);
            }
            else{
                map.put(nums[i],i);
            }
        }
        return ans;
     }
}