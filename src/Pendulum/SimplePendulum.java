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

    public double getTimestep(){
        return timestep;
    }

    public void setTimestep(double timestep){
        this.timestep = timestep;
    }

    @Override
    public void paint(Graphics g) {
        int pivotX = getWidth() / 2;
        int pivotY = getHeight() / 2;
        int ballX = pivotX + (int) (Math.sin(angle) * length);
        int ballY = pivotY + (int) (Math.cos(angle) * length);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.RED);
        g2d.drawLine(pivotX, pivotY, ballX, ballY);
        g2d.setStroke(new BasicStroke());
        g2d.fillOval(pivotX - 3, pivotY - 4, 7, 7);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(ballX - 7, ballY - 7, 14, 14);
    }
}
