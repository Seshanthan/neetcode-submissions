class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> d = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int r = 0; r < nums.length; r++) {

            // Remove indices outside the window
            while (!d.isEmpty() && d.peekFirst() <= r - k) {
                d.removeFirst();
            }

            // Remove smaller elements from the back
            while (!d.isEmpty() && nums[d.peekLast()] <= nums[r]) {
                d.removeLast();
            }

            // Add current index
            d.addLast(r);

            // Window has size k
            if (r >= k - 1) {
                ans.add(nums[d.peekFirst()]);
            }
        }

        int[] res = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}