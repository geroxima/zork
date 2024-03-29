public class Room extends Thing{
    private int n, s, e, w;

    public Room(String aName, String aDescription, int n, int s, int e, int w) {
        super(aName, aDescription);
        this.n = n;
        this.s = s;
        this.e = e;
        this.w = w;
    }

    public int getN() {
        return n;
    }

    public int getS() {
        return s;
    }

    public int getE() {
        return e;
    }

    public int getW() {
        return w;
    }
}