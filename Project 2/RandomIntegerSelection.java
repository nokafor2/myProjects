import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomIntegerSelection extends JFrame{
//	Initialize variables
	public static int arrayIndexInput;
	
//	create label
	JLabel arrayIndex = new JLabel("Array Index");
	JLabel arrayElement = new JLabel("Array Element");
	
//	create test fields
	public JTextField arrayIndexFld = new JTextField(8);
	JTextField arrayElementFld = new JTextField(8);
	
//	create a button
	JButton showElement = new JButton("Show Element");
	
//	create a no argument constructor
	public RandomIntegerSelection(){
//		create a panel to hold the text field and label
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,2,10,10));
		p1.add(arrayIndex);
		p1.add(arrayIndexFld);
		p1.add(arrayElement);
		p1.add(arrayElementFld);
		
//		set alignment to the text fields
		arrayIndexFld.setHorizontalAlignment(JTextField.RIGHT);
		arrayElementFld.setHorizontalAlignment(JTextField.CENTER);
		arrayElementFld.setEditable(false);
		
//		create a border layout to hold the panels
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(showElement, BorderLayout.SOUTH);
		
//		create an action listener for the button
		showElement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				arrayIndexInput = Integer.parseInt(arrayIndexFld.getText()); 
				RandomNumberGenerator randomNumCall = new RandomNumberGenerator(arrayIndexInput);
				try {
					arrayElementFld.setText(String.valueOf(randomNumCall.randomNumGen()));		
				}
				catch (IndexOutOfBoundsException ex){
					arrayElementFld.setText(ex.getMessage());
				}
				arrayElementFld.setText(String.valueOf(randomNumCall.randomNumGen()));
			}
		});
		
//		Initialize a listener if the return key is pressed and create one for the input text field
		IndexTextField listener = new IndexTextField();
		arrayIndexFld.addActionListener(listener);
	}
//	create a GUI interface to run the program 
	public static void main(String[] args) {
		RandomIntegerSelection frame = new RandomIntegerSelection();
		frame.setTitle("Random Integer Selector");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

//	create an action listener if the return key is pressed
	class IndexTextField implements ActionListener{
		int arrayIndexInput2;
		@Override
		public void actionPerformed(ActionEvent e) {
			arrayIndexInput = Integer.parseInt(arrayIndexFld.getText()); 
			RandomNumberGenerator randomNumCall1 = new RandomNumberGenerator(arrayIndexInput);
			try {
				arrayElementFld.setText(String.valueOf(randomNumCall1.randomNumGen()));		
			}
			catch (IndexOutOfBoundsException ex){
				arrayElementFld.setText(ex.getMessage());
			}
			arrayElementFld.setText(String.valueOf(randomNumCall1.randomNumGen()));
			
		}
		
	}
}

