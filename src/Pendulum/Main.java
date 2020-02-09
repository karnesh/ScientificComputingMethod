package Pendulum;

/**
 * Author: Karnesh.
 */

public class Main {
    public static void main(String[] args)
    {
        SimplePendulum pendulum = new SimplePendulum(1, 100,1.0);
        new Thread(pendulum).start();
    }
}
