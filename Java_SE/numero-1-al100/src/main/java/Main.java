public class Main {
    public static void main(String[] args) {
        int limite = 100;
        int i = 0;
        int[] numeros = new int[100];
        while(i < limite){
            numeros[i] = i ;
            i++;
        }
        for(int j = 0; j < numeros.length; j++){
            System.out.println("El numero en la posicion " +  (j + 1) + " es igual a " + numeros[j]);
        }
    }
}
