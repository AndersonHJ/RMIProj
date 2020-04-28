import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Shiqi Luo
 *
 */
public class SortEngineServer {

	/**
	 * 
	 */
	public SortEngineServer() {
		try {
			SortEngineImpl engine = new SortEngineImpl();

			ISortEngine stub = (ISortEngine) UnicastRemoteObject.exportObject(engine, 18866);
			
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("SortEngine", stub);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortEngineServer server = new SortEngineServer();
		
	}

}
