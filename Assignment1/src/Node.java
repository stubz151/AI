import java.util.ArrayList;

public class Node {
    private int posx ,posy , weight;
    private ArrayList<Node> links;

    public Node(int posx, int posy, int weight) {
        this.posx = posx;
        this.posy = posy;
        this.weight = weight;
        this.links = new ArrayList<>();

    }
    @Override
   public int hashCode() {
        int result = posx + (posy*2);
        result =result * 31*posx;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if ((o instanceof Node) && (((Node) o).checkSame(this))) {
            return true;
        }
        else
        {
            return false;
        }
    }


    public Node(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;

    }

    public void addLink(Node node)
    {
    links.add(node);
    }

    public ArrayList<Node> getLinks() {
        return links;
    }
    public Boolean checkSame(Node check)
    {
        if (check.getPosy()==getPosy() && check.getPosx() == getPosx())
        {
            return true;
        }
        return false;
    }
    public String toString()
    {
        return "I AM cell " +posx +" : " +posy +" have a weight of" + weight;
    }
    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
