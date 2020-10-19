package po1.it.unive.polygon;

public class Rectangle {
    public int edge1Length;
    public int edge2Length;

    public int getArea(){
        return this.edge1Length*this.edge2Length;
    }
}
