class Solution {
    void union(int u,int v,int par[],int rank[]){

            int ultimateParent_U=find(u,par);
            int ultimateParent_V=find(v,par);

            if(ultimateParent_U==ultimateParent_V) return;

            if(rank[ultimateParent_U]>rank[ultimateParent_V]){
                par[ultimateParent_V]=ultimateParent_U;
            }

            else if(rank[ultimateParent_U]<rank[ultimateParent_V]){
                par[ultimateParent_U]=ultimateParent_V;
            }

            else {
                par[ultimateParent_U]=ultimateParent_V;
                rank[ultimateParent_V]++;
            }


        }
        public int find(int x,int par[]){
            if(par[x]==x) return x;
            return par[x]=find(par[x],par);

        }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int par[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, par, rank);
                }
            }
        }
        
        
        

         int count = 0;
        for (int i = 0; i < n; i++) {
            if (par[i] == i) count++;
        }

             
        
        return count;
    }
}