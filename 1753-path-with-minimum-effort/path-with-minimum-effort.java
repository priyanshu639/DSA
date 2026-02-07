class Solution {
    class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int dis;
        Triplet(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;

        }
        // distance ke based sorting karega
        public int compareTo(Triplet other){
            return Integer.compare(this.dis, other.dis);


        }
    }
    public int minimumEffortPath(int[][] heights) {

        int row=heights.length;
        int col=heights[0].length;
        int ans[][]=new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }
        ans[0][0]=0;
        PriorityQueue<Triplet>pq=new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(pq.size()>0){
            Triplet top=pq.remove();
            // row ke liye going up
            if(top.row>0){
                int absDifference=Math.abs(heights[top.row][top.col]-heights[top.row-1][top.col]);
                absDifference= Math.max(absDifference,top.dis);
                if(ans[top.row-1][top.col]>absDifference){
                    ans[top.row-1][top.col]=absDifference;
                    pq.add(new Triplet(top.row-1,top.col,absDifference));

                }                
            }
            // row going down
            if(top.row<row-1){
                int absDifference=Math.abs(heights[top.row][top.col]-heights[top.row+1][top.col]);
                absDifference= Math.max(absDifference,top.dis);
                if(ans[top.row+1][top.col]>absDifference){
                    ans[top.row+1][top.col]=absDifference;
                    pq.add(new Triplet(top.row+1,top.col,absDifference));

                }                
            }
            // col going left
            if(top.col>0){
                int absDifference=Math.abs(heights[top.row][top.col]-heights[top.row][top.col-1]);
                absDifference= Math.max(absDifference,top.dis);
                if(ans[top.row][top.col-1]>absDifference){
                    ans[top.row][top.col-1]=absDifference;
                    pq.add(new Triplet(top.row,top.col-1,absDifference));

                }                
            }
            // top going right side
            if(top.col<col-1){
                int absDifference=Math.abs(heights[top.row][top.col]-heights[top.row][top.col+1]);
                absDifference= Math.max(absDifference,top.dis);
                if(ans[top.row][top.col+1]>absDifference){
                    ans[top.row][top.col+1]=absDifference;
                    pq.add(new Triplet(top.row,top.col+1,absDifference));

                }                
            }
            
        }
        return ans[row-1][col-1];
        
    }
}