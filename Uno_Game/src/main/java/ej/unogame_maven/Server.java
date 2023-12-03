//package ej.unogame_maven;
//
//
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//// Implementa la lógica del juego en la clase del servidor
//public class Server extends UnicastRemoteObject implements IJugarUno {
//    private String[] players;
//    private UnoDeck deck;
//    private UnoCard currentCard;
//    
//    
//
//    public Server() throws RemoteException {
//       super();
//    }
//    @Override
//    public void unirseAlJuego() throws RemoteException {
//        System.out.println("hola desde el server");
//    }
//    @Override
//    public synchronized void tirarCarta() throws RemoteException {
//        // Lógica para jugar una carta por el cliente
//        // Verifica si la carta es jugable y realiza las acciones correspondientes
//    }
//
//    @Override
//    public synchronized void robarCarta() throws RemoteException {
//        // Lógica para que un jugador robe una carta
//        // Añade una carta al jugador actual desde el mazo
//    }
//
//    // Otros métodos del juego UNO que se necesiten implementar aquí
//
//    public static void main(String[] args) {
//        try {
//   
//            Server unoServer = new Server();
//            java.rmi.registry.LocateRegistry.createRegistry(1099);
//            java.rmi.Naming.rebind("UnoGameServer", unoServer);
//            System.out.println("Servidor del juego UNO iniciado.");
//        } catch (Exception e) {
//            System.err.println("Excepción en el servidor: " + e.toString());
//            e.printStackTrace();
//        }
//    }
//
//    
//}


package ej.unogame_maven;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements IJugarUno {
    
    public Server() {
        try {
            // Crea e instancia el servidor RMI
            IJugarUno stub = (IJugarUno) UnicastRemoteObject.exportObject(this, 0);
            
            // Registra el servidor en el registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("UnoServer", stub);
            
            System.out.println("Servidor Uno iniciado.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unirseAlJuego() throws RemoteException {
        // Lógica para que el cliente se una al juego
        System.out.println("El cliente se ha unido al juego. rrrr");
    }

    @Override
    public void tirarCarta() throws RemoteException {
        // Lógica para jugar una carta
        System.out.println("El cliente jugó la carta en el índice: ");
    }

    @Override
    public void robarCarta() throws RemoteException {
        // Lógica para robar una carta
        System.out.println("El cliente robó una carta.");
    }

    public static void main(String[] args) {
        new Server(); // Inicia el servidor
    }

    @Override
    public void verMenu() throws RemoteException {
        new Menu().setVisible(true);
    }
}


