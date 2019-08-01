import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DFS {
    private ArrayList<int[]> path;
    private int grid[][];
    Boolean found = false;
    private Stack<int[]> frontier;
    private HashSet<int[]> explored;
    // x is 0 y is 1

    public DFS(int [][] g) {
        this.grid = g;
       // DepthFirstSearch();
        frontier = new Stack<>();
        explored = new HashSet<>();
        path= new ArrayList<>();
        RecursionStarter();
    }

    public ArrayList<int[]> getPath() {
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
        int init = (grid[0].length/2)+1;
        int[] cur  = new int[2];
        int[] goal = new int[2];
        goal[0] = init;
        goal[1] = grid[1].length-1;
        cur[0] = init;
        cur[1] =0;
        frontier.push(cur);
        doDFS(goal,cur , new ArrayList<>());
    }

    public void doDFS(int[] goal, int[] pos, ArrayList<int[]> pathhere)
    {
        pathhere.add(pos);
        if (found==true)
        {
            return;
        }
        if (pathhere.contains(goal))
        {
            found = true;
            path = pathhere;
            return;
        }
        int cur [] = frontier.pop();
        explored.add(cur);
        //check down
        if (cur[1]<grid[1].length)
        if (grid[cur[0]][cur[1]+1] >0)
        {
            int[] nextPos = new int[2];
            nextPos[0]=cur[0];
            nextPos[1]=cur[1]+1;
            if ((!explored.contains(nextPos)) && !frontier.contains(nextPos))
            {
                frontier.push(nextPos);
                doDFS(goal, nextPos , pathhere);
            }
        }

        //check left
        if (cur[0]>=0) {
            if (grid[cur[0] - 1][cur[1]] > 0) {
                int[] nextPos = new int[2];
                nextPos[0] = cur[0] - 1;
                nextPos[1] = cur[1];
                if ((!explored.contains(nextPos)) && !frontier.contains(nextPos)) {
                    frontier.push(nextPos);
                    doDFS(goal, nextPos, pathhere);
                }
            }
        }
        //check right
        System.out.println(cur[0]);
        if (cur[0]<grid[0].length)
        {
            if (grid[cur[0]+1][cur[1]] >0)
            {
                int[] nextPos = new int[2];
                nextPos[0]=cur[0]+1;
                nextPos[1]=cur[1];
                if ((!explored.contains(nextPos)) && !frontier.contains(nextPos))
                {
                    frontier.push(nextPos);
                    doDFS(goal, nextPos , pathhere);
                }
            }
        }


    }

}
