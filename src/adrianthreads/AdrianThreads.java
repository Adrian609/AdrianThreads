package adrianthreads;

/**
 *
 * @author Adrian Rodriguez User ID: 0839271 DUE DATE: 10/16/2016 PROGRAM
 * ASSIGNMENT 2 FILE NAME : AdrianThreads
 *
 */
public class AdrianThreads {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int[] x;
        int[] w;
        
        AdrianThreads prog1 = new AdrianThreads();
        x = prog1.readInArgs(args);
        
        
        System.out.println("Number of input values = " + args[0] );

        

        System.out.println("Input Values for x = " + prog1.printArray(x));

        w = prog1.wIntArray(args.length);
        Thread.sleep(100);

        System.out.println("After Initilization w = " + prog1.printArray(w));
       

        prog1.compareThreads(x, w);
        Thread.sleep(100);
        
        System.out.println("After Step #2 w = " + prog1.printArray(w));
        
        prog1.getMaximumThread(x, w);
    }

    private int[] wIntArray(int arglength) {
        int[] w;
        w = new int[arglength - 1];
        Thread[] threads = new Thread[w.length];

        for (int i = 0; i < w.length; i++) {
            threads[i] = new Thread(new wThread(w, i));
        }

        for (int i = 0; i < w.length; i++) {
            threads[i].start();

        }

        return w;
    }

    private int[] readInArgs(String[] args) {
        int[] argNums = new int[args.length - 1];

        for (int i = 0; i < argNums.length; i++) {
            argNums[i] = Integer.parseInt(args[i + 1]);

        }
        return argNums;
    }

    public AdrianThreads() {
    }

    private String printArray(int[] array) {
        String argsValues = "";
        for (int i = 0; i < array.length; i++) {
            argsValues += array[i] + " ";

        }
        return argsValues;
    }

    private void compareThreads(int[] x, int[] w) {
        int n = (x.length * (x.length - 1)) / 2;
        int countThreads = 0;
        CompareThread[] threads = new CompareThread[n];

        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                threads[countThreads] = new CompareThread(x, w, i, j);
                countThreads++;
            }

        }
        for (CompareThread t : threads) {
            t.start();
        }

    }

    private void getMaximumThread(int[] x, int[] w) {
        MaxThread[] threads = new MaxThread[x.length];

        for (int i = 0; i < x.length; i++) {
            threads[i] = new MaxThread(x, w, i);

        }

        for (MaxThread t : threads) {
            t.start();
        }
        
    }

}
