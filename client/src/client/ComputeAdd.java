package client;


import server.Compute;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputeAdd {
    public static void main(String[] args){
        if(System.getSecurityManager()==null){
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Compute compute = (Compute)registry.lookup("Compute1");
            Add add = new Add();
            Integer result = compute.executeTask(add);
            System.out.println(result);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
