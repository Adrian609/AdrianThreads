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
public class wThread implements Runnable {

    int position;
    int[] array;

    public wThread(int[] array, int position) {
        this.array = array;
        this.position = position;
    }

    public void run() {
        array[position] = 1;
        // System.out.println(position);
    }
}
