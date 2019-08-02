import java.util.*;

public class BFS {
    private ArrayList<Node> path;
    private int grid[][];
    Boolean found = false;
    private Queue<Node> frontier;
    private HashSet<Node> explored;

    public BFS(int[][] grid) {
        this.grid = grid;
        frontier = new PriorityQueue<>();
        explored = new HashSet<>();
        path= new ArrayList<Node>();
    }
    public void RecursionStarter()
    {
        int init = (grid.length/2);
        int[] cur  = new int[2];
        int[] goal;goal = new int[2];
        goal[0] = init;
        goal[1] = grid[1].length-1;
        Node g = new Node(goal[0] , goal[1]);
        System.out.println("GOAL CELL IS " + goal[0] +": "+  goal[1]);
        cur[0] = init;
        cur[1] =0;
        System.out.println("Starting cell is " + cur[0] +": "+  cur[1]);
        Node startNode =  new  Node(cur[0], cur[1]);
        path.add(startNode);
        frontier.add(startNode);
        doBFS(g);
    }
    public void doBFS(Node goal)
    {
        Node cur = frontier.remove();
        explored.add(cur);
        int x = cur.getPosx();
        int y = cur.getPosy();
        while (!frontier.contains(goal))
        {

        }

    }
}
