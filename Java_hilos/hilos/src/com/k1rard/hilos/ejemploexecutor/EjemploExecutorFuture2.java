package com.k1rard.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamano del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre del Thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea");
            return "Algun resultado importante de la tarea";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };
        Future<String> resultadoFuturo = executor.submit(tarea);
        Future<String> resultadoFuturo2 = executor.submit(tarea);
        Future<Integer> resultadoFuturo3 = executor.submit(tarea2);
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");

        //System.out.println(resultadoFuturo.isDone());
        while (!(resultadoFuturo.isDone() && resultadoFuturo2.isDone() && resultadoFuturo3.isDone())){
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultadoFuturo.isDone()? "finalizo" : "en proceso",
                    resultadoFuturo2.isDone()? "finalizo" : "en proceso",
                    resultadoFuturo3.isDone()? "finalizo" : "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("Obtenemos el resultado1 de la tarea: " + resultadoFuturo.get());
        System.out.println("Finaliza la tarea: " + resultadoFuturo.isDone());
        System.out.println("Obtenemos el resultado2 de la tarea: " + resultadoFuturo2.get());
        System.out.println("Finaliza la tarea: " + resultadoFuturo2.isDone());
        System.out.println("Obtenemos el resultado3 de la tarea: " + resultadoFuturo3.get());
        System.out.println("Finaliza la tarea: " + resultadoFuturo3.isDone());

    }
}
