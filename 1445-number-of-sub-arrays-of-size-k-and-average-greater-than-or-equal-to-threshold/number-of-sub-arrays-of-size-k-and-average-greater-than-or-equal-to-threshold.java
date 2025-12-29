class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i=0;
        int j=k-1;
        int sum=0;
        int count=0;
        for(int a=0;a<=j;a++){
            sum+=arr[a];
        }

        i++;
        j++;
        if((sum/k)>=threshold) count++;
        while(j<arr.length){
            sum=sum-arr[i-1]+arr[j];
            int average=sum/k;
            if(average>=threshold) count++;
            i++;
            j++;
        }
        return count;
    }
}