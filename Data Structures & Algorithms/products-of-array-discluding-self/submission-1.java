class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];

        int sufix = 1;
        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            answers[i] = prefix;
            prefix = prefix * nums[i];

        }
        for (int i = nums.length - 1; i >= 0; i--) {
            answers[i] = sufix * answers[i];
            sufix = sufix * nums[i];
        }
        return answers;
    }
}
