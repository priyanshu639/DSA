class Solution {
    public int removeElement(int[] nums, int val) {
       int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val) {
                nums[k]=nums[i];
                k++;

            }
        }
        System.out.println(Integer.MIN_VALUE+1);
         System.out.println(Integer.MIN_VALUE-1);
          System.out.println(Integer.MAX_VALUE+1);
           System.out.println(Integer.MAX_VALUE-1);
        return k;
        
    }
}