import java.awt.FlowLayout;

import javax.swing.JPanel;

import specification.Application_I;

public class JPanelGlobal extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelGlobal(JFrameMenu jFrameMenu)
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

		jPanelChat = new JPanelChat();
		jPanelInformationUser = new JPanelInformationUser(jFrameMenu);
		jPanelVideo = new JPanelVideo();
		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelVideo);
		add(jPanelInformationUser);
		add(jPanelChat);
		}

	private void control()
		{
		//Changement couleur, contraste, résolution, miroir, (Ecriture text sur video si le temps le permet), switch taille grand/petit
		// rien
		}

	private void appearance()
		{

		jFrameMenu.setResizable(true);
		jFrameMenu.setSize(700, 700);

		// rien
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JFrameMenu jFrameMenu;
	private JPanelChat jPanelChat;
	Application_I application;
	private JPanelInformationUser jPanelInformationUser;
	private JPanelVideo jPanelVideo;
	}
