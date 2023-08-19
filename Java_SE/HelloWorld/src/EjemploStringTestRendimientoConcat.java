public class EjemploStringTestRendimientoConcat {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";

        StringBuilder sb = new StringBuilder("a");
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
//            c = c.concat(a).concat(b).concat("\n"); // 500 => 0ms, 1000 => 16ms, 10000 => 241
//            c +=  a + b + "\n"; // 500 => 31ms, 1000 => 32ms, 10000 => 109
//            sb.append(a).append(b).append("\n"); // 500 => 0ms, 1000 => 0, 10000 => 0
        }

        System.gc();

        long fin = System.currentTimeMillis();
        System.out.println(fin - inicio);
        System.out.println("c = " + c);
        System.out.println("sb = " + sb.toString());

        System.exit(0);
    }
}
