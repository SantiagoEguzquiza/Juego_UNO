package ej.unogame_maven;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    private IJugarUno server;

    public Cliente() {
        try {
            String serverIP = "localhost"; // Cambia esto por la IP del servidor si es remoto
            int serverPort = 1099; // Puerto RMI por defecto

            Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
            server = (IJugarUno) registry.lookup("UnoServer");
            
         
         

        } catch (Exception e) {
            System.err.println("Excepción en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }

    public void tirarCarta(int cardIndex) {
        try {
            server.tirarCarta(); // Llama al método remoto del servidor para jugar una carta
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void unirseAlJuego() {
        try {
            server.unirseAlJuego(); // Llama al método remoto del servidor para unirse al juego
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public void robarCarta() {
        try {
            server.robarCarta(); // Llama al método remoto del servidor para robar una carta
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    public void verMenu() {
        try {
            server.verMenu(); 
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente(); // Crear un objeto Cliente para establecer la conexión con el servidor
        // Aquí se puede llamar a los métodos del cliente para interactuar con el servidor

        cliente.unirseAlJuego();
        
        cliente.verMenu();
       
    }
}
