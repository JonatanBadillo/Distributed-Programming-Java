/*
  El objetivo del siguiente código es encontrar la dirección IP correspondiente 
  al nombre de una máquina pasada como argumento.
 */
package resolvename;
import java.net.*;

public class ResolveName {
    public static void main(String[] args) {
        InetAddress adresse;
        try{
            adresse=InetAddress.getByName("localhost");
            System.out.println(adresse.getHostAddress());
            adresse=InetAddress.getByName("www.facebook.com");
            System.out.println(adresse.getHostAddress());
            System.out.println(adresse);
        }catch(UnknownHostException e) { }
    }

}