import java.awt.BorderLayout;

import javax.swing.JPanel;

import specification.Application_I;

public class JPanelGlobal extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelGlobal(Application_I application, JFrameMenu jFrameMenu)
		{
		this.application = application;
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

	public JPanelChat getjPanelChat()
		{
		return this.jPanelChat;
		}
	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation

		jPanelChat = new JPanelChat(application);
		jPanelInformationUser = new JPanelInformationUser(jFrameMenu);
		jPanelVideo = new JPanelVideo();
		jPanelButtonVideo = new JPanelButtonVideo();
		// Layout : Specification
			{
			BorderLayout borderlayout = new BorderLayout();
			setLayout(borderlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelVideo,BorderLayout.WEST);
		add(jPanelInformationUser,BorderLayout.NORTH);
		add(jPanelChat,BorderLayout.EAST);
		add(jPanelButtonVideo,BorderLayout.SOUTH);
		}

	private void control()
		{
		//SnapShot, Changement couleur, contraste, résolution, miroir, (Ecriture text sur video si le temps le permet), switch taille grand/petit
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
	private Application_I application;
	private JPanelInformationUser jPanelInformationUser;
	private JPanelVideo jPanelVideo;
	private JPanelButtonVideo jPanelButtonVideo;
	}
