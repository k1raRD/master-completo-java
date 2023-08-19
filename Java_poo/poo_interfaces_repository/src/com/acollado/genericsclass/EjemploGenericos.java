package com.acollado.genericsclass;

public class EjemploGenericos {

    public static <T> void imprimirCamion(Camion<T> camion){
        for(T a: camion){
            if (a instanceof Animal) {
                System.out.println(((Animal)a).getNombre() + " tipo: " + ((Animal)a).getTipo());
            }else if(a instanceof Automovil){
                System.out.println(((Automovil)a).getMarca());
            } else if (a instanceof  Maquinaria) {
                System.out.println(((Maquinaria)a).getTipo());
            }
        }
    }
    public static void main(String[] args) {
        Camion<Animal> transporteCaballos = new Camion<Animal>(5);
        transporteCaballos.add(new Animal("peregrino", "Caballo"));
        transporteCaballos.add(new Animal("grillo","Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotona", "Caballo"));

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transMaquinas = new Camion(3);
        transMaquinas.add(new Maquinaria("Buldozer"));
        transMaquinas.add(new Maquinaria("Grua Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinas);

        Camion<Automovil> transAutos = new Camion(3);
        transAutos.add(new Automovil("Toyota"));
        transAutos.add(new Automovil("Mitsubishi"));
        transAutos.add(new Automovil("Chevrolet"));

        imprimirCamion(transAutos);
    }
}
