package com.k1rard.hilos.ejemploexecutor;

import com.k1rard.hilos.ejemplosync.Panaderia;
import com.k1rard.hilos.ejemplosync.runnable.Consumidor;
import com.k1rard.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamano del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> resultadoFuturo = executor.submit(productor);
        Future<?> resultadoFuturo2 = executor.submit(consumidor);

        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");
    }
}
