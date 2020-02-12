package NBodySimulation;

public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName){
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    // calculate distance between two planets
    public double calcDistance(Planet p){
        double dx = Math.pow(p.xxPos - xxPos,2.0);
        double dy = Math.pow(p.yyPos - yyPos,2.0);
        double r = Math.pow(dx+dy,0.5);
        return r;
    }

    // calculate gravitational force between two planets
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double F = G * p.mass * mass / Math.pow(r,2);
        return F;
    }

    // gravitational force in x-direction
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - xxPos;
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double Fx = F * dx / r;
        return Fx;
    }

    // gravitational force in y-direction
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - yyPos;
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double Fy = F * dy / r;
        return Fy;
    }

}
