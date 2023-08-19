class Persona {
    private String nombre;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
public class PasarPorReferencia2 {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("Andres");

        System.out.println("Iniciamos el main");
        System.out.println("persona = " + persona.getNombre());
        System.out.println("Antes de invocar al metodo test");
        test(persona);
        System.out.println("Despues de invocar al metodo test");
        System.out.println("persona = " + persona.getNombre());
        System.out.println("Finaliza el metodo main con los datos del array modificados");
    }

    public static void test(Persona persona){
        System.out.println("iniciamos el metodo test con");
        persona.setNombre("Maria");
        System.out.println("Finaliza el metodo test");
    }
}
