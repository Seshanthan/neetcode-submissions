class Solution {
    private int index(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        return 26 + (ch - 'A');
    }

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m > n) return "";

        int[] freq = new int[52];

        for (char ch : t.toCharArray()) {
            freq[index(ch)]++;
        }

        int l = 0;
        int c = 0;

        int minl = 0;
        int minr = 0;
        int mini = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {

            int idx = index(s.charAt(r));

            if (freq[idx] > 0) {
                c++;
            }

            freq[idx]--;

            while (c == m) {

                if (r - l < mini) {
                    mini = r - l;
                    minl = l;
                    minr = r;
                }

                int idl = index(s.charAt(l));

                freq[idl]++;

                if (freq[idl] > 0) {
                    c--;
                }

                l++;
            }
        }

        if (mini == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minl, minr + 1);
    }
}