import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int left = 0, right = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            var maxCharEntry = window.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);

            while ((right - left + 1) - maxCharEntry.getValue() > k) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
                maxCharEntry = window.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
            }

            maxLen = Math.max(maxLen, (right - left + 1));
            right++;
        }

        return maxLen;
    }
}
