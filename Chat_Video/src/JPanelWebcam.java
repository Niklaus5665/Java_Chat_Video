
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class JPanelWebcam extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelWebcam()
		{
		image=new BufferedImage(10, 10, BufferedImage.TYPE_3BYTE_BGR);
		ThreadVideo threadVideo = new ThreadVideo(this);
		new Thread(threadVideo).start();

		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;
		AffineTransform trasformInitial = g2d.getTransform(); // Concerne uniquement le repère de math
		drawVideo(g2d);
		g2d.setTransform(trasformInitial);
		}

	public void drawVideo(Graphics2D g2d)
		{

		g2d.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	public void setImagePanel(BufferedImage image)
		{
		this.image = image;

		repaint();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools

	public BufferedImage image;
	public Boolean isMirrored;


	}
