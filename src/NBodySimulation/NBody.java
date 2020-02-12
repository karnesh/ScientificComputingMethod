package NBodySimulation;

public class NBody {

    public static double readRadius(String inFile){
        In in = new In(inFile);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String inFile){
        In in = new In(inFile);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] planet = new Planet[num];

        for(int i = 0; i < num; i++){
            planet[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),in.readString());
        }
        return planet;
    }
}
