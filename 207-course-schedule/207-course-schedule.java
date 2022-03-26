enum NodeState {
    VISITING,
    UNVISITED,
    VISITED
}
class Solution {
    
    
     public static boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> prereqMap = new HashMap<>();
    Set<Integer> visitedSet = new HashSet<>();

    for (int i = 0; i < prerequisites.length; i++) {
      List<Integer> requiredCourses = prereqMap.getOrDefault(prerequisites[i][0],
          new ArrayList<Integer>());
      requiredCourses.add(prerequisites[i][1]);
      prereqMap.put(prerequisites[i][0], requiredCourses);
    }

    for (int i = 0; i < numCourses; i++) {
      if(!dfs(i, prereqMap, visitedSet)) return false;
    }

    

    return true;
  }

  private static boolean dfs(int node, HashMap<Integer, List<Integer>> prereqMap, Set<Integer> visitedSet) {
    List<Integer> neighbourCourses = prereqMap.getOrDefault(node, new ArrayList<Integer>());

    if (visitedSet.contains(node) )
      return false;
    
    if(neighbourCourses.isEmpty())
      return true;

    visitedSet.add(node);

    for (int neighbourCourse : neighbourCourses) {
      if(!dfs(neighbourCourse, prereqMap, visitedSet)){
        return false;
      }
    }
    prereqMap.put(node, new ArrayList<>());
    visitedSet.remove(node);
    return true;

  }
}