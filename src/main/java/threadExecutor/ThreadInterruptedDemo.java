package threadExecutor;

/**
 * @author wh
 * @date 2020/5/25
 * Description:Thread中interrupted()方法和isInterrupted()方法区别总结
 */
public class ThreadInterruptedDemo extends Thread {
    public static void main(String[] args) {
        ThreadInterruptedDemo myThread = new ThreadInterruptedDemo();
        myThread.start();
        myThread.interrupt();
        //interrupted()是静态方法：内部实现是调用的当前线程的isInterrupted()，并且会重置当前线程的中断状态(从中断状态重置为非中断状态)
        //isInterrupted()是实例方法，是调用该方法的对象所表示的那个线程的isInterrupted()，不会重置当前线程的中断状态

//        System.out.println("第一次调用："+Thread.interrupted());//false
//        System.out.println("第二次调用："+Thread.interrupted());//false

//        Thread.currentThread().interrupt();
//        System.out.println("第一次调用："+Thread.interrupted());//true
//        System.out.println("第二次调用："+Thread.interrupted());//false

//        System.out.println("第一次调用："+myThread.isInterrupted());//true
//        System.out.println("第二次调用："+myThread.isInterrupted());//false

//        System.out.println("第一次调用："+Thread.currentThread().isInterrupted());//false
//        System.out.println("第二次调用："+Thread.currentThread().isInterrupted());//false

        Thread.currentThread().interrupt();
        System.out.println("第一次调用：" + Thread.currentThread().isInterrupted());//true
        System.out.println("第二次调用：" + Thread.currentThread().isInterrupted());//true

    }
}
