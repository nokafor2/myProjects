import java.rmi.Remote;
import java.rmi.registry.*;

public class RegisterWithRMIServer {
	public static void main(String[] args){
		try {
			StudentServerInterface obj = new StudentServerInterfaceImpl();
			Registry registry = LocateRegistry.getRegistry();
			
//			Check for the number of clients
			String nameInRegistry[] = registry.list();
			int numOfClient = nameInRegistry.length; 
			
/*			Check if the number of client is less than 11 and unbinds the registry
			if it is greater*/
			if (numOfClient < 11){
				registry.rebind("StudentServerInterfaceImpl", (Remote) obj);
				System.out.println("Student server " + obj + " registered");
			}
			else {
				registry.unbind("StudentServerInterfaceImpl");
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
