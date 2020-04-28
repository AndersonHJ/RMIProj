import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Shiqi Luo
 *
 */
public interface ISortEngine extends Remote {
	
	/**
	 * Sort the integer list
	 * @param list
	 * @return sorted list
	 */
	public ArrayList<Integer> sort(ArrayList<Integer> list) throws RemoteException;

}
