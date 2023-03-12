package org.lsandoval.patrones.decorator;

import org.lsandoval.patrones.decorator.decoradores.*;

public class EjemploDecorator {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        DataSource plain = new FileDataSource("C:\\Users\\asus\\Documents\\JavaMaster\\NotasJava\\Seccion32_PatronesDisenio\\src\\OutputDemoEncrypted.txt");
        DataSource encoded = new EncryptionDecorator(plain);
        DataSource compressed = new CompressionDecorator(encoded);

        // Sobre el ultimo wrapper ejecutamos los metodos ya que tienen todas las funcionalidades adicionales
        compressed.writeData(salaryRecords);
        System.out.println(compressed.readData());







        /*

        DataSourceDecorator encoded = new CompressionDecorator(
                                        new EncryptionDecorator(
                                            new FileDataSource("C:\\Users\\asus\\Documents\\JavaMaster\\NotasJava\\Seccion32_PatronesDisenio\\src\\OutputDemo.txt")));

        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("C:\\Users\\asus\\Documents\\JavaMaster\\NotasJava\\Seccion32_PatronesDisenio\\src\\OutputDemo2.txt");
        plain.writeData(salaryRecords);

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());



         */
    }
}
