import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Shiqi Luo
 *
 */
public class SortEngineImpl implements ISortEngine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SortEngineImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> list) {

		list.sort((a, b) -> a - b);
		return list;
	}

}
