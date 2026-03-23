class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;

        int word1Length = word1.length();
        int word2Length = word2.length();

        StringBuilder res = new StringBuilder();
        boolean switchSource = true;
        while (i < word1Length && j < word2Length) {
            if (switchSource) {
                res.append(word1.charAt(i));
                i++;
                switchSource = !switchSource;
            } else {
                res.append(word2.charAt(j));
                j++;
                switchSource = !switchSource;
            }
        }

        while (i < word1Length) {
            res.append(word1.charAt(i));
            i++;
        }

         while (j < word2Length) {
            res.append(word2.charAt(j));
            j++;
        }

        return res.toString();
    }
}