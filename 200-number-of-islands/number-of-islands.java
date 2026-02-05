class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];//false
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    
                    dfs(i,j,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int i ,int j,boolean visited[][],char grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        visited[i][j]=true;
        // top
        if(i-1>=0 && grid[i-1][j]=='1' && visited[i-1][j]==false){
            
            dfs(i-1,j,visited,grid);
        } 
        if(i+1<n  && grid[i+1][j]=='1' && visited[i+1][j]==false){
            
            dfs(i+1,j,visited,grid);
        } 
        if(j-1>=0  && grid[i][j-1]=='1' &&  visited[i][j-1]==false){
        
            dfs(i,j-1,visited,grid);
        } 
        if(j+1<m  && grid[i][j+1]=='1' &&  visited[i][j+1]==false){
           
            dfs(i,j+1,visited,grid);
        } 
    }
}