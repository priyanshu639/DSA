class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>ll=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            ll.add(new ArrayList<>());
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            ll.get(b).add(a);
            indegree[a]++;

        }
        // apply kahn algorithm
        
        Queue<Integer>q=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(q.size()>0){
            int front=q.remove();
            ans.add(front);
            for(int ele:ll.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0){
                    q.add(ele);
                }
                
            }
        }
        int ans2[]=new int [ans.size()];
        for(int i=0;i<ans.size();i++){
            ans2[i]=ans.get(i);
        }
        if(ans.size()==numCourses) return ans2;
        else return new int[0];
        
    }
}