import java.util.*;

public class UniformCostSearch {
    private Queue<Node> frontier;
    private HashSet<Node> explored;
    private int grid[][];
    private ArrayList<Node> path;
    private boolean found = false;
    public UniformCostSearch(int[][] grid) {
        this.grid = grid;
       // frontier = new PriorityQueue<>(WeightComparator);
        frontier= new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        explored = new HashSet<>();
        this.grid = grid;
        path = new ArrayList<>();
        RecursionStarter();
        System.out.println(path.get(0));
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public void RecursionStarter()
    {
        int init = (grid.length/2);
        int[] cur  = new int[2];
        int[] goal = new int[2];
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
        doNodeUCS(g, new ArrayList<>());
    }

    private void doNodeUCS(Node goal,ArrayList<Node> pathHere) {

        if (frontier.isEmpty() || found) {
            return;
        }
        Node cur = frontier.remove();
        pathHere.add(cur);
        cur.toString();
            if (cur.equals( goal)) {
                found = true;
                path = pathHere;
                return;
            }
            explored.add(cur);
            int x = cur.getPosx();
            int y = cur.getPosy();
            //check down
            if (y < grid[1].length-1) {
                Node nodeNext = new Node(x, y + 1, grid[x][y + 1]);
                if (nodeNext.getWeight() > 0) {
                    System.out.println(nodeNext.toString());
                    if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                        frontier.add(nodeNext);

                    }
                }
            }
            //check left
            if (cur.getPosx() > 0) {
                Node nodeNext = new Node(x - 1, y, grid[x - 1][y]);
                if (nodeNext.getWeight() > 0) {

                    System.out.println(nodeNext.toString());
                    if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                        frontier.add(nodeNext);

                    }
                }
            }
            //check right
            if (cur.getPosx() < grid[1].length) {
                Node nodeNext = new Node(x + 1, y, grid[x + 1][y]);
                if (nodeNext.getWeight() > 0) {
                    System.out.println(nodeNext.toString());
                    if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                        frontier.add(nodeNext);

                    }
                }
            }

            //check up
            if (y > 0) {
                Node nodeNext = new Node(x, y - 1, grid[x][y - 1]);
                if (nodeNext.getWeight() > 0) {
                    if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                        frontier.add(nodeNext);
                    }
                }
            }
            doNodeUCS(goal, pathHere);
        }


}
