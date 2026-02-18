class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dis[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dis[u][v]=wt;
            dis[v][u]=wt;
        }
        // upper wale ko aise bhu kar skte ho
        // for(int[] arr:edges){
        //     int u=arr[0];
        //     int v=arr[1];
        //     int wt=arr][2];
        //     dis[u][v]=wt;
        //     dis[v][u]=wt;

        // }


        // NOW APPLY FLOYD WARSHAL ALGORTIHM
        for(int k=0;k<n;k++){

            for(int i=0;i<n;i++){
                if(i==k) continue;
                for(int j=0;j<n;j++){
                    if(j==k) continue;
                    if(dis[i][k]!=Integer.MAX_VALUE && dis[k][j]!=Integer.MAX_VALUE){
                        dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                    }
                }
            }
        }

        int minimumcity=-1;
        int minimumNumberOfCity=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if( dis[i][j]<=distanceThreshold) count++;
                

            }
            if(count<=minimumNumberOfCity){
                minimumNumberOfCity=count;
                minimumcity=i;

            }
        }
        return minimumcity;
    }
}