package org.lsandoval.clasesabstractas.form;

import org.lsandoval.clasesabstractas.form.elementos.ElementoForm;
import org.lsandoval.clasesabstractas.form.elementos.InputForm;
import org.lsandoval.clasesabstractas.form.elementos.SelectForm;
import org.lsandoval.clasesabstractas.form.elementos.TextareaForm;
import org.lsandoval.clasesabstractas.form.elementos.select.Opcion;
import org.lsandoval.clasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {
        InputForm username = new InputForm("username"); // tipo text por default
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador()).addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador()).addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");
        // addOpcion puede usarse de forma concatenada
        lenguaje.addOpcion(java)
        .addOpcion(new Opcion("2", "Python"))
        .addOpcion(new Opcion("3", "JavaScript"))
        .addOpcion(new Opcion("4", "TypeScript").setSelected());
        lenguaje.addOpcion(new Opcion("5", "PHP"));

        // java.setSelected(true);



        // Declaracion de una clase anonima, esta no tiene nombre y solo se puede instanciar un objeto de esta clase
        // Se pueden crear a partir de clases abstractas o interfaces
        ElementoForm saludar = new ElementoForm("saludo"){
            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre +
                        "' value = '" + this.valor +
                        "'>";
            }
        } ;
        saludar.setValor("Hola, input deshabilitado");



        username.setValor("john.doe");
        password.setValor("");
        email.setValor("john.doecorreo.com");
        edad.setValor("28");
        experiencia.setValor("... mas de 10 anios de experiencia ...");



        // Dos metodos para inicializar la lista de elementos
        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);
        /* List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje); */

        for (ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
        }



        for (ElementoForm e: elementos){
            if(!e.esValido()){
                e.getErrores().forEach(err -> {
                    System.out.println(err);
                });
            }
        }
    }
}
