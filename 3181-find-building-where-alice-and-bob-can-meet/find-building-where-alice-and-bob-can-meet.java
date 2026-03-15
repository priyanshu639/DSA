class Solution {
    public void build(int i,int l ,int r,int heights[],int seg[]){
        if(l==r){
            seg[i]=l;
            return;
        }

        int mid=l+(r-l)/2;
        build(2*i+1,l,mid,heights,seg);
        build(2*i+2,mid+1,r,heights,seg);
        int leftmost=seg[2*i+1];
        int rightmost=seg[2*i+2];
        if(heights[leftmost]>=heights[rightmost]){
            seg[i]=leftmost;
        }else{
            seg[i]=rightmost;
        }


    }
    public int query(int i,int l,int r,int st,int end,int seg[],int heights[]){
        if(l>end || r<st){
            return -1;

        }
        if(l>=st && end>=r){
            return seg[i];
        }
        int mid=l+(r-l)/2;
        
        int leftmost=query(2*i+1,l,mid,st ,end,seg,heights);
        int rightmost=query(2*i+2,mid+1,r,st,end,seg,heights);
        if(leftmost==-1) return rightmost;
        if(rightmost==-1) return leftmost;
        if(heights[leftmost]>=heights[rightmost]) return leftmost;
        return rightmost;

    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int h=heights.length;
        int n=queries.length;
        
        int seg[]=new int[4*h];
        int ans[]=new int[n];
        build(0,0,h-1,heights,seg);
        for(int i=0;i<n;i++){
            int st=queries[i][0];
            int end=queries[i][1];
            int maxIdx=Math.max(st,end);
            int minIdx=Math.min(st,end);
            if(st==end){
                ans[i]=st;
                continue;
            }
            if(heights[maxIdx]>heights[minIdx]){
                ans[i]=(maxIdx);
                continue;
            }
            int l=maxIdx+1;
            int r=h-1;
            int res=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                int idx=query(0,0,h-1,maxIdx+1,mid,seg,heights);
                if(idx!=-1 && heights[idx]>Math.max(heights[st],heights[end])){
                    res=idx;
                    r=mid-1;
                }
                else{
                    l=mid+1;

                }  
                
            }
            ans[i]=res; 
        }
        return ans;
        
    }
}