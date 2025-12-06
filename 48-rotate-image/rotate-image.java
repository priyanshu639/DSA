class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        // transpose kr diya 

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(i==j){
                    continue;
                }
                else{
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                }
            }
        }

        // reverse kr do matrix ko row wise
        for(int i =0;i<n;i++){
            int a=0;int b=m-1;
            while(a<b){
            int temp=matrix[i][a];
            matrix[i][a]=matrix[i][b];
            matrix[i][b]=temp;
            a++;
            b--;
            }
        }
        
    }
}