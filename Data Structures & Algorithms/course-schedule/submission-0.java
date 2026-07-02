class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int pair[]: prerequisites){
            if(!graph.containsKey(pair[0])){
                graph.put(pair[0], new ArrayList<>());
            }
            graph.get(pair[0]).add(pair[1]);
        }

        boolean visited[] = new boolean[numCourses];
        HashSet<Integer> canBeCompleted = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            if(!canBeCompleted.contains(i)){
                if(!dfs(graph, i, visited, canBeCompleted))
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> graph, int currCourse, boolean visited[], HashSet<Integer> canBeCompleted){
        if(visited[currCourse])
            return false;
        
        visited[currCourse] = true;
        List<Integer> neighbours = graph.get(currCourse);
        if(neighbours == null){
            canBeCompleted.add(currCourse);
            return true;
        }
        for(int neigh: neighbours){
            if(canBeCompleted.contains(neigh)){
                continue;
            }
            if(!dfs(graph, neigh, visited, canBeCompleted))
                return false;
        }
        visited[currCourse] = false;
        return true;
    }
}
