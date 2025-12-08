class Solution {
    public int countTriples(int n) {
        int arr[] = new int[n];
        for(int i = 1 ;i <= n;i++){
            arr[i-1]=i*i;
        }
        for(int i = 0 ;i < n;i++){
           System.out.print(arr[i]+" ");
        }
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1; j<arr.length; j++){
                for(int k = j + 1 ; k < arr.length ; k++){
                    if(arr[i] + arr[j] == arr[k]) count+=2;
                }

            }
            
        }
        return count;
        
    }
}