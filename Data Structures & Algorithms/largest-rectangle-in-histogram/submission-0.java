class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> h = new Stack<>();
        int area=0;
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!h.isEmpty() && h.peek()[1]>heights[i]){
                int[] arr = h.pop();
                int index = arr[0];
                int height= arr[1];
                area =Math.max(area, height * (i-index));
                start =index;
            }
            h.push(new int[]{start,heights[i]});
        }
        if(!h.isEmpty()){
            for(int[] i:h){
                area=Math.max(area,i[1]*(heights.length-i[0]));
            }
        }
        return area;
    }
}