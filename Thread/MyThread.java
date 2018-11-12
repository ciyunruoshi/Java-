package Java_Design_Moduls7;

public class MyThread extends Thread {

    public MyThread(){

        System.out.println("------" + "构造函数开始" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("------" + "构造函数结束" + "------");

    }

    @Override
    public void run(){

        Thread testThread = Thread.currentThread();

        System.out.println("------" + "run()开始" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("Thread.currentThread() == this : " + (Thread.currentThread() == this));
        System.out.println("------" + "run()结束" + "------");

    }



}