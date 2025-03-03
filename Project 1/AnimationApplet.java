/**
 * 
 * @author Nna-ayua Okafor
 * 
 */

import javax.swing.*;
import javax.swing.border.*;
//import MoveCar.TimerListener;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationApplet extends JFrame {
	public int car1Speed = 0;
	public int car2Speed = 0;
	public int car3Speed = 0;
	public int car4Speed = 0;
	
	JLabel carIntro = new JLabel("Enter a whole number (1 - 10) and press ENTER to change the speed.");

//	create label for the car inputs
	JLabel car1lbl = new JLabel("Car1:");
	JLabel car2lbl = new JLabel("Car2:");
	JLabel car3lbl = new JLabel("Car3:");
	JLabel car4lbl = new JLabel("Car4:");

//	create text fields to get the input speed
	JTextField car1fld = new JTextField(3);
	JTextField car2fld = new JTextField(3);
	JTextField car3fld = new JTextField(3);
	JTextField car4fld = new JTextField(3);
	
	public AnimationApplet(){
//		create a panel where the cars will run
		JPanel car1Panel = new JPanel();
		JPanel car2Panel = new JPanel();
		JPanel car3Panel = new JPanel();
		JPanel car4Panel = new JPanel();

//		Align the text input right
		car1fld.setHorizontalAlignment(JTextField.RIGHT);
		car2fld.setHorizontalAlignment(JTextField.RIGHT);
		car3fld.setHorizontalAlignment(JTextField.RIGHT);
		car4fld.setHorizontalAlignment(JTextField.RIGHT);

//		Test the car panels
		/*JLabel test = new JLabel("Test");
		car1Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		car1Panel.add(test);
		car2Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		car2Panel.add(test);
		car3Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		car3Panel.add(test);
		car4Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		car4Panel.add(test);*/

		JPanel p0 = new JPanel();
		p0.add(carIntro);

//		create a panel for the car controls
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
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

		car1Panel.setLayout(new BorderLayout());
		car1Panel.add(new CarDiagram(), BorderLayout.CENTER);
		
//		create a panel to hold the cars' panels
		JPanel p2 = new JPanel();
	//	p2.setBorder(lineBorder);
		p2.setLayout(new GridLayout(4,1));
		p2.add(car1Panel);
		p2.add(new CarDiagram());
		p2.add(car1Panel.add(new CarDiagram()));
		p2.add(new CarDiagram());
		
		// Merge the game info and the input text fields to one panel 
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(p0, BorderLayout.NORTH);
		topPanel.add(p1,BorderLayout.SOUTH);

//		Merge the top panel and the car panels
		car1Panel.add(new CarDiagram());
		Container g = this.getContentPane();
		g.setLayout(new BorderLayout());
		// Alla

		g.add(topPanel, BorderLayout.NORTH);
		g.add(p2, BorderLayout.CENTER);

//		Create a timer to control the car animation
		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
		
//		Get car 1 speed
		car1fld.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				car1Speed = Integer.parseInt(car1fld.getText());
			}
		});
		
//		Get car 2 speed
		car2fld.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				car2Speed = Integer.parseInt(car1fld.getText());
			}
		});
		
//		Get car 3 speed
		car3fld.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				car3Speed = Integer.parseInt(car1fld.getText());
			}
		});
		
//		Get car 4 speed
		car4fld.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				car4Speed = Integer.parseInt(car1fld.getText());
			}
		});
	}

	public class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CarDiagram car = new CarDiagram();
			car.repaint();
		}
		
	}
	
	public static void main(String[] args) {
		AnimationApplet frame = new AnimationApplet();
		frame.setTitle("Car Animation");
		frame.setSize(750,550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

