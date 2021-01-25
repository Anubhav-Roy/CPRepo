package leetcode;

import java.util.Scanner;

/**
 *
 * Link :- https://leetcode.com/problems/building-h2o/
 *
 */

public class Q1117 {

    public static void main(String[] args) throws InterruptedException {
        H2O h20 = new H2O();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.oxygen(new CustomRunnable("0"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.oxygen(new CustomRunnable("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread a1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.oxygen(new CustomRunnable("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.hydrogen(new CustomRunnable("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.hydrogen(new CustomRunnable("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.hydrogen(new CustomRunnable("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.hydrogen(new CustomRunnable("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.hydrogen(new CustomRunnable("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t7 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    h20.hydrogen(new CustomRunnable("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t.start();
        t1.start();
        a1.start();



    }

    static class H2O {

        private final Object objectLock = new Object();
        private int hAtoms =0;
        private int oAtoms =0;

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            synchronized (objectLock){
                while (hAtoms==2){
                    objectLock.wait();
                }

                // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                releaseHydrogen.run();

                objectLock.notifyAll();

                hAtoms+= 1;

                checkForReset();
            }

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            synchronized (objectLock){
                while (oAtoms==1){
                    objectLock.wait();
                }

                oAtoms=1;
                // releaseOxygen.run() outputs "O". Do not change or remove this line.
                releaseOxygen.run();

                objectLock.notifyAll();

                checkForReset();
            }
        }

        public void checkForReset(){
            synchronized (objectLock){
                if(hAtoms==2 && oAtoms==1){
                    hAtoms=0;
                    oAtoms=0;
                }

                objectLock.notifyAll();
            }
        }
    }

    static class CustomRunnable implements Runnable {

        private String message ;
        CustomRunnable(String message){
            this.message= message;
        }

        @Override
        public void run() {
            System.out.println(message);
        }
    }

}
