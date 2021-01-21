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
            foo.first(new Runnable() {
                @Override
                public void run() {
                    System.out.println("First");
                }
            });

            foo.second(new Runnable() {
                @Override
                public void run() {
                    System.out.println("second");
                }
            });

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

    static class Foo {

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
