class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int i=0;
        int c=0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int prevend=intervals[0][1];
        while(i<n-1){
            if(prevend>intervals[i+1][0]){
                c++;
            }else{
                prevend=intervals[i+1][1];
            }
            i++;
        }
        return c;
    }
}