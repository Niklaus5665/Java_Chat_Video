
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelInformation extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelInformation()
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
		auteur = new JLabel("Auteur : ");
		version = new JLabel("N° de version : 1.0.0");
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
			add(auteur, BorderLayout.WEST);
			add(version, BorderLayout.EAST);
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
	private JLabel auteur;
	private JLabel version;

	}
