import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		
		//changed the bottom border color to white as I couldn't read the text at all when it was blue
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		//changed title to top 5 detox/wellness destinations slideshow
		setTitle("Top 5 Detox/Wellness Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			//added image for destination #1
			//image published by Borkar Pranil @ https://commons.wikimedia.org/wiki/File:Himalayas_in_India.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/himalayas.jpg") + "'</body></html>";
		} else if (i==2){
			//added image for destination #2
			//image published by Diego Delso @ https://commons.wikimedia.org/wiki/File:Embalse_de_Guadalest,_Alicante,_Espa%C3%B1a,_2023-01-21,_DD_24.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/alicante.jpg") + "'</body></html>";
		} else if (i==3){
			//added image for destination #3
			//image published by Ted Moravec @ https://commons.wikimedia.org/wiki/File:Morning_in_Tuscany_(52388313403).jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/tuscany_morning.jpg") + "'</body></html>";
		} else if (i==4){
			//added image for destination #4
			//image published by Vyacheslav Argenberg @ https://commons.wikimedia.org/wiki/File:Karst_landscape_of_Cheow_Lan_Lake,_Thailand.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/thailand.jpg") + "'</body></html>";
		} else if (i==5){
			//added image for destination #5
			//image published by Larry D. Moore @ https://commons.wikimedia.org/wiki/File:Lake_austin_2005.jpg


			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/lake_austin.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			//added text for Himalayas, India
			text = "<html><body><font size='5'>#1 The Himalayas, India.</font> <br>Ananda In the Himalayas is an award winning luxory destination spa.</body></html>";
		} else if (i==2){
			//added text for Alicante, Spain
			text = "<html><body><font size='5'>#2 Alicante, Spain.</font> <br>Come to the SHA Wellness Clinic, one of Europe's top wellness spas.</body></html>";
		} else if (i==3){
			//added text for tuscany, Italy
			text = "<html><body><font size='5'>#3 Tuscany, Italy.</font> <br>Visit Vegan Agrivilla i pini to recharge while enjoying the Plant based farm restaurant.</body></html>";
		} else if (i==4){
			//Added text for Surat Thani, Thailand
			text = "<html><body><font size='5'>#4 Surat Thani, Thailnd.</font> <br>Expericne Kamalaya Wellness Sanctuary and Holistic Spa during a visit to Thailand. </body></html>";
		} else if (i==5){
			//Added text for Austin, Texas
			text = "<html><body><font size='5'>#5 Austin, Texas.</font> <br> Come to Lake, Austin and check out The Lake Austin Spa Resort.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}