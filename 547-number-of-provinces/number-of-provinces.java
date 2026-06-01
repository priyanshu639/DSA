class Solution {
    public void bfs(int i ,boolean vis[],int isConnected[][]){
        
        Queue<Integer> q=new LinkedList<>();
        vis[i]=true;
        q.add(i);
        while(q.size()>0){
            int top=q.remove();
            for(int j =0; j<isConnected.length;j++){
                if(isConnected[top][j]==1 && !vis[j]){
                    q.add(j);
                    vis[j]=true;

                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;

        boolean vis[]=new boolean[n];
        int count=0;
        for(int i=0;i<vis.length;i++){
            
                if(!vis[i]){
                    bfs(i,vis,isConnected);
                    count++;
                }
            
        }
        return count;
        
    }
}