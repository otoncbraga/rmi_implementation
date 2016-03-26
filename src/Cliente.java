import source.LocateSimpleRegistry;
import source.RemoteObjectRef;
import source.SimpleRegistry;

/**
 * Created by otonbraga on 13/03/16.
 */
public class Cliente {

    static String host;
    static int port;

    public static void main (String args[]) throws Exception{

        String InitialClassName = "Calculadora";
        String host = "127.0.0.1";
        int port = Integer.parseInt("12345");
        String serviceName = "calculadora";

        // locate the registry and get ror.
        SimpleRegistry sr =
                LocateSimpleRegistry.getRegistry(host, port);
        RemoteObjectRef ror = sr.lookup(serviceName);

        // get (create) the stub out of ror.
        Calculadora calculadora = (Calculadora) ror.localise();
        System.out.print("soma = " + calculadora.soma(1, 1));
    }
}