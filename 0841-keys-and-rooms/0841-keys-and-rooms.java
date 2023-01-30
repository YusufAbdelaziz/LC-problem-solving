class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visitedRooms = new boolean[rooms.size()];
        
        visitRoomsInDFS(0, rooms, visitedRooms);
        for(boolean visitedRoom : visitedRooms) {
            if(!visitedRoom) return false;
        }
        
        return true;
        
    }
    
    private void visitRoomsInDFS(int room, List<List<Integer>> rooms, boolean[] visitedRooms ) {
        visitedRooms[room] = true;
        for(int nextRoomKey : rooms.get(room)){
            if(!visitedRooms[nextRoomKey]) {
                visitRoomsInDFS(nextRoomKey, rooms, visitedRooms);
            }
        }
    }
}