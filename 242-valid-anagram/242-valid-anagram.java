class Solution {
    public boolean isAnagram(String s, String t) {
        
        // Convert the first string to a list of characters.
        var tempArrayS = s.toCharArray();
        // Sort that list of characters.
        Arrays.sort(tempArrayS);
        // Construct the list of characters into a string.
        String sortedS = new String(tempArrayS);
        
        var tempArrayT = t.toCharArray();
        Arrays.sort(tempArrayT);
        String sortedT = new String(tempArrayT);
        
        return sortedS.equals(sortedT);

    }
}