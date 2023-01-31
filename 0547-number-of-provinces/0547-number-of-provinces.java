class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visitedCities = new boolean[isConnected.length];
        int numOfProvinces = 0;
        for(int i = 0 ; i < isConnected.length ; i++ ){
            if(!visitedCities[i]){
                numOfProvinces++;
                linkProvinceByDFS(i, isConnected,visitedCities);
            }
        }
        
        return numOfProvinces;
    }
    
    private void linkProvinceByDFS(int cityNum, int[][] isConnected, boolean[] visitedCities){
        visitedCities[cityNum] = true;
        
        for(int i = 0 ; i < isConnected[cityNum].length ; i++){
            if(i != cityNum && !visitedCities[i] && isConnected[cityNum][i] == 1){
                linkProvinceByDFS(i, isConnected, visitedCities);
            }
        }
    }
}