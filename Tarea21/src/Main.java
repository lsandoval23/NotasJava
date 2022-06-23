import org.lsandoval.herencia.Empleado;
import org.lsandoval.herencia.Gerente;

public class Main {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado("Luis", "Sandoval", "112", "San Juan de Miraflores",
                2200d, 3);
        System.out.println(empleado1);
        System.out.println("===========================");

        Gerente gerente = new Gerente("Carlos", "Rodas", "123", "San Miguel",
                6000d, 4, 100000d);
        System.out.println(gerente);

        System.out.println("============= Aumentamos el sueldo del empleado ==============");
        empleado1.aumentarRemuneracion(30);
        System.out.println(empleado1);



    }
}
