import java.util.Date;

public class EjemploAutomovilRelacionesObjetos {
    public static void main(String[] args) {

        Persona conductorSubaru = new Persona("Lucy", "Martinez");
        Automovil subaru = new Automovil("subaru","Impresa");
        subaru.setColor(Color.AZUL);
        subaru.setMotor(new Motor(2.0, TipoMotor.DIESEL));
        subaru.setTipo(TipoAutomovil.PICKUP);
        subaru.setConductor(conductorSubaru);
//        subaru.setRuedas(ruedasSub);
        Rueda[] ruedasSub = new Rueda[5];
        for (int i = 0; i < ruedasSub.length; i++) {
            subaru.addRueda(new Rueda("Yokohama", 16, 7.5));
        }


        Persona pato = new Persona("Pato", "Rodriguez");
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setConductor(pato);
//        mazda.setRuedas(ruedasMazda);
        Rueda[] ruedasMazda = new Rueda[5];
        for (int i = 0; i < ruedasMazda.length; i++) {
            mazda.addRueda(new Rueda("Michelin", 18, 10.5));
        }


        Persona bea = new Persona("Bea", "Gonzales");
        Automovil nissan = new Automovil("Nissan", "Altima", Color.AMARILLO, new Motor(3.0, TipoMotor.DIESEL));
        nissan.setTipo(TipoAutomovil.SEDAN);
        nissan.setConductor(bea);
//        nissan.setRuedas(ruedasNissan);
        Rueda[] ruedasNissan = new Rueda[5];
        for (int i = 0; i < ruedasNissan.length; i++) {
            nissan.addRueda(new Rueda("Pirelli", 20, 11.5));
        }


        Persona lalo = new Persona("Lalo", "Mena");
        Automovil nissan2 = new Automovil("Nissan", "Altima", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL));;
        nissan2.setTipo(TipoAutomovil.SEDAN);
        nissan2.setConductor(lalo);
//        nissan2.setRuedas(ruedasNissan2);
        Rueda[] ruedasNissan2 = new Rueda[5];
        nissan2.addRueda(new Rueda("Pirelli", 20, 11.5))
                .addRueda(new Rueda("Pirelli", 20, 11.5))
                .addRueda(new Rueda("Pirelli", 20, 11.5))
                .addRueda(new Rueda("Pirelli", 20, 11.5))
                .addRueda(new Rueda("Pirelli", 20, 11.5));



        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());

//        System.out.println("Conductor del autoMovil: " + this.getConductor());
//        for(Rueda r : subaru.getRuedas()){
//            System.out.println(r.getFabricante() + ", aro: " + r.getAro() + ", anocho: " + r.getAncho());
//        }

    }
}
