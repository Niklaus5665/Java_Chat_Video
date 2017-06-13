
package webcam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

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
		//Partie notre caméra
		jPanelWebcam = new JPanelWebcam();
		jPanelCenter = new JPanel();
		jPanelWebcamBorder = new JPanel();
		BorderLayout borderLayoutSelfWebcam = new BorderLayout();
		jPanelWebcamBorder.setLayout(borderLayoutSelfWebcam);
		GridBagLayout layoutCenter = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jPanelCenter.setLayout(layoutCenter);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		jPanelWebcamBorder.add(jPanelWebcam, BorderLayout.CENTER);
		jPanelCenter.add(jPanelWebcamBorder, gbc);
		jPanelCenter.setBackground(Color.RED);

		//Partie bouton
		jPanelButton = new JPanel();

		btnMiroir = new JButton("Miroir");
		btn1 = new JButton("test1");
		btn2 = new JButton("Miroir");
		btn3 = new JButton("Miroir");
		btn4 = new JButton("Miroir");
		btn5 = new JButton("Déconnecter");
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		borderLayout.setVgap(20);
		add(jPanelButton, BorderLayout.SOUTH);
		jPanelButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
		jPanelButton.setLayout(new GridLayout(0, nombreButton, 10, 0));
		jPanelButton.add(btnMiroir);
		jPanelButton.add(btn1);
		jPanelButton.add(btn2);
		jPanelButton.add(btn3);
		jPanelButton.add(btn4);
		jPanelButton.add(btn5);

		//Partie liaison layout pour la superposition
		jPanAutreCamera = new JPanel();
		JPanel jPanCameraTest = new JPanel();

		LayoutManager overlay = new OverlayLayout(jPanCameraTest);
		jPanCameraTest.setLayout(overlay);
		jPanCameraTest.add(jPanAutreCamera);
		jPanCameraTest.add(jPanelCenter);
		BorderLayout borderLayoutAutreCamera = new BorderLayout();
		jPanAutreCamera.setLayout(borderLayoutAutreCamera);
		//jPanAutreCamera.add(jPanelWebcam,BorderLayout.CENTER);
		//Ajouter la caméra de l'autre
		jPanAutreCamera.setBackground(Color.GREEN);
		add(jPanCameraTest, BorderLayout.CENTER);

		}

	private void control()
		{
		// rien
		btn1.addComponentListener(new ComponentAdapter()
			{

			@Override
			public void componentResized(ComponentEvent e)
				{
				System.out.println(e.getComponent().getWidth());
				if (e.getComponent().getWidth() > changementIconeButton)
					{
					btn1.setText("Miroir");
					btn2.setText("test");
					btn3.setText("test");
					btn4.setText("test");
					btn5.setText("test");
					btnMiroir.setText("test");
					btnMiroir.setIcon(null);
					btn1.setIcon(null);
					btn2.setIcon(null);
					btn3.setIcon(null);
					btn4.setIcon(null);
					btn5.setIcon(null);
					}
				else
					{
					btnMiroir.setIcon(new ImageIcon(((new ImageIcon("img/btn_mirror.jpg").getImage().getScaledInstance(widthButton, heightButton, java.awt.Image.SCALE_SMOOTH)))));
					btn1.setIcon(new ImageIcon(((new ImageIcon("img/btn_mirror.png.jpg").getImage().getScaledInstance(widthButton, heightButton, java.awt.Image.SCALE_SMOOTH)))));
					btn2.setIcon(new ImageIcon(((new ImageIcon("img/background_chat.jpg").getImage().getScaledInstance(widthButton, heightButton, java.awt.Image.SCALE_SMOOTH)))));
					btn3.setIcon(new ImageIcon(((new ImageIcon("img/background_chat.jpg").getImage().getScaledInstance(widthButton, heightButton, java.awt.Image.SCALE_SMOOTH)))));
					btn4.setIcon(new ImageIcon(((new ImageIcon("img/background_chat.jpg").getImage().getScaledInstance(widthButton, heightButton, java.awt.Image.SCALE_SMOOTH)))));
					btn5.setIcon(new ImageIcon(((new ImageIcon("img/background_chat.jpg").getImage().getScaledInstance(widthButton, heightButton, java.awt.Image.SCALE_SMOOTH)))));
					btn1.setText("");
					btn2.setText("");
					btn3.setText("");
					btn4.setText("");
					btn5.setText("");
					btnMiroir.setText("");
					}
				}
			});

		jPanelCenter.addComponentListener(new ComponentAdapter()
			{

			@Override
			public void componentMoved(ComponentEvent e)
				{
				// TODO Auto-generated method stub
				d = e.getComponent().getSize();
				int h = (int)(d.getHeight() / 4);
				int w = (int)(d.getWidth() / 4);
				d = new Dimension(w, h);
				jPanelWebcamBorder.setMinimumSize(d);
				jPanelWebcamBorder.setMaximumSize(d);
				jPanelWebcamBorder.setPreferredSize(d);
				}

			@Override
			public void componentResized(ComponentEvent e)
				{
				// TODO Auto-generated method stub
				d = e.getComponent().getSize();
				int h = (int)(d.getHeight() / 4);
				int w = (int)(d.getWidth() / 4);
				d = new Dimension(w, h);
				jPanelWebcamBorder.setMinimumSize(d);
				jPanelWebcamBorder.setMaximumSize(d);
				jPanelWebcamBorder.setPreferredSize(d);
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

		d = new Dimension(jPanelCenter.getWidth(), jPanelCenter.getHeight());
		jPanelWebcamBorder.setMinimumSize(d);
		jPanelWebcamBorder.setMaximumSize(d);
		jPanelWebcamBorder.setPreferredSize(d);

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
	private Dimension d;
	private int nombreButton = 6;
	private int heightButton = 16;
	private int widthButton = 20;
	private int changementIconeButton = 90;
	private JPanel jPanAutreCamera;
	private JPanel jPanelCenter;
	private JPanel jPanelButton;
	private JPanelWebcam jPanelWebcam;

	private JPanel jPanelWebcamBorder;

	}
