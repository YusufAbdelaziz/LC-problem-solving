class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : operations) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int top = stack.pop();
                    int newTop = stack.peek() + top;
                    stack.push(top);
                    stack.push(newTop);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}