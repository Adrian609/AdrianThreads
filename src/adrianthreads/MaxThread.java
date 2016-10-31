/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrianthreads;

/**
 *
 * @author Flako
 */
public class MaxThread extends Thread {

    int pos;
    int[] x, w;

    public MaxThread(int[] x, int[] w, int pos) {
        this.x = x;
        this.w = w;
        this.pos = pos;
    }

    @Override
    public void run() {
        if (w[pos] == 1) {
            System.out.println("Max: " + x[pos]
                    + "\nPosition: " + pos);
        }
    }
}
