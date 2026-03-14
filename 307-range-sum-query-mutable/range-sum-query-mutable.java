class NumArray {

    int st[];
    int nums[];

    void build(int i,int l,int r){
        if(l==r){
            st[i]=nums[l];
            return;
        }

        int mid=l+(r-l)/2;

        build(2*i+1,l,mid);
        build(2*i+2,mid+1,r);

        st[i]=st[2*i+1]+st[2*i+2];
    }

    public NumArray(int[] nums) {
        this.nums = nums;
        st = new int[nums.length*4];

        build(0,0,nums.length-1);
    }

    void updateSeg(int i,int l,int r,int index,int val){

        if(l==r){
            st[i]=val;
            return;
        }

        int mid=l+(r-l)/2;

        if(index<=mid)
            updateSeg(2*i+1,l,mid,index,val);
        else
            updateSeg(2*i+2,mid+1,r,index,val);

        st[i]=st[2*i+1]+st[2*i+2];
    }

    public void update(int index, int val) {
        updateSeg(0,0,nums.length-1,index,val);
    }

    int rangeQuery(int i,int l,int r,int ql,int qr){

        // completely outside
        if(r<ql || l>qr)
            return 0;

        // completely inside
        if(ql<=l && r<=qr)
            return st[i];

        int mid=l+(r-l)/2;

        return rangeQuery(2*i+1,l,mid,ql,qr) +
               rangeQuery(2*i+2,mid+1,r,ql,qr);
    }

    public int sumRange(int left, int right) {
        return rangeQuery(0,0,nums.length-1,left,right);
    }
}