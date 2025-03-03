/**
 * 
 * @author Nna-ayua Okafor
 * 
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Project9GUI extends JApplet{
	JButton jbtSquare = new JButton();
	JButton jbtLetterA = new JButton();
	JButton jbtCircle = new JButton();
	JButton jbtLine = new JButton();
	
	JPanel p1 = new JPanel();
	//FigurePanel graphics = new FigurePanel(type)
	public Project9GUI(){
		
	}
	
	public void init(){
		/*JMenuBar jmbMenuBar = new JMenuBar();
		setJMenuBar(jmbMenuBar);
		
		jmbMenuBar.add(jmiLine);
		jmbMenuBar.add(jmiSquare);
		jmbMenuBar.add(jmiCircle);
		jmbMenuBar.add(jmiLetterA);*/
		
		JToolBar jtoolBar = new JToolBar();
		jtoolBar.setFloatable(true);
//		int dimension = 100;
		jtoolBar.setRollover(true);
		jtoolBar.setBackground(Color.cyan);
		jtoolBar.add(jbtLine);
		jtoolBar.add(jbtSquare);
		jtoolBar.add(jbtCircle);
		jtoolBar.add(jbtLetterA);
		
		FigurePanel letterAImage = new FigurePanel();
		letterAImage.setType(FigurePanel.letterA);
		//letterAImage.setFont(new Font("Californian FB", Font.BOLD, 30));
		
		jbtSquare.add(new FigurePanel(FigurePanel.square), BorderLayout.CENTER);
		jbtCircle.add(new FigurePanel(FigurePanel.oval), BorderLayout.CENTER);
		jbtLine.add(new FigurePanel(FigurePanel.line), BorderLayout.CENTER);
		jbtLetterA.add(new FigurePanel(FigurePanel.drawLetterA), BorderLayout.CENTER);
		
		p1.setLayout(new BorderLayout());
		p1.add(jtoolBar, BorderLayout.NORTH);
		
		add(p1);
		p1.validate();
//		add(jtoolBar, BorderLayout.NORTH);
		
		jbtLine.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// Display the Line on the lower panel
				p1.add(new FigurePanel(FigurePanel.line), BorderLayout.CENTER);
				jbtLine.setBackground(Color.RED);
				jbtCircle.setBackground(null);
				jbtSquare.setBackground(null);
				jbtLetterA.setBackground(null);
				p1.revalidate();
			}
			
		});
		
		jbtCircle.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				p1.add(new FigurePanel(FigurePanel.oval), BorderLayout.CENTER);
				jbtCircle.setBackground(Color.RED);
				jbtLine.setBackground(null);
				jbtSquare.setBackground(null);
				jbtLetterA.setBackground(null);
				p1.revalidate();
				
			}
			
		});
		
		jbtLetterA.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//p1.add(new FigurePanel(FigurePanel.letterA), BorderLayout.CENTER);
				p1.add(new FigurePanel(FigurePanel.drawLetterA), BorderLayout.CENTER);
				jbtLetterA.setBackground(Color.RED);
				jbtLine.setBackground(null);
				jbtCircle.setBackground(null);
				jbtSquare.setBackground(null);
				p1.revalidate();
				
			}
			
		});
		
		jbtSquare.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				p1.add(new FigurePanel(FigurePanel.square), BorderLayout.CENTER);
				jbtSquare.setBackground(Color.RED);
				jbtLine.setBackground(null);
				jbtCircle.setBackground(null);
				jbtLetterA.setBackground(null);
				p1.revalidate();
				
			}
			
		});
	}
	
	public static class FigurePanel extends JPanel{
		public static final int line = 1;
		public static final int square = 2;
		public static final int oval = 3;
		public static final int letterA = 4;
		public static final int drawLetterA = 5;
		
		private int type = 1;
		
		public FigurePanel(){
		}
		
		public FigurePanel(int type){
			this.type = type;
		}
		
		public void setType(int type){
			this.type = type;
			repaint();
		}
		
		public int getType(){
			return type;
		}
		
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			
			int width = getSize().width;
			int height = getSize().height;
			
			switch(type){
				case line:
					g.setColor(Color.BLACK);
					g.drawLine(10, 10, width - 10, height - 10);
					break;
				case square:
					g.setColor(Color.BLACK);
					int smallerSize;
					if(width < height){
						smallerSize = width;
					}
					else{
						smallerSize = height;
					}
					g.drawRect((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height));
					break;
				case oval:
					g.setColor(Color.BLACK);
					g.drawOval((int)(0.1 * width), (int)(0.1 * height), 
							(int)(0.8 * width),(int)(0.8 * height));
					break;
				case letterA:
//					Set color of letter A
					g.setColor(Color.BLACK);
					
					setFont(new Font("Californian FB", Font.BOLD, 100));
//					Get current font					
					FontMetrics fm = g.getFontMetrics();
					
//					Find the center of the letter A
					int stringWidth = fm.stringWidth("A");
					int StringAscent = fm.getAscent();
					
//					Get the leftmost coordinate of the letter
					int xCoordinate = (getWidth() / (2))- stringWidth / 2;
					int yCoordinate = (getHeight() / (2))- StringAscent / 2;
					
//					Draw the letter
					g.drawString("A", xCoordinate, yCoordinate);
					break;
				case drawLetterA:
					g.setColor(Color.BLACK);
					
					int xAxis = getWidth() / 2;
					int yAxis = getHeight() / 2;
					
					g.drawLine(xAxis, 10, width - 10, height - 10);
					g.drawLine(xAxis, 10, 10, height - 10);
					g.drawLine(10, yAxis, width - 10, yAxis);
					break;
			}
		}
		
		public Dimension getPreferredSize(){
			return new Dimension(80,80);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
//		Project9GUI frame = new Project9GUI();
		Project9GUI applet = new Project9GUI();
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		
//		Display the frame
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
