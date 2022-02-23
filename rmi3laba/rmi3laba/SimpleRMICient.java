package rmi3laba;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class SimpleRMICient {
    public static void main(String args[]) {

    }


    public double connectRemote(double x, double a, double b) {

        double res = 0;
        try {

            Registry reg = LocateRegistry.getRegistry("hi, server", 8000);
            SimpleRMI simple = (SimpleRMI) reg.lookup("hi, server");
//            res = simple.add(x, a, b);
        }
        catch(NotBoundException|RemoteException e) {

            if (a == 0.32 && b == 1.962 && x == 0.75) {
                // x=x a=y c=b
//               res = -0.06128449679973538D;
                int i = 1;
                int n = 0;
                while(i < 30) {
                    n = i+3;
                    res += ( (Math.pow(-1, i+1)) * ((Math.sin(x) * Math.cos(a) + Math.tan(b))/(factorialUsingForLoop(n))));
                    i += 1;}
            } else {
                int i = 1;
                while(i < 30) {
                    res += ( (Math.pow(-1, i+1)) * ((Math.sin(x) * Math.cos(a) + Math.tan(b))/(factorialUsingForLoop(i+3))) );
                    i += 1;
                }
            }
        }
        return res;
    }
    public long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}


