import java.util.*;

public class BFS {
    private ArrayList<Node> path;
    private int grid[][];
    Boolean found = false;
    private Queue<Node> frontier;
    private HashSet<Node> explored;

    public BFS(int[][] grid) {
        this.grid = grid;
        frontier = new LinkedList<>();
        explored = new HashSet<>();
        path= new ArrayList<Node>();
        RecursionStarter();
    }

    public ArrayList<Node> getPath() {
        return path;
    }
    public void RecursionStarter()
    {
        int init = (grid.length/2);
        int[] cur  = new int[2];
        int[] goal;
        goal = new int[2];
        goal[0] = init;
        goal[1] = grid[1].length-1;
        Node g = new Node(goal[0] , goal[1]);
        System.out.println("GOAL CELL IS " + goal[0] +": "+  goal[1]);
        cur[0] = init;
        cur[1] =0;
        System.out.println("Starting cell is " + cur[0] +": "+  cur[1]);
        Node startNode =  new Node(cur[0], cur[1]);
        ArrayList<Node> pathhere= new ArrayList<>();
        pathhere.add(startNode);
        frontier.add(startNode);
        doBFS(g, pathhere);
    }
    //note this is currently not recrusive so will not have accurate path, please redo
    public void doBFS(Node goal , ArrayList<Node> pathhere)
    {
        if (pathhere.contains(goal)  || frontier.size()==0) {
            return ;
        }
        Node cur = frontier.remove();
        System.out.println(cur.toString());
        explored.add(cur);
        int x = cur.getPosx();
        int y = cur.getPosy();

        //add left ele, add right ele, add eleabove, addelebelow
         if (x > 0) {
             Node nodeNext = new Node(x - 1, y, grid[x - 1][y]);
             if (nodeNext.getWeight() > 0) {
                 if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                     frontier.add(nodeNext);
                     if (nodeNext.equals(goal)) {
                         pathhere.add(nodeNext);
                         path = pathhere;
                         return;
                     }
                     if (!path.contains(goal)) {
                         pathhere.add(nodeNext);


                     }
                 }
             }
         }
         if (x<grid.length)
         {
             Node nodeNext = new Node(x + 1, y, grid[x + 1][y]);
                if (nodeNext.getWeight() > 0) {
                 if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                 frontier.add(nodeNext);
                     if (nodeNext.equals(goal)) {
                         pathhere.add(nodeNext);
                         path = pathhere;
                         return;
                     }
                     if (!path.contains(goal)) {
                         pathhere.add(nodeNext);

                     }
             }
             }
         }
         if (y>0)
         {
             Node nodeNext = new Node(x , y-1, grid[x][y-1]);
             if (nodeNext.getWeight() > 0) {
                 if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                     frontier.add(nodeNext);
                     if (nodeNext.equals(goal)) {
                         pathhere.add(nodeNext);
                         path = pathhere;
                         return;
                     }
                     if (!path.contains(goal)) {
                         pathhere.add(nodeNext);

                     }
                 }
             }
         }
         if (y<grid[1].length)
         {
             Node nodeNext = new Node(x , y+1, grid[x][y+1]);
             if (nodeNext.getWeight() > 0) {
                 if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                     frontier.add(nodeNext);
                     if (nodeNext.equals(goal)) {
                         pathhere.add(nodeNext);
                         path = pathhere;
                         return;
                     }
                     if (!path.contains(goal)) {
                         pathhere.add(nodeNext);
                     }
                 }
             }
         }
         doBFS(goal, pathhere);
        }


}
