/**
 * 
 * @author Nna-ayua Okafor
 *
 */

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Project6_Client extends JFrame{
	double monthlyPayment = 0;
	double totalPayment = 0;
	private double annIntRate = 0;
	private int numOfYrs = 0;
	private double loanAmt = 0;
	
	private JTextArea jtaClient = new JTextArea();
	
	JLabel lblAnnIntRate = new JLabel("Annual Interest Rate");
	JLabel lblNumOfYrs = new JLabel("Number Of Years");
	JLabel lblLoanAmt = new JLabel("Loan Amount");
	
	JTextField jtfAnnIntRate = new JTextField('8');
	JTextField jtfNumOfYrs = new JTextField('8');
	JTextField jtfLoanAmt = new JTextField('8');
	
	JButton jbtSubmit = new JButton("Submit");

	String host = "localhost";
	
	DataInputStream inputFromServer;
	DataOutputStream outputToServer;
	
	public static void main(String[] args) {
		new Project6_Client();
	}
	
	public Project6_Client(){
		jtfAnnIntRate.setHorizontalAlignment(JTextField.RIGHT);
		jtfNumOfYrs.setHorizontalAlignment(JTextField.RIGHT);
		jtfLoanAmt.setHorizontalAlignment(JTextField.RIGHT);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,2,0,0));
		p1.add(lblAnnIntRate);
		p1.add(jtfAnnIntRate);
		p1.add(lblNumOfYrs);
		p1.add(jtfNumOfYrs);
		p1.add(lblLoanAmt);
		p1.add(jtfLoanAmt);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(p1, BorderLayout.CENTER);
		p2.add(jbtSubmit, BorderLayout.EAST);
		
		setLayout(new BorderLayout());
		add(p2, BorderLayout.NORTH);
		add(new JScrollPane(jtaClient), BorderLayout.CENTER);
		
		jbtSubmit.addActionListener(new ButtonListener());
		
		setTitle("Loan Calculator of Client");
//		pack();
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			try {
				Socket socket = new Socket(host, 8000);
				
//				create output stream and send values for calculation to the serve
				outputToServer = new DataOutputStream(socket.getOutputStream());
				inputFromServer = new DataInputStream(socket.getInputStream());
				try {
					annIntRate = Double.parseDouble(jtfAnnIntRate.getText().trim());
					numOfYrs = Integer.parseInt(jtfNumOfYrs.getText().trim());
					loanAmt = Double.parseDouble(jtfLoanAmt.getText().trim());
				}
				catch (NumberFormatException ex){
					jtaClient.append(ex.toString() + '\n');
				}
				outputToServer.writeDouble(annIntRate);
				outputToServer.writeInt(numOfYrs);
				outputToServer.writeDouble(loanAmt);
				
//				Get input data from the server
				monthlyPayment = inputFromServer.readDouble();
				totalPayment = inputFromServer.readDouble();
				
				jtaClient.append("Annual Interest Rate "+jtfAnnIntRate.getText()+
						" Number Of Years "+jtfNumOfYrs.getText()+
						" Loan Amount "+jtfLoanAmt.getText()+'\n');
				jtaClient.append("Monthly Payment: "+monthlyPayment+
						" Total Payment "+totalPayment+'\n');
			
			}
			catch (IOException ex){
				ex.printStackTrace();
			}
			
		}
		
	}

}
