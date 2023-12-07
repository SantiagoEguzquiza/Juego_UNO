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
        System.out.println("El cliente se ha unido al juego.");
    }

    @Override
    public void tirarCarta() throws RemoteException {
        // Lógica para jugar una carta
        System.out.println("El cliente jugó la carta ... ");
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


