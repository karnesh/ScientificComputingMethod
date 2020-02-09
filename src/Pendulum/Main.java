package Pendulum;

/**
 * Author: Karnesh.
 */

public class Main {
    public static void main(String[] args)
    {
        SimplePendulum pendulum = new SimplePendulum(1, 9.8,1.0);
        pendulum.run();
    }
}
