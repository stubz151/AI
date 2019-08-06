import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class IterativeDeepening {
    private ArrayList<Node> path;
    private int grid[][];
    Boolean found = false;
    private Stack<Node> frontier;
    private HashSet<Node> explored;

    public IterativeDeepening(int[][] grid) {
        this.grid = grid;
        frontier = new Stack<>();
        explored = new HashSet<>();
        path = new ArrayList<Node>();
        RecursionStarter();
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public void setPath(ArrayList<Node> path) {
        this.path = path;
    }

    private void RecursionStarter() {
        int init = (grid.length / 2);
        int[] cur = new int[2];
        int[] goal = new int[2];
        goal[0] = init;
        goal[1] = grid[1].length - 1;
        Node g = new Node(goal[0], goal[1]);
        System.out.println("GOAL CELL IS " + goal[0] + ": " + goal[1]);
        cur[0] = init;
        cur[1] = 0;
        System.out.println("Starting cell is " + cur[0] + ": " + cur[1]);
        Node startNode = new Node(cur[0], cur[1]);
        frontier.push(startNode);
        ArrayList<Node> pathere = new ArrayList<>();
        int depthAllowed = 1;
        while (!path.contains(goal))
        {
            if (found ==true)
            {
                break;
            }
            doDLS(g, 0, depthAllowed, pathere);
            explored.clear();
            frontier.clear();
            frontier.push(startNode);
            System.out.println("Not found at "+ depthAllowed);
            depthAllowed++;
        }

    }

    private void doDLS(Node goal, int depth, int depthAllowed, ArrayList<Node> pathhere) {
        if (frontier.size() == 0) {
            return;
        }
        if (pathhere.contains(goal)) {
            found = true;
            path = pathhere;
            return;
        }
        Node cur = frontier.pop();
        pathhere.add(cur);
        System.out.println(cur.toString());
        explored.add(cur);
        int x = cur.getPosx();
        int y = cur.getPosy();
        //check down
        if (depth<depthAllowed) {
            if (y < grid[1].length-1) {
                Node nodeNext = new Node(x, y + 1, grid[x][y + 1]);
                if (nodeNext.getWeight() > 0) {
                    if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                        frontier.push(nodeNext);
                        doDLS(goal, depth++, depthAllowed, pathhere);
                        }

                    }
                }
            }
            //check left
            if (cur.getPosx() > 0) {
                Node nodeNext = new Node(x - 1, y, grid[x - 1][y]);
                if (nodeNext.getWeight() > 0) {
                    if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                        frontier.push(nodeNext);
                        doDLS(goal, depth++, depthAllowed, pathhere);
                    }
                }
            }
            //check right
            if (cur.getPosx() < grid[1].length) {
                Node nodeNext = new Node(x + 1, y, grid[x + 1][y]);
                if (nodeNext.getWeight() > 0) {
                    if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                        frontier.push(nodeNext);
                        doDLS(goal, depth++, depthAllowed, pathhere);
                    }
                }
            }
            //check up
            if (cur.getPosy() > 0) {
                Node nodeNext = new Node(x, y - 1, grid[x][y - 1]);
                if (nodeNext.getWeight() > 0) {
                    if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                        frontier.push(nodeNext);
                        doDLS(goal, depth++, depthAllowed, pathhere);
                        }
                 }
                }
            }
        }

