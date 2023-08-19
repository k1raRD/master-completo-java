package com.k1rard.junitapp.ejemplos.model;

import com.k1rard.junitapp.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class CuentaTest {

    Cuenta cuenta;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
     void initMetodoTest(TestInfo testInfo, TestReporter testReporter){
        System.out.println("Iniciamos el método.");
        this.cuenta = new Cuenta("Alex", new BigDecimal("1000.12345"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Ejecutando: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod().orElse(null).getName()
                + " con las etiquetas: " + testInfo.getTags());
    }

    @AfterEach
    void afterEach() {
        System.out.println("Finalizando el método de prueba");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test");
    }

    @Tag("Cuenta")
    @Nested
    @DisplayName("Probando atributos de la cuenta corriente")
    class CuentaNombreSaldoTest{

        @Test
        @DisplayName("El nombre")
        void testNombreCuenta() {
//        cuenta.setPersona("Alex");
            testReporter.publishEntry(testInfo.getTags().toString());
            if(testInfo.getTags().contains("cuenta")){
                System.out.println("Hacer algo con la etiqueta cuenta");
            }
            String esperado = "Alex";
            String actual = cuenta.getPersona();
            assertNotNull(actual, () -> "La cuenta no puede ser nula");
            assertEquals(esperado, actual,() -> "El nombre de la cuenta no es el que se esperaba");
            assertTrue(actual.equals("Alex"),() ->"Nombre de cuenta debe ser igual al actual");
        }

        @Test
        @DisplayName("El saldo que no sea null. mayor que cero, valor esperado")
        void testSaldoCuenta() {
            cuenta = new Cuenta("Alex", new BigDecimal("1000.12345"));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        @DisplayName("Probando las referencias que sean iguales con el metodo equals")
        void testReferenciaCuenta() {
            Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

//        assertNotEquals(cuenta, cuenta2);
            assertEquals(cuenta, cuenta2);
        }

   }

   class CuentaOperacionesTest{
       @Tag("Cuenta")
       @Test
       @DisplayName("Probando el retiro de las cuentas")
       void testDebitoCuenta() {
           cuenta = new Cuenta("Mario", new BigDecimal("1000.12345"));
           cuenta.debito(new BigDecimal(100));
           assertNotNull(cuenta.getSaldo());
           assertEquals(900, cuenta.getSaldo().intValue());
           assertEquals("900.12345", cuenta.getSaldo().toPlainString());
       }

       @Tag("Cuenta")
       @Test
       @DisplayName("Probando el recibir dinero mediante una transferencia")
       void testCreditoCuenta() {
           cuenta = new Cuenta("Mario", new BigDecimal("1000.12345"));
           cuenta.credito(new BigDecimal(100));
           assertNotNull(cuenta.getSaldo());
           assertEquals(1100, cuenta.getSaldo().intValue());
           assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
       }


       @Tag("Cuenta")
       @Tag("Banco")
       @Test
       @DisplayName("Probando las transferencias de un monto entre las cuentas")
       void testTransferirDineroCuentas() {
           Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("2500"));
           Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));
           Banco banco = new Banco();
           banco.setNombre("Banco del estado");
           banco.transferir(cuenta2, cuenta, new BigDecimal(500));
           assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
           assertEquals("3000", cuenta.getSaldo().toPlainString());

       }

       @Test
       @DisplayName("Probando relaciones entre las cuentas y el banco con assertAll")
//    @Disabled
       void testRelacionBancoCuentas() {
//        fail();
           Cuenta cuenta = new Cuenta("Jhon Doe", new BigDecimal("2500"));
           Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

           Banco banco = new Banco();
           banco.addCuenta(cuenta);
           banco.addCuenta(cuenta2);
           banco.setNombre("Banco del Estado");
           banco.transferir(cuenta2, cuenta, new BigDecimal(500));
           assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(), () -> "El valor del saldo de la cuenta2 no es el esperado"),
                   () -> assertEquals("3000", cuenta.getSaldo().toPlainString(), () -> "El valor del saldo de la cuenta no es el esperado"),
                   () -> assertEquals(2, banco.getCuentas().size(), () -> "El banco no tiene las cuentas esperadas"),
                   () -> assertEquals("Banco del Estado", cuenta.getBanco().getNombre()),
                   () -> assertEquals("Andres", banco.getCuentas().stream()
                           .filter(c -> c.getPersona().equals("Andres"))
                           .findFirst()
                           .get().getPersona()),
                   () -> assertTrue(banco.getCuentas().stream().anyMatch(c -> c.getPersona().equals("Andres")))
           );

       }
   }

   @Nested
   class ExcepcionesTest{
       @Tag("Cuenta")
       @Tag("Error")
       @Test
       @DisplayName("Probando cuando no dinero suficiente en una cuenta")
       void testDineroInsuficienteException() {
           Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12344"));
           Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
               cuenta.debito(new BigDecimal("1100.12345"));
           });
           String actual = exception.getMessage();
           String esperado = "Dinero insuficiente";
           assertEquals(esperado, actual);
       }
   }


    @Nested
    class SistemaOperativoTest {

        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSlowWindow(){

        }
        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
        void testSoloLinuxMac(){

        }
        @Test
        @DisabledOnOs(OS.WINDOWS)
        void testNoWindows(){

        }
    }

