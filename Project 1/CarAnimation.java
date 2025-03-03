
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

public class CarAnimation extends JFrame {
	public CarAnimation(){
		JLabel carIntro = new JLabel("Enter a whole number (1 - 10) and press ENTER to change the speed.");
		
//		create label for the car inputs
		JLabel car1lbl = new JLabel("Car1:");
		JLabel car2lbl = new JLabel("Car2:");
		JLabel car3lbl = new JLabel("Car3:");
		JLabel car4lbl = new JLabel("Car4:");
		
//		create text fields to get the input speed 
		JTextField car1fld = new JTextField(3);
		JTextField car2fld = new JTextField(3);
		JTextField car3fld = new JTextField(3);
		JTextField car4fld = new JTextField(3);
		
//		create a panel where the cars will run
		JPanel car1Panel = new JPanel();
		JPanel car2Panel = new JPanel();
		JPanel car3Panel = new JPanel();
		JPanel car4Panel = new JPanel();
		
//		JFrame car1Frame = new JFrame();

//		Align the text input right
		car1fld.setHorizontalAlignment(JTextField.RIGHT);
		car2fld.setHorizontalAlignment(JTextField.RIGHT);
		car3fld.setHorizontalAlignment(JTextField.RIGHT);
		car4fld.setHorizontalAlignment(JTextField.RIGHT);
		
//		Test the car panels
		car1Panel.add(carIntro);
		car2Panel.add(carIntro);
		car3Panel.add(carIntro);
		car4Panel.add(carIntro);
		
		add(new carDiagram());
		
		JPanel p0 = new JPanel();
		p0.add(carIntro);
		
//		create a panel for the car controls
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(car1lbl);
		p1.add(car1fld);
		p1.add(car2lbl);
		p1.add(car2fld);
		p1.add(car3lbl);
		p1.add(car3fld);
		p1.add(car4lbl);
		p1.add(car4fld);
		
		Border lineBorder = new LineBorder(Color.BLUE, 2);
		car1Panel.setBorder(lineBorder);
		car2Panel.setBorder(lineBorder);
		car3Panel.setBorder(lineBorder);
		car4Panel.setBorder(lineBorder);
		
		/*car1Panel.setSize(500, 150);
		car1Panel.setEnabled(true);
		car1Panel.add(new carDiagram());*/
		
//		create a panel to hold the cars' panels
		//JPanel p2 = new JPanel();
		//setBorder(lineBorder);
		
//		car1Frame.add(new carDiagram());
		
		setLayout(new BorderLayout());
		add(p0, BorderLayout.NORTH);
		add(p1, BorderLayout.CENTER);
//		add(car1Frame, BorderLayout.SOUTH);
		//add(p2, BorderLayout.SOUTH);
		
		/*setLayout(new GridLayout(4,1));
		add(car1Panel);*/
		/*add(car2Panel);
		add(car3Panel);
		add(car4Panel);*/
		
		System.out.println(car1Panel.getHeight());
		System.out.println(car1Panel.getWidth());
		
		
	}
	
	public static void main(String[] args) {
		CarAnimation frame = new CarAnimation();
		frame.setTitle("Car Animation");
//		frame.setSize(500,500);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}


