class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count+= countPali(i, i, s);
            count+= countPali(i, i + 1, s);
        }
        return count;
    }

    private int countPali(int l, int r, String s) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
        }

        return count;
    }
}
