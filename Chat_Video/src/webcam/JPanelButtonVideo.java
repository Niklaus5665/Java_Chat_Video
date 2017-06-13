package webcam;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelButtonVideo extends JPanel
{

/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

public JPanelButtonVideo()
	{
	geometry();
	control();
	appearance();
	}

/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

private void geometry()
	{
	// JComponent : Instanciation
	btnMiroir = new JButton("Miroir");
	btn1 = new JButton("Miroir");
	btn2 = new JButton("Miroir");
	btn3 = new JButton("Miroir");
	btn4 = new JButton("Miroir");
	btn5 = new JButton("Miroir");

	// Layout : Specification
		{
		FlowLayout flowlayout=new FlowLayout(FlowLayout.CENTER);
		setLayout(flowlayout);

		// flowlayout.setHgap(20);
		// flowlayout.setVgap(20);
		}

		// JComponent : add
		add(btnMiroir);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);

	}

private void control()
	{
	// rien
	}

private void appearance()
	{
	// rien
	}

/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

// Tools
private JButton btnMiroir;
private JButton btn1;
private JButton btn2;
private JButton btn3;
private JButton btn4;
private JButton btn5;

}
