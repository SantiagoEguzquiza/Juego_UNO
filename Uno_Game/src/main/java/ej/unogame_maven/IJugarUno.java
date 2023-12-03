package ej.unogame_maven;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IJugarUno extends Remote {
    
    
    void unirseAlJuego() throws RemoteException;
    void robarCarta() throws RemoteException;
    void tirarCarta() throws RemoteException;
    void verMenu() throws RemoteException;
    
}
