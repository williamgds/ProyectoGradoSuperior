/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.segundotrimestre;

/**
 *
 * @author Guillermo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado miEmpleado = new Empleado();
        
        // Método de inicialización
        miEmpleado.init();
        // Método que imprime nombre
        miEmpleado.nombreEmpleado();
        // Método que imprime apellido
        miEmpleado.apellidoEmpleado();
        // Método que imprime si debe pagar impuestos
        miEmpleado.pagaImpuestos();
        // Método que imprime el código del empleado
        miEmpleado.mostrarCodigoEmpleado();
        // Método que imprime el género del empleado
        miEmpleado.mostrarGeneroEmpleado();
        // Método que imprime el sueldo del empleado, dándonos a elegir entre el anual o el mensual
        miEmpleado.mostrarSalarioEmpleado();
        // Destrucción del objeto para liberar memoria
        miEmpleado = null;
    }
    
}
