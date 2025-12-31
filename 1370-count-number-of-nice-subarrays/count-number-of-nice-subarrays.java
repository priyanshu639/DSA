class Solution {
    // method 1
    public int numberOfSubarrays(int[] nums, int k) {
        int a=0;int b=0;int k2=0;int count=0;int n=nums.length;int i=0;int j=0;
        while(i<n && nums[i]%2==0) i++;
        while(j<n && k2<k) if(nums[j++]%2!=0) k2++;       
        if(k2<k)  return 0;
        j--;       
        b=j+1;
        while(b<n && nums[b]%2==0) b++;
        b--;
        // upar ke 4 variable set hogaye abb sliding window tecjhnique lagao
        // sliding window
        while(b<n){
            count+=(i-a+1)*(b-j+1);
            a=i+1;
            i++;
            while(i<n && nums[i]%2==0)i++;
            j=b+1;
            b=j+1;
            while(b<n && nums[b]%2==0)b++;
            b--; 
        }
        return count;
    }
}