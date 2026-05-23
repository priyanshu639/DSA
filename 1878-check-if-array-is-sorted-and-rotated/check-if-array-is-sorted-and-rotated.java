class Solution {
    public boolean check(int[] arr) {
        int n=arr.length;
        int x;
        int count=1;
        int k=0;

        for(int i=0;i<n-1;i++){

            if(arr[i]<=arr[i+1]){
                count++;
                continue;

            }
            else{
                k=n-count;
                
        
            
            }
        }
        for(int i=0;i<k;i++){
            int nm=arr[n-1];
            for(int j=n-1;j>0;j--){
                
                arr[j]=arr[j-1];
            }
            arr[0]=nm;

        }
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                return false;

            }
            
        }
        return true;
    }

}