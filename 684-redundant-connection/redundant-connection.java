class Solution {
    static int par[];
    static int size[];
    public int leader(int x){
        if(par[x]==x) return x;
        return par[x]=leader(par[x]);
    }
    public void union(int u,int v){
        int a=leader(u);
        int b=leader(v);
        if(size[a]>size[b]){
            par[b]=a;
            size[a]+=size[b];
        }
        else{
            par[a]=b;
            size[b]+=size[a];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        par=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            if(leader(u)!=leader(v)){
                union(u,v);
            }
            else{
                ans[0]=u;
                ans[1]=v;
                break;
            }
        }
        return ans;
        
    }
}