class Solution {
    static int parent[];
    static int size[];
    static boolean parity[];
    public int leader(int x){
        if(parent[x]==x)return x;
        return parent[x]=leader(parent[x]);
    }
    public void union(int u,int v){
        int ua=leader(u);
        int ub=leader(v);
        if(ua!=ub){
            if(size[ua]>size[ub]){
                parent[ub]=ua;
                size[ua]+=size[ub];
                parity[v]=!parity[u];
            }
            else{
                parent[ua]=ub;
                size[ub]+=size[ua];
                parity[u]=!parity[v];
            }
        }


    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        parent=new int[n];
        size=new int[n];
        parity=new boolean[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
            parity[i]=false;
        }
        for(int u=0;u<graph.length;u++){
            for(int v=0;v<graph[u].length;v++){
                if(u<graph[u][v]){
                     if(leader(u)==leader(graph[u][v])){//cycle detected
                        if(parity[u]==parity[graph[u][v]]) return false;
                     }
                     else{
                        union(u,graph[u][v]);
                     }

                }

            }

        }
        return true;

        
    }
}