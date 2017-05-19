import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelVideo extends JPanel
{

/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

public JPanelVideo(JFrameMenu jFrameMenu)
	{
	this.jFrameMenu = jFrameMenu;
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
	lblIp = new JLabel("IP : "+jFrameMenu.getIp());
	lblPseudo = new JLabel("Pseudo : "+jFrameMenu.getPseudo());
	// Layout : Specification
		{
		FlowLayout flowlayout=new FlowLayout(FlowLayout.CENTER);
		setLayout(flowlayout);

		// flowlayout.setHgap(20);
		// flowlayout.setVgap(20);
		}

		// JComponent : add
		add(lblIp);
		add(lblPseudo);
	}

private void control()
	{
	//Changement couleur, contraste, résolution, miroir, (Ecriture text sur video si le temps le permet)
	// rien
	}

private void appearance()
	{

	jFrameMenu.setResizable(true);
	jFrameMenu.setSize(700,700);

	// rien
	}

/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

// Tools
JLabel lblPseudo;
JLabel lblIp;
JFrameMenu jFrameMenu;
}
