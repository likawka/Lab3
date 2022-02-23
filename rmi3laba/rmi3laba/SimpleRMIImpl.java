package rmi3laba;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class SimpleRMIImpl extends UnicastRemoteObject implements SimpleRMI{
    public SimpleRMIImpl()throws RemoteException {

        super();
    }

    public long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    @Override
    public double add(double x, double a, double b) throws RemoteException {
        int i = 1;
        double result = 0;
        while(i < 30) {
            result += ( (Math.pow(-1, i+1)) * ((Math.sin(x) * Math.cos(a) + Math.tan(b))/(factorialUsingForLoop(i+3))) );
            i += 1;
        }
        return result;
    }

    public static void main(String args[]) throws RemoteException {
        try {
            Registry reg = LocateRegistry.createRegistry(4444);
            reg.rebind("hi, server", new SimpleRMIImpl());
        }
        catch(RemoteException e) {
            System.out.println("Exception:" + e);
        }
    }
}
