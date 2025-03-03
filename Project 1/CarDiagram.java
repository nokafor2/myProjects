/**
 * 
 * @author Nna-ayua Okafor
 * 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


//	Draw the car
public class CarDiagram extends JPanel {
	 private int xPoints[] = {30, 40, 80, 90, 30};
	 private int yPoints[] = {50, 30, 30, 50, 50};
	 private int dx = 2;
	 private int rectXPoint = 10;
	 private int cirXPoints1 = 20;
	 private int cirXPoints2 = 80;
	 
	 public CarDiagram(){
		 new TimerListener();
	 }
	 
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
//		Draw top of the car
//		Polygon carTop = new Polygon();
		g.setColor(Color.red);
		g.fillPolygon(getXPoints(), yPoints, xPoints.length);

//		Draw the base of the car
		g.setColor(Color.green);
		g.fillRect(getRectXPoint(), 50, 100, 30);

//		Draw the tires of the car
		g.setColor(Color.gray);
		g.fillOval(getCirXPoints1(), 79, 15, 15);
		g.fillOval(getCirXPoints2(), 79, 15, 15);

		if ((rectXPoint + 100) == getWidth()){
			rectXPoint = -1 * getRectXPoint();
		}
		else if (rectXPoint <= 0){
			setRectXPoint(0);
		}
		else {
			rectXPoint += 2;
		}
	}
	
	public int[] getXPoints(){
		//int j = 2;
		for (int i = 0; i < xPoints.length; i++){
			xPoints[i] = xPoints[i] + dx;
		}
		return xPoints;
	}
	
	public int getRectXPoint(){
		return rectXPoint + dx;
	}
	
	public void setRectXPoint(int rectXPoint){
		this.rectXPoint = rectXPoint;
	}
	
	public int getCirXPoints1(){
		return cirXPoints1 + dx;
	}
	
	public int getCirXPoints2(){
		return cirXPoints2 + dx;
	}
	
//  Timer Class that controls the animation
	public class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			repaint();
		}
		
	}
}





