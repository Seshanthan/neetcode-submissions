class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1 2 3 4 5 6 7
        // 1 2 3 5 6 7
        // 1 1 2 2 3 3 4 5 5 6 6 7 7 
        if(nums1.length<nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n=nums1.length;
        int m=nums2.length;
        int l=0;
        int h=m;
        int part=(n+m+1)/2;
        while(l<=h){
            int p2= l+(h-l)/2;
            int p1 = part-p2;
            int left1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1-1];
            int right1 = p1 == n ? Integer.MAX_VALUE : nums1[p1];
            int left2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2-1];
            int right2= p2 == m ? Integer.MAX_VALUE : nums2[p2];
            if(left1<=right2 && left2<=right1){
                if((n+m) % 2==0 ){
                    return (double) (Math.max(left1,left2)+Math.min(right1,right2))/(double) 2;
                }
                else{
                    return (double) Math.max(left1,left2);
                }
            }
            else if(left1>right2){
                l=p2+1;
            }
            else{
                h=p2-1;
            }
        }
        return 0.0;
    }
}