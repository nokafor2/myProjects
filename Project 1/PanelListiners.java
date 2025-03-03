import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelListiners implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		AnimationApplet mainProgram = new AnimationApplet();
		mainProgram.add(new CarDiagram());
		
	}

}
