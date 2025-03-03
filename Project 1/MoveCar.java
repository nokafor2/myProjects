import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
import javax.swing.*;
import javax.swing.Timer;

public class MoveCar {
	public MoveCar(){
		new TimerListener();
		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
	}
	
	CarDiagram car = new CarDiagram();
	
//  Timer Class that controls the animation
	public class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			car.repaint();
		}
		
	}
}
