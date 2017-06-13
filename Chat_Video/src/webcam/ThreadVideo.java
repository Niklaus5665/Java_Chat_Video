package webcam;


import java.awt.image.BufferedImage;

public class ThreadVideo implements Runnable
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ThreadVideo(JPanelWebcam jPanelWebcam)
		{
		this.myWebcam=new MyWebcam();
		this.jPanelWebcam=jPanelWebcam;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		while(true)
			{
			BufferedImage image = myWebcam.getImageWebcam();
			jPanelWebcam.setImagePanel(image);
			}

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private MyWebcam myWebcam;
	private JPanelWebcam jPanelWebcam;

	}

