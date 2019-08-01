import java.io.*;
import java.util.Scanner;

public class GridBuilder {
    private int[][] grid;
    private int gridWidth, gridLength;
   // private Node[] nodes;
    public GridBuilder(int gw,int gl) {
        this.gridWidth=gw;
        this.gridLength=gl;
        build();
    }

    private void build()
    {
        int lengthPos = 0;
        grid = new int[gridWidth][gridLength];
        String name = "Maze" +gridWidth + "x" + gridLength+".txt";
        try {
            File file = new File(name);
            Scanner input = new Scanner(file);
            while (input.hasNextLine())
            {
                char[] chars = input.nextLine().toCharArray();
                if (chars==null)
                {
                    input.close();
                }
                for (int i =0 ; i < gridWidth ; i++)
                {
                grid[i][lengthPos] = Character.getNumericValue(chars[i]);
                }
                lengthPos++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int[][] getGrid() {
        return grid;
    }
    public void printGrid()
    {
        for (int i=0; i < gridLength ; i++)
        {
            for (int j=0; j < gridWidth ; j++)
            {
                System.out.print(grid[j][i] + " ");

            }
            System.out.println();
        }
    }
}
