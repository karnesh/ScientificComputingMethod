package Pendulum;

import javax.swing.*;
import java.awt.*;

public class SimplePendulum extends JFrame{
    private double mass;        // kg
    private double length;      // m
    private double angle;       // rad
    private double angleAcc = 0;
    private double angleVel = 0;
    private double g = 9.81;    // SI units
    private double timestep = 0.01;
    private double damping = 1;

    public SimplePendulum(double mass, double length, double angle){
        this.mass = mass;
        this.length = length;
        this.angle = angle;
    }

    public void run(){
        while (true)
        {
            angleAcc = - (g / length) * Math.sin(angle) - (damping  * angleVel);
            angleVel += angleAcc * timestep;
            angle += angleVel * timestep;
            repaint();
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
        }
    }

    public double getMass(){
        return mass;
    }

    public void setMass(double mass){
        this.mass = mass;
    }

    public double getLength(){
        return length;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getAngle(){
        return angle;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }
}
