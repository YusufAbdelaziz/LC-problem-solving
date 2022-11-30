class Solution {
    public String reverseWords(String s) {
        String modifiedString = s.trim().replaceAll(" +", " ");
        String[] words = modifiedString.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1 ; i >= 0 ; i -- ){
            sb.append(words[i]);
            sb.append(" ");
        }
        
        return sb.toString().trim();
        
    }
}