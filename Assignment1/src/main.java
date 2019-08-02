import java.util.ArrayList;

public class main {


    public static void main(String[] args) {

    GridBuilder gb710 = new GridBuilder(7, 10);
   // gb710.printGrid();
    //GridBuilder gb1120 = new GridBuilder(11,20);
    //gb1120.printGrid();
    DFS dfs = new DFS(gb710.getGrid());

    ArrayList<Node> dfsPath =  dfs.getPath();
    for( Node i : dfsPath)
    {
        System.out.println("Path is" + (i.getPosy()+1) + " "+ (i.getPosx()+1));
    }


    }
}
