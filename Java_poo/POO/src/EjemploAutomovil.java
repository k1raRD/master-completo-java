import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil subaru = new Automovil("subaru","Impresa");
        Date fecha = new Date();

        Motor motorSubaru = new Motor(2.0, TipoMotor.BENCINA);

        subaru.setColor(Color.BLANCO);
        subaru.setEstanque(new Estanque());
        subaru.setMotor(motorSubaru);

        Motor motorMazda = new Motor(3.0, TipoMotor.DIESEL);
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, motorMazda);
        mazda.setEstanque(new Estanque(45));

        Motor motorNissan = new Motor(4.0, TipoMotor.DIESEL);

        Automovil nissan = new Automovil("Nissan", "Altima", Color.AMARILLO, motorNissan);
        Automovil nissan2 = new Automovil("Nissan", "Altima", Color.AZUL, motorNissan);

        Automovil autoNull = new Automovil();

        System.out.println(nissan == nissan2);
        System.out.println(nissan.equals(fecha));

        System.out.println(nissan);
        System.out.println(nissan.toString());

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(subaru.acelerar(3000));
        System.out.println(subaru.frenar());
        autoNull.equals(nissan2);

        System.out.println(mazda.acelerarFrenar(4000));
        System.out.println("Kilometros por litro " + subaru.calcularConsumo(300, 0.6f));
        System.out.println("Kilometros por litro " + subaru.calcularConsumo(300, 60));
    }
}
