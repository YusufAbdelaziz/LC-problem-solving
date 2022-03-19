class Solution {
    
    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean [] roomsVisited){
        roomsVisited[currentRoom] = true;
        
        for(int neighbourRoom : rooms.get(currentRoom)){
            if(!roomsVisited[neighbourRoom])
                dfs(neighbourRoom, rooms, roomsVisited);
        }
    }
    
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] roomsVisited = new boolean[rooms.size()];
        dfs(0, rooms, roomsVisited);
        for(boolean isCurrentRoomVisited : roomsVisited){
            if(!isCurrentRoomVisited) return false;
        }
        
        return true;
    }
}