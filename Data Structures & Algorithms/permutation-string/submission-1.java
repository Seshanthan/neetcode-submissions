class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int required = s1.length();
        int l = 0;

        for (int r = 0; r < s2.length(); r++) {

            int right = s2.charAt(r) - 'a';

            if (freq[right] > 0) {
                required--;
            }

            freq[right]--;

            if (r - l + 1 > s1.length()) {

                int left = s2.charAt(l) - 'a';

                freq[left]++;

                if (freq[left] > 0) {
                    required++;
                }

                l++;
            }

            if (required == 0) {
                return true;
            }
        }

        return false;
    }
}