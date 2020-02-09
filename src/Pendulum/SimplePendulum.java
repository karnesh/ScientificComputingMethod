package Pendulum;

import javax.swing.*;
import java.awt.*;

public class SimplePendulum extends Canvas{
    private double mass;        // kg
    private double length;      // m
    private double angle;       // rad
    private double angleAcc = 0;
    private double angleVel = 0;

    public SimplePendulum(double mass, double length, double angle){
        this.mass = mass;
        this.length = length;
        this.angle = angle;
    }

}
