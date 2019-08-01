public class Node {
    private int posx ,posy , weight;

    public Node(int posx, int posy, int weight) {
        this.posx = posx;
        this.posy = posy;
        this.weight = weight;
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
