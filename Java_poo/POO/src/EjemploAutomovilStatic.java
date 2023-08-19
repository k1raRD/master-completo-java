import java.util.Date;

public class EjemploAutomovilStatic {
    public static void main(String[] args) {
        Automovil auto = new Automovil("subaru","Impresa");
        Date fecha = new Date();

        Automovil.setCapacidadEstanqueEstatico(45);

        auto.setColor(Color.AZUL);
        auto.setMotor(new Motor(2.0, TipoMotor.DIESEL));
        System.out.println(Automovil.VELOCIDAD_MAX_CARRETERA);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        Automovil nissan = new Automovil("Nissan", "Altima", Color.AMARILLO, new Motor(3.0, TipoMotor.DIESEL));
        Automovil nissan2 = new Automovil("Nissan", "Altima", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL));
        Automovil autoNull = new Automovil();
        Automovil.setColorPatente(Color.NARANJA);
        nissan2.setTipo(TipoAutomovil.SEDAN);
        mazda.setTipo(TipoAutomovil.PICKUP);
        nissan.setTipo(TipoAutomovil.SEDAN);
        auto.setTipo(TipoAutomovil.PICKUP);

        System.out.println(auto.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println("Kilometros por litros = " + Automovil.calcularConsumo(300, 60));

    }
}
