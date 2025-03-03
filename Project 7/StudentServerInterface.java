import java.rmi.*;

public interface StudentServerInterface {

	public double findScore(String name) throws RemoteException;
}
