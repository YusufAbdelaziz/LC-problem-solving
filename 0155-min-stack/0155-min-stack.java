class MinStack {
    // Each map entry stores the element as a key and the current minimum element as a value.
    private LinkedList<Map.Entry<Integer, Integer>> list;

    public MinStack() {
      list = new LinkedList<>();
    }

    public void push(int val) {
      if (list.size() == 0) {
        list.add(Map.entry(val, val));
      } else {
        int lastMin = list.peekLast().getValue();
        if (lastMin < val) {
          list.add(Map.entry(val, lastMin));
        } else {
          list.add(Map.entry(val, val));
        }
      }
    }

    public void pop() {
      list.pollLast();
    }

    public int top() {
      return list.peekLast().getKey();
    }

    public int getMin() {
      Map.Entry<Integer, Integer> lastElement = list.peekLast();
      int currentMin = lastElement.getValue();
      return currentMin == Integer.MAX_VALUE ? lastElement.getKey() : currentMin;
    }
  }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */