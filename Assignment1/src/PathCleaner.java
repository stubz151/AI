import java.util.ArrayList;

public class PathCleaner {
    private ArrayList<Node> path;

    public PathCleaner(ArrayList<Node> path) {
        this.path = path;
        Clean();
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public void setPath(ArrayList<Node> path) {
        this.path = path;
    }

    public void Clean()
    {
        Boolean pathcleaned =false;
        int i =0;
        while(!pathcleaned) {

                if (i+1 == path.size())
                {
                    pathcleaned=true;
                }
                if (i + 1 < path.size()) {
                    Node cur = path.get(i);
                    Node next = path.get(i + 1);
                    if (cur.getPosx() - next.getPosx() != 0 && cur.getPosy() - next.getPosy() != 0) {
                        pathcleaned = false;
                        path.remove(i + 1);
                        i=0;
                    }
                    else
                    {
                        i++;
                    }

                }
            }

        for (Node j : path)
        {
            System.out.println(j.toString());
        }
    }

}
