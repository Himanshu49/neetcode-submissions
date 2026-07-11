class Solution {
    class Point{
        int x;
        int y;
        double dist;
        public Point(int i, int j, double d){
            x = i;
            y = j;
            dist = d;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> distanceToOrigin = new PriorityQueue<>(
            (a,b) -> Double.compare(a.dist, b.dist)
        );
        for(int point[]: points){
            double dist = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            distanceToOrigin.add(new Point(point[0], point[1], dist));
        }

        int res[][] = new int[k--][2];
        while(k>=0){
            Point curr = distanceToOrigin.poll();
            res[k][0] = curr.x;
            res[k][1] = curr.y;
            k--;
        }

        return res;
    }
}
