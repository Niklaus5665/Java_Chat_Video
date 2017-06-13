import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

import specification.Application_I;

public class JPanelChat extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelChat(Application_I application)
		{
		this.application = application;
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
		btnEnvoyerMessage = new JButton("Envoyer");
		txtAreaMessage = new JTextArea();
		txtSaisieUserMessage = new JTextField();
		DefaultCaret caret = (DefaultCaret)txtAreaMessage.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		txtAreaMessage.setEditable(false);
		scroll = new JScrollPane(txtAreaMessage);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jPanBot = new JPanel();
		try
			{
			try
				{
				imageTop = resize((getClass().getResource("background_chat.jpg").toURI()), widthPanelTop, heightPanelTop);
				}
			catch (URISyntaxException e)
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		jPanTop = new JPanel()
					{
					 @Override
					    protected void paintComponent(Graphics g) {
					        super.paintComponent(g);
					        g.drawImage(imageTop, 0, 0, this);
					    }
					};
		jSaisiePanel = new JPanel();

		JSplitPane splitPane = new JSplitPane()
			{

			private final int location = 100;
				{
				setDividerLocation(location);
				}

			@Override
			public int getDividerLocation()
				{
				return location;
				}

			@Override
			public int getLastDividerLocation()
				{
				return location;
				}
			};
		setLayout(new GridLayout());
		add(splitPane);
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(0);
		splitPane.setBottomComponent(jPanBot);
		splitPane.setTopComponent(jPanTop);

		jPanBot.setLayout(new BoxLayout(jPanBot, BoxLayout.Y_AXIS));
		jPanBot.add(scroll);
		scroll.setViewportView(txtAreaMessage);
		jPanBot.add(jSaisiePanel);

		jSaisiePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
		jSaisiePanel.setLayout(new BoxLayout(jSaisiePanel, BoxLayout.X_AXIS));

		jSaisiePanel.add(txtSaisieUserMessage);
		jSaisiePanel.add(btnEnvoyerMessage);

		}

	public void setTextArea(String text)
		{
		txtAreaMessage.setText(txtAreaMessage.getText() + "\n" + text);
		}

	private void control()
		{
		btnEnvoyerMessage.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// TODO Auto-generated method stub
				txtAreaMessage.setText(txtAreaMessage.getText() + "\n" + txtSaisieUserMessage.getText());
				try
					{
					application.setText(txtSaisieUserMessage.getText());
					}
				catch (RemoteException e1)
					{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			});
		}

	private void appearance()
		{
		Dimension dTextField = new Dimension(300, 20);
		txtSaisieUserMessage.setSize(dTextField);
		txtSaisieUserMessage.setPreferredSize(dTextField);
		txtSaisieUserMessage.setMinimumSize(dTextField);
		}

	 private static BufferedImage resize(URI uri, int scaledWidth, int scaledHeight)
	            throws IOException {
	        // reads input image
	        File inputFile = new File(uri);
	        BufferedImage inputImage = ImageIO.read(inputFile);

	        BufferedImage outputImage = new BufferedImage(scaledWidth,
	                scaledHeight, inputImage.getType());

	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();

	        return outputImage;
	    }

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JScrollPane scroll;
	private int heightPanelTop = 100;
	private int widthPanelTop = 400;

	private JPanel jPanBot;
	private JPanel jPanTop;
	private JPanel jSaisiePanel;
	private BufferedImage imageTop;
	private JTextArea txtAreaMessage;
	private JButton btnEnvoyerMessage;
	private JTextField txtSaisieUserMessage;
	private Application_I application;
	}
