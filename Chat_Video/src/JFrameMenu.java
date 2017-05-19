import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JFrameMenu extends JFrame
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JFrameMenu()
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
		this.jPanMenu = new JPanelMenu(this);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(this.jPanMenu, BorderLayout.CENTER);
		}

	public void passerPanelVideo()
		{
		this.getContentPane().setVisible(false);
		this.getContentPane().remove(jPanMenu);
		this.jPanVideo = new JPanelVideo(this);
		this.getContentPane().add(this.jPanVideo, BorderLayout.CENTER);
		this.getContentPane().setVisible(true);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		//setSize(300, 200);
		//setResizable(false);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	public void setIp(String Ip)
		{
		this.Ip = Ip;
		}

	public void setPseudo(String Pseudo)
		{
		this.Pseudo = Pseudo;
		}

	public String getIp()
		{
		return this.Ip;
		}

	public String getPseudo()
		{
		return Pseudo;
		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private String Ip;
	private String Pseudo;
	// Tools
	JPanelMenu jPanMenu;
	JPanelVideo jPanVideo;

	}
