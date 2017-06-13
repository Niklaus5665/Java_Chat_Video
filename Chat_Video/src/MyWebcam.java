
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

/**
 * Image acquiring via Webcam-capture api (http://webcam-capture.sarxos.pl/)
 * @author dany.chea
 *
 */
public class MyWebcam
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public MyWebcam()
		{
		this.webcam = createWebcam();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public BufferedImage getImageWebcam()
		{
		return webcam.getImage();

		}

	public static Webcam createWebcam()
		{
		Webcam webcam = Webcam.getDefault();
		Dimension resolutionVoulue = new Dimension(640, 480);
		Dimension[] tabResolutionAlternative = new Dimension[] { resolutionVoulue, WebcamResolution.HD720.getSize(), WebcamResolution.VGA.getSize() };
		// Completer au besoin le tableau
		// Si la résolution voulue n’est supportée par la caméra,
		// l’API essaie de trouver le meilleur compromis entre les
		// résolutions supportées par la webcam et les résolutions
		// alternatives.
		webcam.setCustomViewSizes(tabResolutionAlternative);
		webcam.setViewSize(resolutionVoulue);
		webcam.open();
		return webcam;

		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	public Webcam webcam;
	}
