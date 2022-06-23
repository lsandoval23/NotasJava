package org.rygsol.pooherencia;

public class Alumno extends Persona{

    private String institucion;
    private double notaMatematica;
    private double notaCastellano;
    private double notaHistoria;


    public Alumno(){
        System.out.println("Alumno: Inicializando constructor");
    }

    // Usamos la palabra reservada super, para poder usar el constructor de la clase padre
    // Asi podemos obtener acceso a los atributos de la clase padre, a pesar que sean private
    public Alumno(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Alumno(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public Alumno(String nombre, String apellido, int edad, String institucion) {
        super(nombre, apellido, edad); // o this(nombre, apellido, edad)
        this.institucion = institucion;
    }

    public Alumno(String nombre, String apellido, int edad, String institucion, double notaMatematica, double notaCastellano, double notaHistoria) {
        super(nombre, apellido, edad);
        this.institucion = institucion;
        this.notaMatematica = notaMatematica;
        this.notaCastellano = notaCastellano;
        this.notaHistoria = notaHistoria;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaCastellano() {
        return notaCastellano;
    }

    public void setNotaCastellano(double notaCastellano) {
        this.notaCastellano = notaCastellano;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    @Override
    public String saludar() {
        // Se puede usar el metodo del padre para concatenar con el del hijo
        String saludo = super.saludar();
        return saludo + " soy un alumno y mi nombre es " + this.getNombre();
    }

    public double calcularPromedio(){
        // Se reemplaza this por la funcion estatica de la clase, para observar que se recorre la clases padre
        System.out.println("calcularPromedio: " + Alumno.class.getCanonicalName());
        return (notaHistoria + notaCastellano + notaMatematica)/3;
    }

    @Override
    public String toString() {
        return  super.toString() + "\n institucion='" + institucion + '\'' +
                ", notaMatematica=" + notaMatematica +
                ", notaCastellano=" + notaCastellano +
                ", notaHistoria=" + notaHistoria +
                '}';
    }
}
