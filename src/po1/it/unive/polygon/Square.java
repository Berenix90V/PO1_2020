package po1.it.unive.polygon;

import po1.it.unive.Printable;

public class Square extends Rectangle implements Printable {
    public Square(int edge){
        super(edge, edge);
    }

    @Override
    public void print() {
        System.out.print("This is a square with edge of "+super.edge[0]+" cm.");
    }
}
