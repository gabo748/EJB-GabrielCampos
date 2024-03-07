import StateFul.IContador;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class TestSaludo {
    public static void main(String[] args) {
        contar();
    }

    private static void contar() {
        System.out.println("Llamado al EJB");

        try {


            // Create the InitialContext (automatically loads configuration from jndi.properties)
            Context jdni = new InitialContext();


            // Perform JNDI lookup using the configured properties
            IContador agregar = (IContador) jdni.lookup("java:global/EJBNew-1.0-SNAPSHOT/Contar!StateFul.IContador");

            // Use the obtained reference
            System.out.println(agregar.test());
            agregar.agregarItem();
            agregar.agregarItem();
            System.out.println("registros: " + agregar.contarItem());
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }

    private static void printLoadedProperties() {
        try {
            // Create a new Properties object to store the loaded properties
            Properties properties = new Properties();

            // Load the properties from the system environment
            properties.putAll(System.getenv());

            // Load the properties from the system properties
            properties.putAll(System.getProperties());

            // Print out the loaded properties
            System.out.println("Loaded Properties:");
            properties.forEach((key, value) -> System.out.println(key + ": " + value));
        } catch (Exception e) {
            System.out.println("Error printing loaded properties: " + e.getMessage());
        }
    }
}
