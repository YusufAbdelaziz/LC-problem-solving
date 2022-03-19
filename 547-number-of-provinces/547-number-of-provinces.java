class Solution {
    private void dfs(int node, int[][] isConnected, boolean [] visited){
       visited[node] = true; 
       for(int i = 0; i < isConnected[node].length ; i++){
           if(isConnected[node][i] == 1 && !visited[i]){
               dfs(i, isConnected, visited);
           }
       }
    }
    
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected[0].length];
        int provincesNum = 0;
        
        for(int i = 0; i < isConnected[0].length ; i++){
            if(!visited[i]){
                provincesNum++;
                dfs(i, isConnected, visited);
            }
        }
        
        return provincesNum;
    }
}