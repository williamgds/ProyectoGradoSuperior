package com.mycompany.segundotrimestre;
import java.util.Scanner;

/**
 *
 * @author Guillermo
 */
public class Empleado {
    // Declaración de variables
    
    private Scanner teclado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String generoEmpleado;
    private String codEmpleado;
    private int edadEmpleado;
    private double sueldoEmpleado;
    private int numPagas;
    private double sueldoMensualEmpleado;
    // Constante del sueldo mínimo mensual para pagar impuestos
    private final int SUELDO_IMPUESTOS = 3000;
    
    // Inicialización de la clase
    public void init(){
    teclado = new Scanner(System.in);
    System.out.println("Introduzca el nombre del empleado o empleada: ");
    nombreEmpleado = teclado.nextLine();
    
    if(nombreEmpleado.isEmpty()){
        System.out.println("El nombre del empleado/a no puede estar vacío.");
        init();
    }
    // Inicializamos el apellido del empleado para evitar NullPointerException
    apellidoEmpleado = "";
    while(apellidoEmpleado.isEmpty()){
    
        System.out.println("Introduzca el apellido del empleado o empleada: ");
        apellidoEmpleado = teclado.nextLine();
            if(apellidoEmpleado.isEmpty()){
                System.out.println("El apellido del empleado no puede estar vacío.");
                }
    }
    
    edadEmpleado = 0;
    
    while(edadEmpleado == 0){
        try{
            System.out.println("Introduzca la edad del empleado: ");
            edadEmpleado = teclado.nextInt();
        }catch(Exception e){
            System.out.println("Lo que has introducido no parece un número... ¡recuerda que solo se pueden introducir numéricos!");
            teclado.next();
            continue;
    }
    }
        if(edadEmpleado <18){
            System.out.println("¿No es este empleado un poco joven para el puesto?");
            System.out.println("Mejor vamos a empezar de nuevo...");
            init();
        } else if(edadEmpleado >= 65){
            System.out.println("Este empleado quizá debería estar dándole de comer a los patos del parque...¿empezamos de nuevo?");
            init();
        }
        
        System.out.println("Por favor, introduzca el sueldo anual del empleado. El formato debe ser numérico, separando las decenas con comas y los decimales con puntos: ");
        sueldoEmpleado = 0;
        while(sueldoEmpleado == 0){
            try{
                sueldoEmpleado = teclado.nextDouble();
            }catch(Exception e){
                System.out.println("Lo que has introducido no parece un sueldo... ¡recuerda que solo se pueden introducir numéricos!");
                teclado.next();
                continue;
        }
        }
        
        // He hecho esto para 'complicar' un poco más el ejercicio
        numPagas = 0;
        while(numPagas != 12 && numPagas != 14){
            try{
                System.out.println("Escoja el número de pagas: 12 o 14");
                numPagas = teclado.nextInt();
                if(numPagas != 12 && numPagas != 14){
                    System.out.println("Solo se pueden escoger 12 o 14 pagas.");
                }
            }catch(Exception e){
                System.out.println("Lo que has introducido no parece el número de pagas...¡recuerda que solo se pueden introducir numéricos!");
                teclado.nextInt();
                continue;
            }
        }
        
        //Calculamos el sueldo mensual en función del número de pagas que recibe el empleado
        sueldoMensualEmpleado = sueldoEmpleado / numPagas;
        teclado.nextLine();
        
        // Género
        // Solo nos sirve que sea masculino, femenino o vacío
        generoEmpleado = "";
        
        while(!generoEmpleado.equalsIgnoreCase("masculino") && !generoEmpleado.equalsIgnoreCase("femenino") && generoEmpleado.isEmpty()){
            System.out.println("Introduzca el género del empleado/a \nMasculino o Femenino: ");
            generoEmpleado = teclado.nextLine();
        }
        // Generamos el código del empleado
        codEmpleado = nombreEmpleado.substring(0,1).toUpperCase() + apellidoEmpleado.toUpperCase() + String.valueOf(edadEmpleado);
        System.out.println("¡Empleado " + codEmpleado + " creado con éxito!");
        
        teclado.close();
        }
    
    // Métodos para imprimir datos
    
    public void nombreEmpleado(){
        // Imprimimos nombre empleado 0
        System.out.println("Su empleado se llama : " + nombreEmpleado);
    }
    
    public void apellidoEmpleado(){
        // Imprimimos apellido empleado
        System.out.println("Su empleado se apellida: "+apellidoEmpleado);
    }
    
    public void edadEmpleado(){
        // Imprimimos apellido empleado
        System.out.println("Su empleado tiene : "+ edadEmpleado + " años.");
    }
    
    public void mostrarCodigoEmpleado(){
        // Imprimimos código del empleado
        System.out.println("El código de empleado es: " + codEmpleado);
    }
    
    public void mostrarGeneroEmpleado(){
        // Imprimimos su género
        System.out.println("El género de su empleado es: " + generoEmpleado);
    }
    
    public void mostrarSalarioEmpleado(){
        // Imprimimos el sueldo del empleado
        String tipoSalario;
        Scanner tec = new Scanner(System.in);
        System.out.println("¿Qué salario quiere consultar?\n A) Anual B) Mensual");
        tipoSalario = tec.nextLine();
        if(tipoSalario.isEmpty()){
            System.out.println("No ha proporcionado el tipo de salario.");
        } else if (tipoSalario.equalsIgnoreCase("mensual")){
            System.out.println("Este empleado cobra al mes: " + Math.round(sueldoMensualEmpleado));
        } else if (tipoSalario.equalsIgnoreCase("anual")){
            System.out.println("Este empleado cobra al año: " + sueldoEmpleado);
        } else {
            System.out.println("Por favor, proporcione un nombre válido.");
            tec.close();
            mostrarSalarioEmpleado();
        }
        tec.close();
    }
    
    public void pagaImpuestos(){
        // Si supera los 3000 euros (que hemos definido como constante) devolvemos un string diciendo que sí, y lo contrario
        String mensaje = "El empleado " + codEmpleado;
        if(sueldoMensualEmpleado > SUELDO_IMPUESTOS){
            System.out.println(mensaje + " debe pagar impuestos.");
        } else {
            System.out.println(mensaje + " está exento de pago de impuestos.");
        }
}
     
    }

