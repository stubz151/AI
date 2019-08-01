import java.util.HashSet;
import java.util.Stack;

public class DFS {

    private int path[][];
    private int grid[][];
    private Stack<Integer> frontier;
    private HashSet<int[]> explored;
    public DFS(int [][] g) {
        this.grid = g;
        DepthFirstSearch();
        frontier = new Stack<Integer>();
        explored = new HashSet<>();
    }

    public void DepthFirstSearch()
    {

        int[] init = grid[(grid.length/2)][0];
        frontier.push((grid[1][0]));
    }
}
