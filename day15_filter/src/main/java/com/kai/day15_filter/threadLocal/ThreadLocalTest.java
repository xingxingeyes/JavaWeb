package com.kai.day15_filter.threadLocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/25
 **/
public class ThreadLocalTest {
    // public static Map<String, Object> data = new ConcurrentHashMap<String, Object>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
    private static Random random = new Random();

    public static class Task implements Runnable {
        @Override
        public void run() {
            // 在run方法中，随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            int i = random.nextInt(1000);
            // 获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程【" + name + "】生成的随机数是：" + i);
            // data.put(name, i);
            threadLocal.set(i);

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            new OrderService().createOrder();
            new OrderDao().saveOrder();

            // run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
            // Object o = data.get(name);
            Object o = threadLocal.get();

            System.out.println("在线程【" + name + "】快结束是取出关联的数据是：" + o);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();;
        }
    }
    

}
