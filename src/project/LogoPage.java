package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class LogoPage extends JFrame {

	private JPanel contentPane;
	static JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LogoPage frame = new LogoPage();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		try {
			for(int i=0;i<=70;i++) {
				Thread.sleep(40);
				progressBar.setValue(i);
				if(i==70) {
					StartPage start = new StartPage();
					start.setVisible(true);
					start.setLocationRelativeTo(null);
					frame.setVisible(false);
				}
			}
		} catch (Exception e) {
		e.printStackTrace();  
		}
	}

	/**
	 * Create the frame.
	 */
	public LogoPage() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 640);
		try {
			setIconImage(ImageIO.read(new File("Image\\Puzzle_House.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Image
		Image lbbg1 = new ImageIcon(ClassLoader.getSystemResource("Puzzle_House.png")).getImage();
		ImageIcon imgbg1 = new ImageIcon(lbbg1);
		Image lbbg2 = new ImageIcon(ClassLoader.getSystemResource("ezgif.com-resize.gif")).getImage();
		ImageIcon imgbg2 = new ImageIcon(lbbg2);


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LblPalaceLogo = new JLabel("Palace");
		LblPalaceLogo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 99));
		LblPalaceLogo.setForeground(new Color(255, 255, 0));
		LblPalaceLogo.setBounds(442, 317, 356, 104);
		contentPane.add(LblPalaceLogo);
		
		JLabel LblPuzzleLogo = new JLabel("Puzzle");
		LblPuzzleLogo.setForeground(Color.YELLOW);
		LblPuzzleLogo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 99));
		LblPuzzleLogo.setBounds(145, 229, 331, 104);
		contentPane.add(LblPuzzleLogo);
		
		JLabel lblLogoHome = new JLabel("");
		lblLogoHome.setIcon(imgbg1);
		lblLogoHome.setBounds(176, 108, 622, 388);
		contentPane.add(lblLogoHome);
		
		JLabel lblLoadingLogo = new JLabel("");
		lblLoadingLogo.setIcon(imgbg2);
		lblLoadingLogo.setBounds(401, 496, 103, 133);
		contentPane.add(lblLoadingLogo);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(53, 397, 146, 9);
		
		
		
		
	}
}
