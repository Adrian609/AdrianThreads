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
public class CompareThread extends Thread {

    int[] x, w;
    int positionI, positionJ;

    public CompareThread(int[] x, int[] w, int positionI, int positionJ) {
        this.x = x;
        this.w = w;
        this.positionI = positionI;
        this.positionJ = positionJ;
    }

    public void run() {
        boolean i;

        if (x[positionI] < x[positionJ]) {
            i = true;
            w[positionI] = 0;
        } else {
            i = false;
            w[positionJ] = 0;
        }

        System.out.println("Thread T(" + positionI + "," + positionJ + ") "
                + "compares x[" + positionI + "] = " + x[positionI] + " "
                + "and x[" + positionJ + "] = " + x[positionJ] + ", "
                + "and writes 0 into w[" + (i ? positionI : positionJ) + "]");
    }
}
