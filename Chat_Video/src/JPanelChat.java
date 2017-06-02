import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JPanelChat extends JPanel
{

/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

public JPanelChat()
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
	btnEnvoyerMessage = new JButton("Envoyer");
	txtAreaMessage = new JTextArea(15,1);
	txtSaisieUserMessage = new JTextField();
	// Layout : Specification
		{
		GridBagLayout gridBagLayout=new GridBagLayout();
		setLayout(gridBagLayout);

		// flowlayout.setHgap(20);
		// flowlayout.setVgap(20);
		}

		// JComponent : add
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST; //ancre a gauche des cellules les composants
		c.insets = new Insets(0, 0, 10, 5);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		add(txtAreaMessage,c);
		c.gridx = 0;
		c.gridy = 1;
		add(txtSaisieUserMessage,c);
		c.gridx = 1;
		c.gridy = 1;
		add(btnEnvoyerMessage,c);

	}

private void control()
	{
	// rien
	}

private void appearance()
	{
	// rien
	Dimension dTextField = new Dimension(300, 20);
	txtSaisieUserMessage.setSize(dTextField);
	txtSaisieUserMessage.setPreferredSize(dTextField);
	txtSaisieUserMessage.setMinimumSize(dTextField);
	txtSaisieUserMessage.setMaximumSize(dTextField);
	txtAreaMessage.setSize(dTextField);
	txtAreaMessage.setPreferredSize(dTextField);
	txtAreaMessage.setMinimumSize(dTextField);
	txtAreaMessage.setMaximumSize(dTextField);
	}

/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

// Tools
private JTextArea txtAreaMessage;
private JButton btnEnvoyerMessage;
private JTextField txtSaisieUserMessage;

}
