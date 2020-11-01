package po1.it.unive.polygon;

public class Rhombus extends Quadrilateral {

    private int edgeLength, height;
    public Rhombus(int edgeLength, int height, int edge) {
        this.edgeLength = edgeLength;
        this.height = height;
    }
    public int getArea () {
        return (this.edgeLength * this.height ) / 2;
    }
}
