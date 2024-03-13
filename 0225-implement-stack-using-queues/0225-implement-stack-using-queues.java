class MyStack {

    ArrayDeque<Integer> dq;
    int topElement;
    public MyStack() {
        dq = new ArrayDeque<>();
    }
    
    public void push(int x) {
        topElement = x;
        dq.addLast(x);
    }
    
    public int pop() {
        int size = dq.size();
        // Leave last two elements.
        while(size > 2) {
            dq.addLast(dq.removeFirst());
            size--;
        }
        
        topElement = dq.getFirst();
        dq.addLast(dq.removeFirst());
        return dq.removeFirst();
    }
    
    public int top() {
        return topElement;
    }
    
    public boolean empty() {
        return dq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */