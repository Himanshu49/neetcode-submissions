class Solution {
    ArrayList<Integer> res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int pair[]: prerequisites){
            if(graph[pair[0]] == null)
                graph[pair[0]] = new ArrayList<>();
            graph[pair[0]].add(pair[1]);
        }

        // 0 unvisited, 1 visited, 2 can be completed
        int courseState[] = new int[numCourses];
        Arrays.fill(courseState, 0);
        for(int i=0;i<numCourses;i++){
            if(courseState[i] == 0){
                if(!dfs(graph, i, courseState))
                    return new int[] {};
            }
        }

        int[] resArray = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    public boolean dfs(List<Integer>[] graph, int currCourse, int courseState[]){
        if(courseState[currCourse] == 1)
            return false;
        
        courseState[currCourse] = 1;
        List<Integer> neighbours = graph[currCourse];
        if(neighbours == null){
            res.add(currCourse);
            courseState[currCourse] = 2;
            return true;
        }
        for(int neigh:neighbours){
            if(courseState[neigh] == 2){
                continue;
            }
            if(!dfs(graph, neigh, courseState)){
                return false;
            }
        }
        courseState[currCourse] = 2;
        res.add(currCourse);
        return true;
    }
}
