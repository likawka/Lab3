package rmi3laba;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface SimpleRMI extends Remote {
    public double add(double x, double a, double b) throws RemoteException;

}