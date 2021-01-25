package leetcode;

import java.util.Scanner;

/**
 *
 * Link :- https://leetcode.com/problems/print-foobar-alternately/
 *
 */

public class Q1115 {

    public static void main(String[] args){
        FooBar fooBar = new FooBar(5);

        Thread f = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread s = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        s.start();
        f.start();
    }



    static class FooBar {
        private int n;
        private int counter=0;
        private final Object objectLock = new Object();

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                synchronized (objectLock) {
                    if (counter % 2 != 0) {
                        objectLock.wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    counter++;
                    printFoo.run();
                    objectLock.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                synchronized (objectLock) {
                    if (counter % 2 == 0) {
                        objectLock.wait();
                    }
                    counter++;
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    objectLock.notifyAll();
                }

            }
        }
    }

}
