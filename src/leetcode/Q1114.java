package leetcode;

import java.util.Scanner;

/**
 *
 * Link :- https://leetcode.com/problems/print-in-order/
 *
 */

public class Q1114 {

    public static void main(String[] args){
        Foo foo = new Foo();

        try {

            Thread s = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        foo.second(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("second");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });


            Thread f = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        foo.first(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("First");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });



            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        foo.third(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("third");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });




            t.start();

            s.start();

            f.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Foo {

        private final Object objectLock = new Object();
        private int counter=0;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            System.out.println("F");
            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (objectLock) {
                printFirst.run();
                counter=1;
                objectLock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            System.out.println("S");

            // printSecond.run() outputs "second". Do not change or remove this line.
            synchronized (objectLock) {
                while(counter!=1) {
                    objectLock.wait();
                }

                printSecond.run();
                counter=2;
                objectLock.notifyAll();
            }

        }

        public void third(Runnable printThird) throws InterruptedException {
            System.out.println("T");

            // printThird.run() outputs "third". Do not change or remove this line.

            synchronized (objectLock) {

                while(counter!=2) {
                        objectLock.wait();
                }

                printThird.run();
                objectLock.notifyAll();
            }
        }
    }
}
