class Solution {
    static boolean ans;
    public void dfs(int i,List<List<Integer>>ll,boolean vis[],boolean path[]){
        vis[i]=true;
        path[i]=true;
        for(int ele:ll.get(i)){
            if(path[ele]==true){
                ans=false;
                return;
            }
            if(vis[ele]==false){
                dfs(ele,ll,vis,path);
            }
        }
        path[i]=false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ans=true;
        List<List<Integer>>ll=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            ll.add(new ArrayList<>());
        }
      
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            ll.get(b).add(a);
        

        }
    //apply dfs
        
        boolean vis[]=new boolean[numCourses];
        boolean path[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==false){
                 dfs(i,ll,vis,path);
                
            }
            
        }
        return ans;
       
        
    }
}