class Solution {
    public int minCost(int n, int[] cuts) {
        int arr[]=new int[cuts.length+2];
        int i;
        for( i=0;i<cuts.length;i++){
            arr[i]=cuts[i];
        }
        arr[i++]=0;
        arr[i]=n;
        Arrays.sort(arr);
        int m=arr.length;
        int dp[][]=new int[m-1][m-1];
        for(int l=0;l<dp.length;l++){
            Arrays.fill(dp[l],-1);
        }
        
        // i ja raha 1 to m-2 and j is m-2 to 1 
        return cost(1,arr.length-2,arr,dp);

        
    }
    public int cost(int i,int j,int arr[],int dp[][]){
        if(i>j)return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int len=arr[j+1]-arr[i-1];
            int totalcost=cost(i,k-1,arr,dp)+cost(k+1,j,arr,dp)+len;
            min=Math.min(totalcost,min);

        }
        return dp[i][j]=min;
    }
}