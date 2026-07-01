class Solution {
    public int countComponents(int n, int[][] edges) {
        int graph[][] = new int[n][n];
        for(int[] edge: edges){
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        int countOfConnectedComponents = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];

        
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            else{
                queue.add(i);
                countOfConnectedComponents++;
                while(queue.size() > 0){
                    int currNode = queue.poll();
                    visited[currNode] = true;

                    for(int j=0;j<n;j++){
                        if(graph[currNode][j] == 1 && !visited[j]){
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return countOfConnectedComponents;
    }
}
