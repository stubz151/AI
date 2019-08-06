import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        GridBuilder gb710 = new GridBuilder(7, 10);
        //gb710.printGrid();
        GridBuilder gb1120 = new GridBuilder(11, 20);
       // gb1120.printGrid();
        GridBuilder gb101100 = new GridBuilder(101, 100);
        //gb101100.printGrid();
        //gb1120.printGrid();
        //IterativeDeepening id= new IterativeDeepening(gb710.getGrid());
        //IterativeDeepening id = new IterativeDeepening(gb1120.getGrid());
        //IterativeDeepening id = new IterativeDeepening(gb101100.getGrid());
       // UniformCostSearch id = new UniformCostSearch(gb710.getGrid());
       // UniformCostSearch id = new UniformCostSearch(gb1120.getGrid());
       // UniformCostSearch id = new UniformCostSearch(gb101100.getGrid());
        DFS id = new DFS(gb710.getGrid());
       // DFS id = new DFS(gb1120.getGrid());
       // DFS id = new DFS(gb101100.getGrid());
        //BFS id = new BFS (gb710.getGrid());
        //BFS id = new BFS (gb1120.getGrid());
        ArrayList<Node> idPath = id.getPath();

        System.out.println("The path is ");
        for (Node i : idPath)
        {
            System.out.print("( " + i.getPosx() + " : "+i.getPosy() + " )") ;
        }


    }
}