package Pendulum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimplePendulum extends JFrame implements Runnable{
    private double mass;        // kg
    private double length;      // m
    private double angle;       // rad
    private double angleAcc = 0;
    private double angleVel = 0;
    private double g = 9.81;    // SI units
    private double timestep = 0.01;
    private double damping = 0.005;

    public SimplePendulum(double mass, double length, double angle){
        this.mass = mass;
        this.length = length;
        this.angle = angle;

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent me)
            {
                setAngle((Math.PI / 2) - getAngleFromCentre(me.getPoint()));
                setAngleAcc(0);
                setAngleVel(0);
                repaint();
            }
        });
    }

    public void run(){
        while (true)
        {
            for (int i = 0; i < 0.1/timestep; i++) {
                angleAcc = - (g / length) * Math.sin(angle) - (damping  * angleVel);
                angleVel += angleAcc * timestep;
                angle += angleVel * timestep;
            }
            repaint();
            try { Thread.sleep(10); } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private double getAngleFromCentre(Point target)
    {
        return Math.atan2(target.y - (getHeight() / 2.0),
                target.x - (getHeight() / 2.0));
    }

    public void setAngleAcc(double angleAcc){
        this.angleAcc = angleAcc;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public void setAngleVel(double angleVel){
        this.angleVel = angleVel;
    }

    @Override
    public void paint(Graphics g) {
        int pivotX = getWidth() / 2;
        int pivotY = getHeight() / 2;
        int ballX = pivotX + (int) (Math.sin(angle) * length);
        int ballY = pivotY + (int) (Math.cos(angle) * length);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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

    @Override
    public Dimension getPreferredSize() {
        int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.7);
        return new Dimension(width, width);
    }
}
