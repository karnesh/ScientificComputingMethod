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

        StdDraw.enableDoubleBuffering();

        for(double t = 0; t<=T; t+=dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for(int i = 0; i < planets.length; i++){
                for(int j = 0; j < planets.length; j++){
                    if(i==j) continue;
                    xForces[i] += planets[i].calcForceExertedByX(planets[j]);
                    yForces[i] += planets[i].calcForceExertedByY(planets[j]);
                }
            }
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0,0,"./images/starfield.jpg");

            for(int i = 0; i < planets.length; i++){
                planets[i].update(dt,xForces[i],yForces[i]);
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(15);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
