import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

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
		//		jPanTop = new JPanel()
		//			{
		//			@Override
		//			public void paintComponent(Graphics g)
		//				{
		//				try
		//					{
		//					g.drawImage(ImageIO.read(getClass().getResource("/img/background_chat.jpg")), 0, 0, null);
		//					}
		//				catch (IOException e)
		//					{
		//					// TODO Auto-generated catch block
		//					e.printStackTrace();
		//					}
		//				super.paintComponent(g);
		//				}
		//			};
		jPanTop = new JPanel();
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
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT); // we want it to split the window verticaly
		splitPane.setDividerLocation(0); // the initial position of the divider is 200 (our window is 400 pixels high)
		splitPane.setBottomComponent(jPanBot); // and at the bottom we want our "bottomPanel"
		splitPane.setTopComponent(jPanTop); // and at the bottom we want our "bottomPanel"

		jPanBot.setLayout(new BoxLayout(jPanBot, BoxLayout.Y_AXIS)); // BoxLayout.Y_AXIS will arrange the content vertically

		jPanBot.add(scroll); // first we add the scrollPane to the bottomPanel, so it is at the top
		scroll.setViewportView(txtAreaMessage); // the scrollPane should make the textArea scrollable, so we define the viewport
		jPanBot.add(jSaisiePanel); // then we add the inputPanel to the bottomPanel, so it under the scrollPane / textArea

		jSaisiePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75)); // we set the max height to 75 and the max width to (almost) unlimited
		jSaisiePanel.setLayout(new BoxLayout(jSaisiePanel, BoxLayout.X_AXIS)); // X_Axis will arrange the content horizontally

		jSaisiePanel.add(txtSaisieUserMessage); // left will be the textField
		jSaisiePanel.add(btnEnvoyerMessage); // and right the "send" button

		}

	public void setTextArea(String text)
		{
		txtAreaMessage.setText(txtAreaMessage.getText() + "\n" + text);

		}

	private void control()
		{
		// rien
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

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JScrollPane scroll;
	private JPanel jPanBot;
	private JPanel jPanTop;

	private JPanel jSaisiePanel;
	private JSplitPane splitPane;
	private JTextArea txtAreaMessage;
	private JButton btnEnvoyerMessage;
	private JTextField txtSaisieUserMessage;
	private Application_I application;
	}
