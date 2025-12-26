class Solution {
    public int[] productExceptSelf(int[] nums) {
        // optimal approach
        int prefix[]=new int[nums.length];
        int suffix[]=new int[nums.length];
        int ans[]=new int[nums.length];
        prefix[0]=1;
        suffix[nums.length-1]=1;
        // prefix
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        // suffix
         for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
            
        }
        // product of suffix and prefix array
        // we can do it without creating ans array we can do changes in any of prefix or suffix array

        // we can also do this without creating a suffix array but how?--> we can create by ttaking a variable suffix and store 1 and then every time we manipulate it by suffix*=nums[i+1]; and prefix[i]*=suffix;
        for(int i=0;i<nums.length;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        
        return ans;



        
    }
}