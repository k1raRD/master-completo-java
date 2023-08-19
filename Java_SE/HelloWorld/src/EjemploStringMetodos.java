public class EjemploStringMetodos {
    public static void main(String[] args) {
        String nombre = "Alexander Collado Jimenez";
        System.out.println("nombre.length() = " + nombre.length());
        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.equals(\"Alexander\") = " + nombre.equals("Alexander"));
        System.out.println("nombre.equals(\"alex\") = " + nombre.equals("alexander"));
        System.out.println("nombre.equalsIgnoreCase(\"alexander\") = " + nombre.equalsIgnoreCase("alexander"));
        System.out.println("nombre.compareTo(\"Alexander\") = " + nombre.compareTo("Alexander"));
        System.out.println("nombre.compareTo(\"Alexander\") = " + nombre.compareTo("Alexander"));
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(0) = " + nombre.charAt(3));
        System.out.println("nombre.charAt(0) = " + nombre.charAt(nombre.length() - 1));
        System.out.println("nombre.substring(0, 9) = " + nombre.substring(9));
        System.out.println("nombre.substring(0, 9) = " + nombre.substring(0, 9));
        System.out.println("nombre.substring(0, 9) = " + nombre.substring(0, 4));

        String trabaLenguas = "trabalenguas";
        System.out.println("trabaLenguas = " + trabaLenguas.replace('a', 'x'));
        System.out.println("trabaLenguas = " + trabaLenguas);
        System.out.println("trabaLenguas.indexOf(\"a\") = " + trabaLenguas.indexOf("a"));
        System.out.println("trabaLenguas.lastIndexOf(\"a\") = " + trabaLenguas.lastIndexOf("a"));
        System.out.println("trabaLenguas.lastIndexOf(\"z\") = " + trabaLenguas.lastIndexOf("l"));
        System.out.println("trabaLenguas.indexOf(\"a\") = " + trabaLenguas.indexOf("lenguas"));
        System.out.println("trabaLenguas.contains(\"lengua\") = " + trabaLenguas.contains("lenguas"));
        System.out.println("trabaLenguas.startsWith(\"traba\") = " + trabaLenguas.startsWith("traba"));
        System.out.println("trabaLenguas.endsWith(\"lenguas\") = " + trabaLenguas.endsWith("lenguas"));
        System.out.println("   trabalenguas   ");
        System.out.println("  trabalenguas  ".trim());
    }
}
