import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * @author Shiqi Luo
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();
			ISortEngine engine = (ISortEngine) registry.lookup("SortEngine");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			ArrayList<Integer> numbers = new ArrayList<>(10);
			String line = "start";
			
			while(!line.equals("q")){
				System.out.print("Please input 10 numbers seperate with comma (input q to exit): ");
				line = input.readLine();
				
				if(line.equals("q")){
					System.out.println("byebye");
					break;
				}
				
				String[] list = line.split(",");
				for(String num: list){
					numbers.add(Integer.parseInt(num));
				}
				
				ArrayList<Integer> result = engine.sort(numbers);
				
				System.out.println(result);
				
				numbers = new ArrayList<>();
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
