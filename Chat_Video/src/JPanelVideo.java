import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelVideo extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelVideo()
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
		jPanelWebcam = new JPanelWebcam();
		btnMiroir = new JButton("Miroir");
		btn1 = new JButton("test1");
		btn2 = new JButton("Miroir");
		btn3 = new JButton("Miroir");
		btn4 = new JButton("Miroir");
		btn5 = new JButton("Déconnecter");
		btn5.setIcon(new ImageIcon(((new ImageIcon("background_chat.jpg").getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)))));

		jPanBot = new JPanel();
		jPanTop = new JPanel();
		jPanelButton = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		borderLayout.setVgap(20);

		add(jPanelButton, BorderLayout.SOUTH);
		add(jPanelWebcam, BorderLayout.CENTER);
		jPanelButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
		jPanelButton.setLayout(new GridLayout(0, nombreButton, 10, 0));
		jPanelButton.add(btnMiroir);
		jPanelButton.add(btn1);
		jPanelButton.add(btn2);
		jPanelButton.add(btn3);
		jPanelButton.add(btn4);
		jPanelButton.add(btn5);
		jPanTop.setBackground(Color.GREEN);
		jPanBot.setBackground(Color.RED);
		try
			{
			master = ImageIO.read(new File("img/background_chat.jpg"));
			}
		catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

	private void control()
		{
		// rien
		btn1.addComponentListener(new ComponentAdapter()
			{

			@Override
			public void componentResized(ComponentEvent e)
				{
				JButton btn = (JButton)e.getComponent();
				Dimension size = btn.getSize();
				Insets insets = btn.getInsets();
				size.width -= insets.left + insets.right;
				size.height -= insets.top + insets.bottom;
				if (size.width > size.height)
					{
					size.width = -1;
					}
				else
					{
					size.height = -1;
					}

				Image scaled = master.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
				btn.setIcon(new ImageIcon(scaled));
				}

			});

		}

	private void appearance()
		{
		// rien
		btn1.setAlignmentX(CENTER_ALIGNMENT);
		btn2.setAlignmentX(CENTER_ALIGNMENT);
		btn3.setAlignmentX(CENTER_ALIGNMENT);
		btn4.setAlignmentX(CENTER_ALIGNMENT);
		btn5.setAlignmentX(CENTER_ALIGNMENT);

		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JButton btnMiroir;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private int nombreButton = 6;
	private JPanel jPanBot;
	private JPanel jPanTop;
	private JPanel jPanelButton;
	private Image master;
	private JPanelWebcam jPanelWebcam;

	}
