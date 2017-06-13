package chat;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

import global.JPanelGlobal;
import specification.Application_I;

public class Application implements Application_I ,Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Application()
		{
		// Rien
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		System.out.println("[Application]:run");

		serverSide();
		clientSide();
		}

	@Override
	public void setText(String text)
		{
		// TODO Auto-generated method stub
		System.out.println("text send : " + text);
		jPanelGlobal.getjPanelChat().setTextArea(text);

		}

	@Override
	public void setImage(ImageIO image)
		{
		// TODO Auto-generated method stub
		System.out.println("image send :");
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized Application getInstance()
		{
		//Assert.assertTrue(applicationSettings != null);

		if (INSTANCE == null)
			{
			INSTANCE = new Application();
			}
		return INSTANCE;
		}

	/**
	 * Call once before getInstance
	 */
	public static void init(ApplicationSettings _applicationSettings)
		{
		applicationSettings = _applicationSettings;
		}

	public JPanelGlobal getJPanelGlobal()
		{
		return this.jPanelGlobal;
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Server			*|
	\*------------------------------*/

	private void serverSide()
		{
		try
			{
			RmiURL rmiURL = new RmiURL(applicationSettings.getExpediteur(), SettingsRMI.PC_PORT);

			RmiTools.shareObject(this, rmiURL);
			RmiTools.afficherAllShareObject(SettingsRMI.PC_PORT);
			}
		catch (RemoteException e)
			{
			System.err.println("[Application]:serverSide:share failed");
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*			  Client			*|
	\*------------------------------*/

	private void clientSide()
		{
		Application_I application = connect();
		work(application);
		}

	private Application_I connect()
		{
		try
			{
			long delayMs = 1000;
			int nbTentativeMax = 100;
			RmiURL rmiURL = new RmiURL(applicationSettings.getDestinataire(), InetAddress.getByName(applicationSettings.getServername()), SettingsRMI.PC_PORT);
			Application_I application = (Application_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayMs, nbTentativeMax);
			return application;
			}
		catch (UnknownHostException e)
			{
			System.err.println("[Application]:fail to reach host: " + e);
			e.printStackTrace();
			return null;
			}
		catch (RemoteException e)
			{
			System.err.println("[Application]: " + e);
			e.printStackTrace();
			return null;
			}
		}

	private void work(Application_I application)
		{
		this.jPanelGlobal = new JPanelGlobal(application, applicationSettings.getJFrameMenu());
		System.out.println(applicationSettings);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Application INSTANCE = null;
	private JPanelGlobal jPanelGlobal;
	private static ApplicationSettings applicationSettings;

	}
