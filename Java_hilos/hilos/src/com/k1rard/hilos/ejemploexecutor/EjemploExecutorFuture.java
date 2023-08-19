package com.k1rard.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

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
        Future<String> resultadoFuturo = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");

        //System.out.println(resultadoFuturo.isDone());
        while (!resultadoFuturo.isDone()){
            System.out.println("Ejecutando tarea....");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println("Obtenemos el resultado de la tarea: " + resultadoFuturo.get());
        System.out.println("Finaliza la tarea: " + resultadoFuturo.isDone());

    }
}
