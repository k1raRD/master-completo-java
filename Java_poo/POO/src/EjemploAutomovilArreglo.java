import java.util.Arrays;

public class EjemploAutomovilArreglo {
    public static void main(String[] args) {

        Persona conductorSubaru = new Persona("Lucy", "Martinez");
        Automovil subaru = new Automovil("subaru","Impresa");
        subaru.setColor(Color.AZUL);
        subaru.setMotor(new Motor(2.0, TipoMotor.DIESEL));
        subaru.setTipo(TipoAutomovil.PICKUP);
        subaru.setConductor(conductorSubaru);


        Persona pato = new Persona("Pato", "Rodriguez");
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setConductor(pato);


        Persona bea = new Persona("Bea", "Gonzales");
        Automovil nissan = new Automovil("Nissan", "Altima", Color.AMARILLO, new Motor(3.0, TipoMotor.DIESEL));
        nissan.setTipo(TipoAutomovil.SEDAN);
        nissan.setConductor(bea);


        Persona lalo = new Persona("Lalo", "Mena");
        Automovil suzuki = new Automovil("Suzuki", "Vitara", Color.BLANCO, new Motor(4.0, TipoMotor.DIESEL));;
        suzuki.setTipo(TipoAutomovil.SUV);
        suzuki.setConductor(lalo);

        Automovil audi = new Automovil("Audi", "A3");
        audi.setConductor(new Persona("Jano", "Perez"));

        Automovil[] autos = new Automovil[5];
        autos[0] = subaru;
        autos[1] = mazda;
        autos[2] = nissan;
        autos[3] = suzuki;
        autos[4] = audi;

        Arrays.sort(autos);
        for (Automovil auto : autos) {
            System.out.println(auto);
        }

    }
}
