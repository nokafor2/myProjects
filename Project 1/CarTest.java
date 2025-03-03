/**
 * 
 * @author Nna-ayua Okafor
 * 
 */

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarTest extends JFrame {
	
	Timer timer = new Timer(1000, new TimerListener());
	CarDiagram car = new CarDiagram();
	
	public CarTest(){
		
//		System.out.println(car.getWidth());
//		System.out.println(car.getHeight());
		add(car);
		//car.repaint();
		
		
		timer.start();
	}
	
	public class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CarDiagram car = new CarDiagram();
			car.repaint();
		}
		
	}
	
	public static void main(String[] args){
		CarTest frame = new CarTest();
		frame.setTitle("Tests CarDiagram Class");
		frame.setSize(750,150);
//		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
