/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculadora;

public class Operaciones {

    public long sumar(long n1, long n2) {
        return n1 + n2;
    }
    
    public long Sumar(long[] listaNumeros){
        long resultado = 0;
        for (long num : listaNumeros) {
            resultado+=num;
        }
        return resultado;
    }

    public long Resta(long n1, long n2) {
        return n1 - n2;
    }

    public long Multiplicar(long n1, long n2) {
        return n1 * n2;
    }
    
    public long Multiplicar(long... listaNumeros) {
        long resultado = 1;
        for(long num : listaNumeros){
            resultado*= num;
        }
        return resultado;
    }
    
    public float Dividir(long n1, long n2) {
        try {
            return n1 / n2;
        } catch(ArithmeticException e){
            throw e;
        }
    }
    
    public float division(long n1, long n2) throws ArithmeticException{
        return n1 / n2;
    }
    
    public double promedio(long[] numeros){
        double promedio;
        long sumatoria = 0;
        for(long numero : numeros){
            sumatoria += numero;
        }
        promedio = this.Dividir(sumatoria, numeros.length);
        return promedio;
    }

}
