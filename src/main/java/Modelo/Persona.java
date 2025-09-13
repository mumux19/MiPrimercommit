package Modelo;

public class Persona {
    private String nombre;
    private String apellido;
    private String DNI;
    private int edad;
    private double altura;
    private int peso;

    public static Persona create(String nombre, String apellido, String DNI, int edad, double altura, int peso) {

        return new Persona(nombre, apellido, DNI, edad, altura, peso);
    }

    public Persona(String nombre, String apellido, String DNI, int edad, double altura, int peso) throws PersonaExceptionNombre {


        if(nombre.isBlank() || nombre==null){
            throw new PersonaExceptionNombre("El nombre no puede ser nulo ni vacio");

        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;

    }


    public String getApellido() {
        return this.apellido;
    }

}
