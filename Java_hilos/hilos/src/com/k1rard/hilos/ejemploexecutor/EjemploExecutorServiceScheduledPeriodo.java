package com.k1rard.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploExecutorServiceScheduledPeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main");

        AtomicInteger contador = new AtomicInteger(5);
        //CountDownLatch lock = new CountDownLatch(5);
        Future<?> futuro = executor.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola mundo tarea...");
        }, 1000, 2000,TimeUnit.MILLISECONDS);

        //lock.await();
        //futuro.cancel(true);
        //TimeUnit.SECONDS.sleep(10);
        while (contador.get() >= 0){
            if(contador.get() == 0){
                futuro.cancel(true);
                contador.getAndDecrement();
            }
        }
        System.out.println("Alguna otra tarea");
        executor.shutdown();
    }
}
