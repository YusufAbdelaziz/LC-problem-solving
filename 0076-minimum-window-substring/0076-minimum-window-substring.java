import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, match = 0, start = 0;
        int minLen = Integer.MAX_VALUE;

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();

        for (char c : t.toCharArray()) needs.put(c, needs.getOrDefault(c, 0) + 1);

        while (right < s.length()) {
            char currentRightChar = s.charAt(right);
            if (needs.containsKey(currentRightChar)) {
                window.put(currentRightChar, window.getOrDefault(currentRightChar, 0) + 1);
                if (window.get(currentRightChar).equals(needs.get(currentRightChar))) {
                    match++;
                }
            }

            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char currentLeftChar = s.charAt(left);
                if (needs.containsKey(currentLeftChar)) {
                    window.put(currentLeftChar, window.get(currentLeftChar) - 1);
                    if (window.get(currentLeftChar) < needs.get(currentLeftChar)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
