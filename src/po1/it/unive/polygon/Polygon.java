package po1.it.unive.polygon;

abstract public class Polygon {
    protected int[] edge;

    final public int getPerimeter() {
        int result = 0;
        for(int i = 0; i < edge.length; i++) {
            result = result + edge[i];
        }
        return result;
    }
}

