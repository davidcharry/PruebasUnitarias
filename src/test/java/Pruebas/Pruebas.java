package Pruebas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import Calculadora.GeneradorNumeros;
import Calculadora.Operaciones;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Pruebas {

    @InjectMocks
    Operaciones operaciones;

    @Mock
    GeneradorNumeros generador = new GeneradorNumeros();

    public Pruebas() {
        this.operaciones = new Operaciones();
    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Metodo unico antes de la clase.");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Metodo unico al finalizar la clase.");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Inicio de metodo.");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Fin del metodo.");
    }

    @Test
    public void sumPru() {
        int num1 = 5;
        int num2 = 6;
        assertEquals(11, operaciones.sumar(num1, num2));
    }

    @Test
    public void resPru() {
        int num1 = 5;
        int num2 = 3;
        assertEquals(2, operaciones.Resta(num1, num2));
    }

    @Test
    public void mulPru() {
        int num1 = 5;
        int num2 = 4;
        assertEquals(20, operaciones.Multiplicar(num1, num2));
    }

    @Test
    public void divPru() {
        int num1 = 10;
        int num2 = 0;
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            this.operaciones.Dividir(num1, num2);
        });
        System.out.println("Exception test: " + exception.getMessage());
    }

    @Test
    public void pruebaDiv() {
        int num1 = 10;
        int num2 = 2;
        assertEquals(5, operaciones.Dividir(num1, num2), 0.000000001);
    }

    @Test
    public void pruebaPromedioNumVacios() {
        System.out.println("Promedio Numeros vacios");
        Mockito.when(this.generador.getListaNumeros()).thenReturn(new long[]{});
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            this.operaciones.promedio(this.generador.getListaNumeros());
        });
        System.out.println("Exception test: " + exception.getMessage());
    }

    @Test
    public void pruebaPromedioNumeros() {
        System.out.println("Promedio con numeros");
        Mockito.when(this.generador.getListaNumeros()).thenReturn(new long[]{1, 2, 3, 4, 5});
        assertEquals(3, this.operaciones.promedio(this.generador.getListaNumeros()), "Mensaje");
    }

    @Test
    public void pruebaSumarNumeros() {
        System.out.println("Sumar lista de numeros");
        long[] listaNumeros = new long[]{1, 2, 3, 4, 5};
        assertEquals(15, this.operaciones.Sumar(listaNumeros));
    }
}
