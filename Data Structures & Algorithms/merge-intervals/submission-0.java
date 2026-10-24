class Solution {
    public int[][] merge(int[][] intervals) {
        int i=0;
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        while(i<intervals.length){
            int[] temp= new int[2];
            temp[0]=intervals[i][0];
            temp[1]=intervals[i][1];
            while(i<intervals.length-1 && temp[1]>=intervals[i+1][0]){
                temp[0]=Math.min(temp[0],intervals[i+1][0]);
                temp[1]=Math.max(temp[1],intervals[i+1][1]);
                System.out.println(temp[0]+" "+temp[1]);
                i++;
            }
            ans.add(temp);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}