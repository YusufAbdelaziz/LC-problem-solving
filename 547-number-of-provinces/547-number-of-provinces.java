class Solution {
    private void dfs(int node, int[][] isConnected, boolean [] visited){
       visited[node - 1] = true; 
       for(int i = 1; i <= isConnected[node - 1].length ; i++){
           if(isConnected[node - 1][i - 1] == 1 && !visited[i - 1]){
               dfs(i, isConnected, visited);
           }
       }
    }
    
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected[0].length];
        int provincesNum = 0;
        
        for(int i = 1; i <= isConnected[0].length ; i++){
            if(!visited[i - 1]){
                provincesNum++;
                dfs(i, isConnected, visited);
            }
        }
        
        return provincesNum;
    }
}