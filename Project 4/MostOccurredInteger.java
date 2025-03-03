/**
 * 
 * @author Nna-ayua Okafor
 * 
 */

import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
//import java.util.scanner

public class MostOccurredInteger extends JFrame{
	JLabel programInfo = new JLabel("This program specifies the most occurence of an integer.");
	JLabel programInfo1 = new JLabel("Press the return key to enter your number");
	JLabel programInfo2 = new JLabel("Enter '0' to end your input.");
	JLabel intInput = new JLabel("Enter Integer");
	JLabel errorMessage = new JLabel("Error Message");
	JLabel mostOccuredNum = new JLabel("Number");
	JLabel frequency = new JLabel("Occured");
	
	static int inputlength = 5;
	static JTextField intInputFld = new JTextField(inputlength);
	private int errorFld = 25;
	JTextField errorMessageFld = new JTextField(errorFld);
	JTextField mostOccuredNumFld = new JTextField('5');
	JTextField frequencyFld = new JTextField('5');
	
	JTextArea outputDisplay = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(outputDisplay);
	
	public MostOccurredInteger(){
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(programInfo);
		p1.add(programInfo1);
		p1.add(programInfo2);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,2));
		//p2.add(intInput);
		p2.add(intInputFld);
		p2.setBorder(new TitledBorder("Enter Integer"));
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		errorMessageFld.setEditable(false);
		p3.add(errorMessageFld);
		p3.setBorder(new TitledBorder("Error Message Integer Input"));
		
		/*JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(2,2));
		p4.add(mostOccuredNum);
		mostOccuredNumFld.setEditable(false);
		p4.add(mostOccuredNumFld);
		p4.add(frequency);
		frequencyFld.setEditable(false);
		p4.add(frequencyFld);*/
		
//		Panel for scroll pane
		/*JPanel outputArea = new JPanel();
		outputArea.add(outputDisplay);
		outputArea.add(scrollPane);*/
		
//		Holds all the panels
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(3,1));
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
//		p5.add(p4);
		
//		Hold the text fields and text area panels
		JPanel holdPanels = new JPanel();
		holdPanels.setLayout(new BorderLayout());
		holdPanels.add(p5, BorderLayout.NORTH);
		holdPanels.add(new JScrollPane(outputDisplay), BorderLayout.CENTER);
		
		add(holdPanels);
//		Add the panel to the container
//		add(p5);
		
		InputControl1 listener = new InputControl1();
		intInputFld.addActionListener(listener);
		
	}

	class InputControl1 implements ActionListener {
		public int intInput;
		List<Integer> frequencySet = new ArrayList<Integer>();
		public void actionPerformed(ActionEvent e) {
				String input = intInputFld.getText();
				String[] temp;
				String delimeter = " ";
				temp = input.split(delimeter);
				
				int[] results = new int[temp.length];
				for (int i = 0; i < temp.length; i++){
					try{
						results[i] = Integer.parseInt(temp[i]);
					}
					catch (NumberFormatException ex) {
						ex.printStackTrace();
					};
				}			
			
			
			List<Integer> intList = new LinkedList<Integer>();
			for(int i = 0; i < results.length; i++){
				if (results[i] != 0){
					intList.add(results[i]);
				}
				else{
					intInputFld.setEditable(false);
					/*stop taking input if it is "0" and clear the text 
					area for a new set of input.*/
					outputDisplay.setText(" ");
					break;
				}
			}
			
			// Eliminate duplicates
			Set<Integer> duplicatesFree = new HashSet<Integer>(intList);
			Set<Integer> orderedIntegers = new TreeSet<Integer>(duplicatesFree);
			
			// Extract the respective duplicate sets
			List<Integer> arrayList = new ArrayList<Integer>(orderedIntegers);

			Collection<Integer> collection = new LinkedList<Integer>(intList);
			
			Map<Integer, Integer> freqAndInteger = new LinkedHashMap<Integer, Integer>();
			for(int i = 0; i < arrayList.size(); i++){
				/*try{
					Thread.sleep(4000);
				}
				catch (InterruptedException ex) {
					ex.printStackTrace();
				}*/
					
				/*System.out.println(arrayList.get(i)+ " occurs " + 
						getFrequency(collection,arrayList.get(i)));*/
				/*mostOccuredNumFld.setText(String.valueOf(arrayList.get(i)));
				frequencyFld.setText(String.valueOf(getFrequency(collection,arrayList.get(i))));*/
				frequencySet.add(getFrequency(collection,arrayList.get(i)));
				outputDisplay.append("\n"+String.valueOf(arrayList.get(i))+ " occurs " 
						+ String.valueOf(getFrequency(collection,arrayList.get(i))+"\n"));
				
//			Save the frequency and Integer as Key and Value in a Linked Map
				freqAndInteger.put(arrayList.get(i), getFrequency(collection,arrayList.get(i)));

			}
			Set<Map.Entry<Integer, Integer>> intSet = freqAndInteger.entrySet();
			/*System.out.println("Largest occurrence is "+getMostOccurred());
			System.out.println(freqAndInteger);*/
			//System.out.println("Test getValue "+intSet.getValue(getMostOccurred()));
			
			List<Integer> mostOccuredFreq = new ArrayList<Integer>();
			for (int i = 0; i < frequencySet.size(); i++){
				if ( getMostOccurred() == frequencySet.get(i)){
					mostOccuredFreq.add(i);
				}
			}
			
			if (mostOccuredFreq.size() > 1){
				outputDisplay.append("\nThe Most occured numbers and " +
						"its respective occurrences are: " + "\n");
				for (int i = 0; i < mostOccuredFreq.size(); i++){
					outputDisplay.append("\n"+String.valueOf(arrayList.get(mostOccuredFreq.get(i))) +
							" occurs "+ frequencySet.get(mostOccuredFreq.get(i))+ "\n");
				}
			}
			else {
				outputDisplay.append("\nThe Most occured number and " +
						"its occurrence is: " + "\n");
				for (int i = 0; i < mostOccuredFreq.size(); i++){
					outputDisplay.append("\n"+String.valueOf(arrayList.get(mostOccuredFreq.get(i))) +
							" occurs "+ frequencySet.get(mostOccuredFreq.get(i))+ "\n");
				}
			}
			//System.out.println(mostOccuredFreq);
		}
		int freqLength = frequencySet.size();
		// Compute the occurrence of the integers
		public int getFrequency(Collection<?> collection, int index){
			return Collections.frequency(collection, index);
		}	
		
//		Compute the most occurred number
		int defaultVal = 0;  // max occurrence
		public int getMostOccurred(){
//			System.out.println(Collections.max(collection));
			for (int i = 0; i < frequencySet.size(); i++){
				if (defaultVal < frequencySet.get(i)){
					defaultVal = frequencySet.get(i);
				}
			}
			return defaultVal;
		}
	}
//	Display the user interface for the input
	public static void main(String[] args){
		MostOccurredInteger frame = new MostOccurredInteger();
		frame.setTitle("Most Occured Integer Finder");
		frame.pack();
		frame.setSize(350,450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		

	}
}
