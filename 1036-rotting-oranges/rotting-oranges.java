class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;

        int freshOrange=0;
        
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) {
                    q.add(new Pair(i,j));
                    
                }
                else if(grid[i][j]==1) freshOrange++;

            }
        }
        if(freshOrange==0) return 0;
        int min=0;
        while(q.size()>0){
            int size=q.size();
            
            while(size-- >0){
                Pair top=q.remove();
                int i=top.row;
                int j=top.col;
                for(int[] d:dir){
                    int u=i+d[0];
                    int v=j+d[1];
                    if(u>=0 && u<n && v>=0 && v<m && grid[u][v]==1) {
                        grid[u][v]=2;
                        q.add(new Pair(u,v));
                        freshOrange--;

                    }
                    
                }
            }
            min++;
        }
        
       if(freshOrange==0) return min-1;
       return -1;



    }
}