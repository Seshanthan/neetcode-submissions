class Solution {
    public int[] twoSum(int[] numbers, int target) {
     int n = numbers.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target)
                return new int[]{left+1, right+1};
            else if(sum > target)
                right = binSearch(left, right-1, numbers, target-numbers[left]);
            else left = binSearch(left+1, right, numbers, target-numbers[right]);
        }
        return new int[]{-1, -1};
    }
    private int binSearch(int l, int r, int[] num, int ele){
        while(l < r){
            int mid = (l+r)/2;
            if(num[mid] == ele)
                return mid;
            if(num[mid] > ele)
                r = mid;
            else l = mid+1;
        }
        return l;
    }
}