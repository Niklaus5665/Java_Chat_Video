import java.awt.BorderLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
		try
			{
			Application.init(new ApplicationSettings(InetAddress.getLocalHost().getHostName(), "PC", this));
			Application.getInstance().run();
			this.getContentPane().add(this.jPanVideo, BorderLayout.CENTER);
			this.getContentPane().setVisible(true);
			}
		catch (UnknownHostException e)
			{
			e.printStackTrace();
			}
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
	private JPanelMenu jPanMenu;
	private JPanelGlobal jPanVideo;

	}
