class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    
    public Solution(){
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    
    
    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            // If current character is not the last one so we can make a single lookahead character check
            if(i < s.length() - 1) {
                switch(s.charAt(i)){
                    case 'I': 
                        if(s.charAt(i + 1) == 'V') {
                            result += 4;
                            i++;
                        }
                        else if(s.charAt(i + 1) == 'X'){
                            result += 9;
                            i++;
                        }
                        else result += 1;
                        break;
                    case 'X':
                        if(s.charAt(i + 1) == 'L') {
                            result += 40;
                            i++;
                        }
                        else if(s.charAt(i + 1) == 'C') {
                            result += 90;
                            i++;
                        }
                        else result += 10;
                        break;
                    case 'C':
                        if(s.charAt(i + 1) == 'D') {
                            result += 400;
                            i++;
                        }
                        else if(s.charAt(i + 1) == 'M') {
                            result += 900;
                            i++;
                        }
                        else result += 100;
                        break;
                    default:
                        result += map.get(s.charAt(i));
                }
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}