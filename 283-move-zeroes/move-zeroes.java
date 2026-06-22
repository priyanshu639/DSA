class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
       
        while(i<nums.length){

                if(nums[i]!=0){
                    // swap kara do i aur j ko aur i++ and j++ do it
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    j++;
                    

                    }
                    i++;
            

        }
      
    }
}