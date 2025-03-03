import java.io.*; 
public class a { 
	public static void main(String[] args) throws IOException { 
		DataOutputStream output = new DataOutputStream( new FileOutputStream("t.dat")); 
		output.writeUTF("ABCD"); 
		output.close(); 
	} 
}
