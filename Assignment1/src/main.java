import java.util.ArrayList;

public class main {


    public static void main(String[] args) {

    GridBuilder gb710 = new GridBuilder(7, 10);
    gb710.printGrid();
    GridBuilder gb1120 = new GridBuilder(11,20);
    //gb1120.printGrid();
    //DFS dfs = new DFS(gb1120.getGrid());
    //BFS bfs = new BFS(gb710.getGrid());
    //ArrayList<Node> dfsPath =  dfs.getPath();
    //ArrayList<Node> bfsPath =  bfs.getPath();
    /*
    for( Node i : bfsPath)
    {
        System.out.println("Path is " + (i.getPosx()) + " " +i.getPosy());
    }

    for( Node i : dfsPath)
    {
        System.out.println("Path is" + (i.getPosx()+1) + " "+ (i.getPosy()+1));
    }

     */
    UniformCostSearch ucs = new UniformCostSearch(gb710.getGrid());
    ArrayList<Node> ucsPath =  ucs.getPath();
    for( Node i : ucsPath)
        {
         System.out.println("Path is" + (i.getPosx()) + " "+ (i.getPosy()));
        }
    }

}
