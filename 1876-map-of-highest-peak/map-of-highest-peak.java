class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int height[][]=new int[n][m];

        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    height[i][j]=0;
                    q.add(new Pair(i,j));

                }
                else{
                    height[i][j]=-1;//marks unvisited
                }
                
            }
        }
// apply multi source bfs

        while(q.size()>0){
            int N=q.size();
            while(N-- >0){
                Pair top=q.remove();
                int i=top.row;
                int j=top.col;
                for(int d[]:dir){
                    int u=i+d[0];
                    int v=j+d[1];
                    if(u>=0 && u<n && v>=0 && v<m && height[u][v]==-1){
                        height[u][v]=height[i][j]+1;
                        q.add(new Pair(u,v));
                    }

                }
            }
        }
        return height;
        
    }
}