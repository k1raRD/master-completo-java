import java.util.Date;

public class EjemploAutomovilEnum {
    public static void main(String[] args) {
        Automovil subaru = new Automovil("subaru","Impresa");
        subaru.setColor(Color.AZUL);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(2.0, TipoMotor.BENCINA));
        mazda.setTipo(TipoAutomovil.PICKUP);
        subaru.setTipo(TipoAutomovil.PICKUP);

        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());

        switch (tipoSubaru){
            case CONVERTIBLE -> {
                System.out.println("El automovil es deportivo y descapotable de dos puertas");
            }
            case COUPE -> {
                System.out.println("Es un automovil pequeno de dos puertas y tipicamente deportivo.");
            }
            case FURGON -> {
                System.out.println("Es un automovil utilitario de transporte, de empresas");
            }
            case HATCHBACK -> {
                System.out.println("Es un automovil mediano compacto, aspecto mediano");
            }
            case PICKUP -> {
                System.out.println("Es un automovil de doble cabina y camioneta");
            }
            case SEDAN -> {
                System.out.println("Es un automovil mediano");
            }
            case STATION_WAGON -> {
                System.out.println("Es un automovil mas grande, con maleta grande...");
            }
        }

        TipoAutomovil[] tipos = TipoAutomovil.values();
        for(TipoAutomovil tipo: tipos){
            System.out.println(tipo + " => " + tipo.name() + ", " +
                                tipo.getNombre() + ", " +
                                tipo.getDescripcion() +", " +
                                tipo.getNumeroPuerta());
        }
    }
}
