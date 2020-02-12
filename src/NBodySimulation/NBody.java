package NBodySimulation;

public class NBody {

    public static double readRadius(String inFile){
        In in = new In(inFile);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
}
