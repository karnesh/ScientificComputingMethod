package NBodySimulation;

public class NBody {

    /*
    Read radius of universe
    Uses Standard Input library from http://introcs.cs.princeton.edu
     */
    public static double readRadius(String inFile){
        In in = new In(inFile);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /*
     Read all the planets from text file to an array
     Uses Standard Input library from http://introcs.cs.princeton.edu
     */
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

    // main method
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
    }
}
