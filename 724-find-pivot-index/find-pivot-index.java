class Solution {
    // BRUTE FORCE HAR EK INDEX PE JAO AUR USKA LEFT SUM AUR USKA RIGHT SUM CALCULATE KARO AUR AGAR WO EQAUL H TO  WO RETURN KARDO USKA INDEX NHI TO -1 ;
    public int pivotIndex(int[] nums) {
        
    
        for(int i=0;i<nums.length;i++){
            int leftsum=0 ; 
            int rightsum=0;
            for(int j=0;j<i;j++){
                leftsum+=nums[j];
            }
            for(int k=i+1;k<nums.length;k++){
                rightsum+=nums[k];


            }
            if(leftsum==rightsum) return i;
        }
       
        
        return -1;
    }
}