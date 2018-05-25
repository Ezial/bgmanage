package com.ezial.bgmanage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Ezial on 2018/3/21.
 */
public class VolatileTest {


    public static void main(String[] args) {
        try {
            isThreadSafe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * volatile 是否能保证线程安全
     */
    public static volatile int num = 0;

    public static void isThreadSafe() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(4000);
        List<MyCallable> list = new ArrayList<MyCallable>();

        for(int i = 0;i<10000;i++){
            list.add(new MyCallable());
        }

        List<Future<Integer>> futures = service.invokeAll(list);

        System.out.println(num);

        service.shutdown();

    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1);
            return num++;
        }
    }

}
