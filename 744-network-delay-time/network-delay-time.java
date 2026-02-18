class Solution {
    // Bellmans Algortithm
    public int networkDelayTime(int[][] times, int n, int k) {
        int dis[]=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        for(int x=0;x<=n-1;x++){
            for(int i=0;i<times.length;i++){
                int u=times[i][0];
                int v=times[i][1];
                int wt=times[i][2];
                if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                    dis[v]=dis[u]+wt;
                }

            }

        }int max=0;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE)return -1;
            max=Math.max(max,dis[i]);
        }
        return max;
        
    }
}