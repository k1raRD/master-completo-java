public class ArgumentoLineaComandoCalculadora {
    public static void main(String[] args) {

        if (args.length != 3){
            System.out.println("Por favor ingresar una operacion" +
                    "(sum, res, div, mul) y dos numeros");
            System.exit(-1);
        }
        String operacion = args[0];
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        double resultado = 0.00;

        switch (operacion) {
            case "sum":
                resultado = a + b;
                break;
            case "res":
                resultado = a - b;
                break;
            case "div":
                if (b == 0 ){
                    System.exit(-1);
                    System.out.println("Nos se puede dividir por cero");
                }
                resultado = a / b;
                break;
            case "mul":
                resultado = a * b;
                break;
            default:
                resultado= a + b;
                break;
        }
        System.out.println("Resultado de la operacion " + operacion + " es: " + resultado);
    }
}
