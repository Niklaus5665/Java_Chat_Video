package global;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JPanel;

import chat.JPanelChat;
import specification.Application_I;
import webcam.JPanelVideo;

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
		jPanelInformation = new JPanelInformation();
		// Layout : Specification
			{
			BorderLayout borderlayout = new BorderLayout();
			setLayout(borderlayout);

			 borderlayout.setHgap(20);
			 borderlayout.setVgap(10);
			}

		// JComponent : add
		add(jPanelVideo,BorderLayout.CENTER);
		add(jPanelInformationUser,BorderLayout.NORTH);
		add(jPanelChat,BorderLayout.EAST);
		add(jPanelInformation,BorderLayout.SOUTH);
		}

	@Override
	public Insets getInsets() {
	   Insets normal = super.getInsets();
	   return new Insets(normal.top, normal.left + 15,
	   normal.bottom, normal.right + 15);
	}
	private void control()
		{
		//SnapShot, Changement couleur, contraste, résolution, miroir, (Ecriture text sur video si le temps le permet), switch taille grand/petit
		// rien
		}

	private void appearance()
		{

		jFrameMenu.setResizable(true);
		jFrameMenu.setSize(1100, 500);
		Dimension sizeWindows = new Dimension(900, 500);
		jFrameMenu.setMinimumSize(sizeWindows);

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
	private JPanelInformation jPanelInformation;
	}
