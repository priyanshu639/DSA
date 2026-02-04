class Solution {

    // tc annd sc =O(n*m)
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    // bfs(i,j,grid,visited);
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
        
    }


    void dfs(int i,int j,char grid[][],boolean visited[][]){
        visited[i][j]=true;
        int n=grid.length;
        int m=grid[0].length;

        // top
        if(i-1>=0 && grid[i-1][j]=='1' && visited[i-1][j]==false){
            dfs(i-1,j,grid,visited);
        }
        // bootom
        if(i+1<n && grid[i+1][j]=='1' && visited[i+1][j]==false){
            dfs(i+1,j,grid,visited);
        }
        // left
        if(j-1>=0 && grid[i][j-1]=='1' && visited[i][j-1]==false){
            dfs(i,j-1,grid,visited);
        }
        // right
        if(j+1<m && grid[i][j+1]=='1' && visited[i][j+1]==false){
            dfs(i,j+1,grid,visited);
        }
    }
    void bfs(int i,int j,char grid[][],boolean visited[][]){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j]=true;
        while(q.size()>0){
            Pair front=q.remove();
            int row=front.row;
            int col=front.col;

            // TOP row=row-1 and col same
            if(row>0){
                if(visited[row-1][col]==false && grid[row-1][col]=='1'){
                    q.add(new Pair(row-1,col));
                    visited[row-1][col]=true;
                }
            }

            // BOTTOM. row=row+1 and col=col

            if(row+1<n){
                if(visited[row+1][col]==false && grid[row+1][col]=='1'){
                    q.add(new Pair(row+1,col));
                    visited[row+1][col]=true;
                }
            }

            // LEFT row=row and col=col-1

            if(col>0){
                if(visited[row][col-1]==false && grid[row][col-1]=='1'){
                    q.add(new Pair(row,col-1));
                    visited[row][col-1]=true;
                }
            }

            // RIGHT row =row and col=col+1

            if(col+1<m){
                if(visited[row][col+1]==false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    visited[row][col+1]=true;
                }
            }

        }
       
    }
}