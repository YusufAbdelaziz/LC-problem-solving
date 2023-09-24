class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];
        int[] greater = new int[nums2.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
        
        
        Stack<Integer> monoStack = new Stack<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!monoStack.isEmpty() && nums2[monoStack.peek()] < nums2[i]) {
                int top = monoStack.pop();
                
                greater[top] = i;
            }
            
            monoStack.push(i);
        }
        
        
        for(int i = 0; i < nums1.length; i++) {
            int indexInNums2 = map.get(nums1[i]);
            if(greater[indexInNums2] == 0) {
                result[i] = -1;
            } else {
                result[i] = nums2[greater[indexInNums2]];
            }
        }
        return result;
    }
}