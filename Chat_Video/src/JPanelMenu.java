
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JPanelMenu extends JPanel
	{

	String recupIp;
	String recupPseudo;

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelMenu(JFrameMenu jFrameMenu)
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
		jFrameMenu.setSize(300, 200);
		jFrameMenu.setResizable(false);

		// JComponent : Instanciation
		this.btnValider = new JButton("Connection");
		this.btnQuitter = new JButton("Quitter");
		this.txtfIp = new JTextField();
		this.txtfPseudo = new JTextField();
		lblAddresseIp = new JLabel("Adresse Ip : ");
		lblPseudo = new JLabel("Pseudo : ");
		lblNotreIp = new JLabel("Votre adresse IP : ");

		GridBagLayout gridBagLayout = new GridBagLayout();

		setLayout(gridBagLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST; //ancre a gauche des cellules les composants
		c.insets = new Insets(0, 0, 10, 30);

		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		add(this.lblAddresseIp, c);

		c.gridx = 1;
		c.gridy = 0;
		add(this.txtfIp, c);
		c.gridx = 0;
		c.gridy = 1;
		add(this.lblPseudo, c);
		c.gridx = 1;
		c.gridy = 1;
		add(this.txtfPseudo, c);
		c.gridx = 0;
		c.gridy = 2;
		add(this.lblNotreIp, c);
		c.gridx = 1;
		c.gridy = 2;
		add(this.btnValider, c);
		c.gridx = 1;
		c.gridy = 3;
		add(this.btnQuitter, c);

		}

	private void control()
		{
		// rien
		btnQuitter.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// TODO Auto-generated method stub
				System.exit(0);
				}
			});
		btnValider.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// TODO Auto-generated method stub
				recupIp = txtfIp.getText();
				recupPseudo = txtfPseudo.getText();
				jFrameMenu.setIp(recupIp);
				jFrameMenu.setPseudo(recupPseudo);
				jFrameMenu.passerPanelVideo();
				}
			});
		}

	public String getIp()
		{
		return recupIp;
		}

	public String getPseudo()
		{
		return recupPseudo;
		}

	private void appearance()
		{
		// rien
		//TextField
		Dimension dTextField = new Dimension(100, 20);
		txtfIp.setSize(dTextField);
		txtfIp.setPreferredSize(dTextField);
		txtfIp.setMinimumSize(dTextField);
		txtfIp.setMaximumSize(dTextField);
		txtfIp.setHorizontalAlignment(SwingConstants.LEFT);
		txtfPseudo.setSize(dTextField);
		txtfPseudo.setPreferredSize(dTextField);
		txtfPseudo.setMinimumSize(dTextField);
		txtfPseudo.setMaximumSize(dTextField);

		//Marge des label
		//		lblAddresseIp.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
		//		lblNotreIp.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
		//		lblPseudo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

		//Taille des boutons
		btnQuitter.setSize(dTextField);
		btnQuitter.setPreferredSize(dTextField);
		btnQuitter.setMinimumSize(dTextField);
		btnQuitter.setMaximumSize(dTextField);

		btnValider.setSize(dTextField);
		btnValider.setPreferredSize(dTextField);
		btnValider.setMinimumSize(dTextField);
		btnValider.setMaximumSize(dTextField);

		//POUR LES TEST !!! A SUPPRIMER PLUS TARD
		txtfIp.setText("192.168.19.19");
		txtfPseudo.setText("PseudoTest");
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JLabel lblAddresseIp;
	private JLabel lblPseudo;
	private JLabel lblNotreIp;

	private JButton btnValider;
	private JButton btnQuitter;
	private JTextField txtfIp;
	private JTextField txtfPseudo;

	private JFrameMenu jFrameMenu;
	}
