class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s == null || s.length() == 1) return true;
        
        String filteredStr = stringClean(s.toLowerCase());
        int len = filteredStr.length();
        
        for(int i = 0; i < len / 2; i++) {
            if(filteredStr.charAt(i) != filteredStr.charAt(len - i - 1)) return false;
        }
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    
    private String stringClean(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if(isAlphaNumeric(s.charAt(i))) sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}