class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int len = t.length(), startIndex = -1;
        int minlen = Integer.MAX_VALUE;
        int cnt = 0, l = 0;
        int[] hash = new int[256];

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hash[ch]++;
        }

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (hash[ch] > 0)
                cnt++;
            hash[ch]--;

            while (cnt == len) {
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    startIndex = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0)
                    cnt--;
                l++;
            }
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minlen);
    }
}
