/**
 * 
 * @author Nna-ayua Okafor
 * 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Project8GUI extends JFrame{
//	Declare a variable to get the divider input
	private int dividerVal;
	
//	A getter method to get the value of the divider size
	public int getDividerVal(){
		return dividerVal;
	}
	
//	A setter method to set the divider size
	public void setDividerSize(int dividerVal){
		this.dividerVal = dividerVal;
	}
	
//	Declare buttons to be adjusted
	JButton jbtLeftButton = new JButton("Left Button");
	JButton jbtRightButton = new JButton("Right Button");
	
//	Declare radio buttons to change from horizontal to vertical view
	JRadioButton jrbHorizontal = new JRadioButton("Horizontal");
	JRadioButton jrbVertical = new JRadioButton("Vertical");
	
//	Declare the divider label and text field
	JLabel lblDividerSize = new JLabel("Divider Size");
	JTextField jtfDividerSize = new JTextField('8');
	
//	Declare the continuous layout check box
	JCheckBox jcbConLayout = new JCheckBox("Continious Layout");
	
//	Declare split pane to hold the buttons 
	JSplitPane jspDivider = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,
			jbtLeftButton,jbtRightButton);
	
//	Declare a title bar
	TitledBorder radioBtnBorder;
	
	public Project8GUI(){
//		Group radio button
		ButtonGroup radioBtnGroup = new ButtonGroup();
		radioBtnGroup.add(jrbHorizontal);
		radioBtnGroup.add(jrbVertical);
	
//		create a layout to hold text label and text field
		JPanel p0 = new JPanel();
		p0.setLayout(new BorderLayout());
		p0.add(lblDividerSize, BorderLayout.WEST);
		p0.add(jtfDividerSize, BorderLayout.CENTER);
		
//		create panel to hold check box and divider
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(jcbConLayout, BorderLayout.NORTH);
		p1.add(p0, BorderLayout.CENTER);

//		Create a panel for the radio buttons
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(2,1));
		radioPanel.add(jrbHorizontal);
		radioPanel.add(jrbVertical);
		radioPanel.setBorder(new TitledBorder("Orientation"));
				
//		Create a bottom panel to hold radio bottoms and divider
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(radioPanel, BorderLayout.WEST);
		bottomPanel.add(p1, BorderLayout.CENTER);
		
//		Create top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
//		jspDivider.setOneTouchExpandable(true);
		topPanel.add(jspDivider, BorderLayout.CENTER);
//		topPanel.add(jbtRightButton);
		
//		Merge top and bottom panels
		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
//		Set default appearance
		jspDivider.setContinuousLayout(false);
		jspDivider.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jspDivider.validate();
		
//		Change to horizontal view
		jrbHorizontal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jspDivider.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
				jspDivider.revalidate();
			}
		});
		
//		Change to vertical view
		jrbVertical.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jspDivider.setOrientation(JSplitPane.VERTICAL_SPLIT);
				//jspDivider.setLeftComponent(jbtLeftButton);
				//jspDivider.setRightComponent(jbtRightButton);
				//jspDivider = new JSplitPane();
				jspDivider.revalidate();
			}
		});
		
//		Specify if the layout should be continuous
		jcbConLayout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jspDivider.setContinuousLayout(true);
				jspDivider.revalidate();
			}
		});
		
//		Set a listener to adjust the divider size
		jtfDividerSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dividerVal = Integer.parseInt(jtfDividerSize.getText());
				//setDividerSize(dividerVal);
				jspDivider.setDividerSize(getDividerVal());
				jspDivider.revalidate();
			}
		});
	}
	
//	Display the application
	public static void main(String[] args){
		Project8GUI frame = new Project8GUI();
		frame.setTitle("Project 8");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);		
	}

}
