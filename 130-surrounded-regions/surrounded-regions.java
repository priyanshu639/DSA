class Solution {
    void dfs(int i,int j,char[][]board){
        int n=board.length;
        int m=board[0].length;
        if(i<0 || i>=n || j<0 || j>m-1 ||board[i][j]=='X'||board[i][j]=='*')return;
        board[i][j]='*';
        dfs(i+1,j,board);
        dfs(i,j+1,board);
        dfs(i-1,j,board);
        dfs(i,j-1,board);

    }
    public void solve(char[][] board) {

        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && board[i][j]=='O'){
                    dfs(i,j,board);

                }
                if(i==n-1 && board[i][j]=='O'){
                    dfs(i,j,board);

                }
                if(j==0 && board[i][j]=='O'){
                    dfs(i,j,board);
                    
                }
                if(j==m-1 && board[i][j]=='O'){
                    dfs(i,j,board);
                    
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='*') board[i][j]='O';
                
            }
        }
        
    }
}