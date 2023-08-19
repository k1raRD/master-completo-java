public class EjemploString {
    public static void main(String[] args) {
        String curso = "Programacion Java";
        String curso2 = new String("programacion Java");
        boolean isEqual = curso == curso2;
        System.out.println("curso == curso2 = " + isEqual);
        boolean isEqual2 = curso.equals(curso2);
        System.out.println("curso.equals(curso2) = " + isEqual2);
        
        String curso3 = "Programacion Java";
        isEqual2 = curso == curso3;
        System.out.println("curso == curso3 = " + isEqual2);
    }
}
