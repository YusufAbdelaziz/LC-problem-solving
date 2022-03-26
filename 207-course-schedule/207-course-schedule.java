class Solution {
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    // Create edges using a hashmap, so the course key is dependent on the course value.
    HashMap<Integer, List<Integer>> prereqMap = new HashMap<>();
    // VisitingSet is used to track cycles.
    Set<Integer> visitingSet = new HashSet<>();

    // Filling the map with empty list or adding a node connection to the list of edges.
    for (int i = 0; i < prerequisites.length; i++) {
      List<Integer> requiredCourses = prereqMap.getOrDefault(prerequisites[i][0],
          new ArrayList<Integer>());
      requiredCourses.add(prerequisites[i][1]);
      prereqMap.put(prerequisites[i][0], requiredCourses);
    }

    // Executing DFS on each course.
    for (int i = 0; i < numCourses; i++) {
      if(!dfs(i, prereqMap, visitingSet)) return false;
    }

    

    return true;
  }

  private boolean dfs(int node, HashMap<Integer, List<Integer>> prereqMap, Set<Integer> visitingSet) {
    List<Integer> neighbourCourses = prereqMap.getOrDefault(node, new ArrayList<Integer>());

    // If we're visiting a node that's already visited, then we've come into a cycle.
    if (visitingSet.contains(node) )
      return false;
    
    // If the prerequisite courses don't existed to a specific course, then there's no cycle. 
    if(neighbourCourses.isEmpty())
      return true;

    // Since we're currently visiting the node, mark it as a visiting node and start
    // visiting other nodes.
    visitingSet.add(node);

    // If each node result in a cycle, return false.
    for (int neighbourCourse : neighbourCourses) {
      if(!dfs(neighbourCourse, prereqMap, visitingSet)){
        return false;
      }
    }
    // Otherwise make the prerequisite courses (neighbour nodes) empty for that node
    prereqMap.put(node, new ArrayList<>());
    // Remove the node from the set since we're done with it and it's already visited.
    visitingSet.remove(node);
    return true;

  }
}