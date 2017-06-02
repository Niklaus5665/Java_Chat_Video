
public class ApplicationSettings
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public ApplicationSettings(String servername, String destinataire, JFrameMenu jFrameMenu)
		{
		this.jFrameMenu = jFrameMenu;
		this.servername = servername;
		this.destinataire = destinataire;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("ApplicationSettings [servername=");
		builder.append(this.servername);
		builder.append(", destinataire=");
		builder.append(this.destinataire);
		builder.append("]");
		return builder.toString();
		}
	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getServername()
		{
		return this.servername;
		}

	public String getDestinataire()
		{
		return this.destinataire;
		}

	public JFrameMenu getJFrameMenu()
		{
		return this.jFrameMenu;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//input
	private String servername;
	private String destinataire;
	private JFrameMenu jFrameMenu;
	}
