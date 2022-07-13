class Solution {
    public boolean isAnagram(String s, String t) {
        
        var tempArrayS = s.toCharArray();
        Arrays.sort(tempArrayS);
        String sortedS = new String(tempArrayS);
        
        var tempArrayT = t.toCharArray();
        Arrays.sort(tempArrayT);
        String sortedT = new String(tempArrayT);
        
        return sortedS.equals(sortedT);

    }
}