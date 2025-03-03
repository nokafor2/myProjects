import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;

/**
 * 
 * @author Nna-ayua Okafor
 *
 */
public class Project7_Server extends JFrame{
	private double annIntRate = 0;
	private int numOfYrs = 0;
	private double loanAmt = 0;
	
//  Text area for displaying contents
	private JTextArea jta = new JTextArea();
	
//	Declare input and output stream
	private DataOutputStream outputToClient;
	private DataInputStream inputFromClient;
	
//	Declare inetAddress
	InetAddress inetAddress;

	public static void main(String[] args) {
		new Project7_Server();
	}
	
	public Project7_Server(){
		setLayout(new BorderLayout());
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		setTitle("Server");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		try {
//		Create server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			jta.append("Loan Calculator Server started at " + new Date() + '\n');
						
			while (true) {
				Socket socket = serverSocket.accept();
				outputToClient = new DataOutputStream(socket.getOutputStream());
				
//				Declare the server's input stream and get input from the client
				inputFromClient = new DataInputStream(socket.getInputStream());
				annIntRate = inputFromClient.readDouble();
				numOfYrs = inputFromClient.readInt();
				loanAmt = inputFromClient.readDouble();
				
//				Get Client Address and Host name and display on the server interface
				inetAddress = socket.getInetAddress();
				jta.append("Client's host name is "+inetAddress.getHostName()+'\n');
				jta.append("Client's IP Address is "+inetAddress.getHostAddress()+'\n');
				
//				Call the loan calculator class to compute the interests
				LoanCalculator loan = new LoanCalculator(annIntRate, 
						numOfYrs, loanAmt);

//				Send the monthly payment and total payment to the client
				outputToClient.writeDouble(loan.getMonthlyPayment());
				outputToClient.writeDouble(loan.getTotalPayment());
				
				jta.append("Annual Interest Rate: "+annIntRate+" Number of Years: "
						+numOfYrs+" Loan Amount: "+loanAmt+'\n');
				jta.append("Monthly Payment: "+loan.getMonthlyPayment()+
						" Total Payment: "+loan.getTotalPayment()+'\n');
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		
	}

}
