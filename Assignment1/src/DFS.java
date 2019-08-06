import java.lang.reflect.Array;
import java.util.*;

public class DFS {
    private ArrayList<Node> path;
    private int grid[][];
    Boolean found = false;
    private Stack<Node> frontier;
    private HashSet<Node> explored;

    // x is 0 y is 1

    public DFS(int [][] g) {
        this.grid = g;
       // DepthFirstSearch();
        frontier = new Stack<>();
        explored = new HashSet<>();
        path= new ArrayList<Node>();
       RecursionStarter();
    }
    public ArrayList<Node> getPath() {
        return path;
    }

    /*
        public ArrayList<int[]> DepthFirstSearch()
        {
            int init = (grid[0].length/2)+1;
            int[] cur  = new int[2];
            int[] goal = new int[2];
            goal[0] = init;
            goal[1] = grid[1].length-1;
            cur[0] = init;
            cur[1] =0;
            frontier.push(cur);
            while(!frontier.contains(goal))
            {
            cur = frontier.pop();
            explored.add(cur);
            //check down
            if (grid[cur[0]][cur[1]+1] >0)
                {
                    int[] nextPos = new int[2];
                    nextPos[0]=cur[0];
                    nextPos[1]=cur[1]+1;
                        if ((!explored.contains(nextPos)) && !frontier.contains(nextPos))
                        {
                            frontier.push(nextPos);
                            continue;
                        }
                }
            //check left
                if (grid[cur[0]-1][cur[1]] >0)
                {
                    int[] nextPos = new int[2];
                    nextPos[0]=cur[0]-1;
                    nextPos[1]=cur[1];
                    if ((!explored.contains(nextPos)) && !frontier.contains(nextPos))
                    {
                        frontier.push(nextPos);
                        continue;
                    }
                }
            //check right
                if (grid[cur[0]+1][cur[1]] >0)
                {
                    int[] nextPos = new int[2];
                    nextPos[0]=cur[0]+1;
                    nextPos[1]=cur[1];
                    if ((!explored.contains(nextPos)) && !frontier.contains(nextPos))
                    {
                        frontier.push(nextPos);
                        continue;
                    }
                }
                }
            return path;
        }
        */
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
        frontier.push(startNode);
        ArrayList<Node> pathhere = new ArrayList<>();
        pathhere.add(startNode);
        doNodeDFS(g,pathhere);
    }
    private void doNodeDFS(Node goal, ArrayList<Node> pathhere) {
        if (found == true)
        {
            return;
        }
        if (frontier.contains(goal))
        {

            found = true;
            return;
        }
        Node cur = frontier.pop();
        explored.add(cur);
        int x = cur.getPosx();
        int y = cur.getPosy();

        //check down
        if (y < grid[1].length) {
            Node nodeNext = new Node(x,y+1, grid[x][y+1]);
            if (nodeNext.getWeight()>0)
            {
                System.out.println(nodeNext.toString());
                if(!explored.contains(nodeNext)&&!frontier.contains(nodeNext))
                {
                    frontier.push(nodeNext);
                    if (!pathhere.contains(goal))
                    {
                        pathhere.add(nodeNext);
                        doNodeDFS(goal,pathhere);
                    }
                    if (pathhere.contains(goal))
                    {
                        found=true;
                        path = pathhere;
                        return;
                    }
                }
            }
        }
        //check left
        if (cur.getPosx()>0) {
            Node nodeNext = new Node(x - 1, y, grid[x - 1][y]);
            if (nodeNext.getWeight() > 0) {
                System.out.println(nodeNext.toString());
                if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                    frontier.push(nodeNext);
                    if (!pathhere.contains(goal))
                    {
                        pathhere.add(nodeNext);
                        doNodeDFS(goal,pathhere);
                    }
                    if (pathhere.contains(goal))
                    {
                        found=true;
                        path = pathhere;
                        return;
                    }

                }
            }
        }
        //check right
        if (cur.getPosx()<grid[1].length) {
            Node nodeNext = new Node(x + 1, y, grid[x + 1][y]);
            if (nodeNext.getWeight() > 0) {
                System.out.println(nodeNext.toString());
                if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                    frontier.push(nodeNext);
                    if (!pathhere.contains(goal))
                    {
                        pathhere.add(nodeNext);
                        doNodeDFS(goal,pathhere);
                    }
                    if (pathhere.contains(goal))
                    {
                        found=true;
                        path = pathhere;
                        return;
                    }

                }
            }
        }
        //check up
        if (cur.getPosy()>0) {
            Node nodeNext = new Node(x, y-1, grid[x][y-1]);
            if (nodeNext.getWeight() > 0) {
                System.out.println(nodeNext.toString());
                if (!explored.contains(nodeNext) && !frontier.contains(nodeNext)) {
                    frontier.push(nodeNext);
                    if (!pathhere.contains(goal))
                    {
                        pathhere.add(nodeNext);
                        doNodeDFS(goal,pathhere);
                    }
                    if (pathhere.contains(goal))
                    {
                        found=true;
                        path = pathhere;
                        return;
                    }

                }
            }
        }
    }







    /*
    public void doDFS(Node goal, Node cur) {
        //  System.out.println("" +pos[0] +" "+ pos[1]);
        Node node = new Node(pos[0] , pos[1]);
        path.add(node);
        Node cur = frontier.pop();
        explored.add(cur);
        if (found == true) {
            return;
        }
        else
        {
            System.out.println("I am cell" + cur.getPosx() + ":" + cur.getPosy());
        }
        if (path.contains(goal)) {
            found = true;
            return;
        }
        //check down
        if (y < grid[1].length - 1) {
            y = cur[1] + 1;
            int numDown = grid[(cur[0])][y];
            if (numDown > 0) {
                int[] nextPos = new int[2];
                nextPos[0] = cur[0];
                nextPos[1] = cur[1] + 1;
                String nextString = nextPos[0] + "" + nextPos[1];
                if ((!explored.contains(nextString))) {
                    if (!frontier.contains(nextPos)) {
                        Node sb = cur[0] + "" + cur[1];
                        explored.add(sb);
                        System.out.println("I am going down to : " + nextPos[0] + ":" + nextPos[1]);
                        frontier.push(nextPos);
                        doDFS(goal, nextPos);
                    }
                }
            }
        }
        //check left
        if (cur[0] >= 0) {
            int numLeft = grid[(cur[0] - 1)][cur[1]];
            if (numLeft > 0) {
                int[] nextPos = new int[2];
                nextPos[0] = cur[0] - 1;
                nextPos[1] = cur[1];
                String nextString = nextPos[0] + "" + nextPos[1];
                if ((!explored.contains(nextString))) {
                    if (!frontier.contains(nextPos)) {
                        Node sb = cur[0] + "" + cur[1];
                        explored.add(sb);
                        System.out.println("I am going Left to : " + nextPos[0] + ":" + nextPos[1]);
                        frontier.push(nextPos);
                        doDFS(goal, nextPos);
                    }
                }
            }
        }
            //check right
        if (cur[0] < grid.length) {
            int numRight = grid[cur[0] + 1][cur[1]];
            if (numRight > 0) {
                int[] nextPos = new int[2];
                nextPos[0] = cur[0] + 1;
                nextPos[1] = cur[1];
                String nextString = nextPos[0] + "" + nextPos[1];
                if ((!explored.contains(nextString))) {
                    if (!frontier.contains(nextPos)) {
                        Node sb = cur[0] + "" + cur[1];
                        explored.add(sb);
                        System.out.println("I am going Right to : " + nextPos[0] + ":" + nextPos[1]);
                        frontier.push(nextPos);
                        doDFS(goal, nextPos);
                    }
                }
            }

        }
        }//END OF RECURSION
        */
    }