@Nested
    class JavaVersionTest {
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void testSoloJDK8(){

        }

        @Test
        @EnabledOnJre(JRE.JAVA_17)
        void testSoloJDK17(){

        }

        @Test
        @DisabledOnJre(JRE.JAVA_17)
        void testNoJDK17(){

        }
    }

    @Nested
class SystemPropertyTest {
    @Test
    void testImprimirSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = "17")
    void testJavaVersion(){

    }

    @Test
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testSolo64() {
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testNo64() {
    }

    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "k1rard")
    void testUsername(){

    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void testDev() {
    }

}

@Nested
class VariableAmbienteTest {
    @Test
    void impirmirVaribalesAmbiente() {
        Map<String, String> getenv = System.getenv();
        getenv.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-17.*")
    void testJavaHome() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "4")
    void testProcesadores() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
    void testEnv() {
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
    void testEnvProdDisabled() {
    }

}

    @Test
//    @DisplayName("Probando el saldo de la cuenta corriente, que no sea null. mayor que cero, valor esperado")
    void testSaldoCuentaDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        cuenta = new Cuenta("Alex", new BigDecimal("1000.12345"));
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
//    @DisplayName("Test saldo cuenta DEV 2")
    void testSaldoCuentaDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        cuenta = new Cuenta("Alex", new BigDecimal("1000.12345"));
        assumingThat(esDev, () -> {
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        });
    }

    @RepeatedTest(value = 5, name = " {displayName} - Repeticion numero {currentRepetition} de {totalRepetitions}")
    @DisplayName("Probando Debito Cuenta Repetido")
    void testDebitoCuentaRepetir(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 3) {
            System.out.println("Estamos en la repeticion: " + info.getCurrentRepetition());
        }
        cuenta = new Cuenta("Mario", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Tag("param")
    @Nested
    class PruebasParametrizadasTest{
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
        void testDebitoCuentaValueSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000"})
        void testDebitoCuentaCsvSource(String index, String monto) {
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200,100,John,Andres", "250,200,Pepe,Pepe", "310,300,maria,Maria", "510,500,Pepa,Pepa", "750,700,Lucas,Lucas", "1100,1000,Cata,Cata"})
        void testDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual) {
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);
            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCsvFileSource(String monto) {
            System.out.println(" -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv")
        void testDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual) {
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);
            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

    }

    @Tag("param")
    @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("montoList")
    void testDebitoCuentaMethodSource(String monto) {
        System.out.println(" -> " + monto);
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> montoList(){
        return Arrays.asList("100", "200", "300", "500", "700", "1000");
    }

    @Nested
    @Tag("timeout")
    class EjemploTimeoutTest {
        @Test
        @Timeout(1)
        void pruebaTimeout() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
        void pruebaTimeout2() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(900);
        }

        @Test
        void testTimeoutAssertions() {
            assertTimeout(Duration.ofSeconds(5), () -> {
                TimeUnit.MILLISECONDS.sleep(4000);
            });
        }
    }

}