class Solution {
    // grumpy means anoying or irritated
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int unsatisfied=0;
        int maxunsatisfied=0;
        int i=0;
        int j=minutes-1;
        int a=i;
        int b=j;
        int sum=0;

        for(int d=0;d<minutes;d++){
            if(grumpy[d]==1 ) unsatisfied+=customers[d];
        }
        
        while(j<customers.length){
            if(maxunsatisfied<unsatisfied){
                 maxunsatisfied=unsatisfied;
                 a=i;
                 b=j;
            }
            i++;j++;
            
            if(j<customers.length && grumpy[j]==1  ) unsatisfied+=customers[j];
            if(grumpy[i-1]==1  ) unsatisfied-=customers[i-1];
            

        }
       for(int p=a;p<=b;p++){
        grumpy[p]=0;
       }
       for(int l=0;l<customers.length;l++){
        if(grumpy[l]==0 ) sum+=customers[l]; 
        
       }
        return sum;
        
    }
}