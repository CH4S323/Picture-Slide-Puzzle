package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class EasyMedim_Page extends JFrame implements MouseListener {
	public static EasyMedim_Page mInstance;
	private JPanel contentPane;
	JLabel lblEasy, lblMedium, lblHard, Rankinglbl;

	public static EasyMedim_Page getInstance() {
		if (mInstance == null)
			mInstance = new EasyMedim_Page();
		return mInstance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EasyMedim_Page frame = new EasyMedim_Page();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EasyMedim_Page() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 637);
		try {
			setIconImage(ImageIO.read(new File("Image\\Puzzle_House.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBackground(new Color(16577485));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Image for this page
		Image lbbg = new ImageIcon(ClassLoader.getSystemResource("titleOneLevel.png")).getImage();
		ImageIcon imgbg = new ImageIcon(lbbg);
		Image lbbg1 = new ImageIcon(ClassLoader.getSystemResource("Puzzle_House_Small_Top.png")).getImage();
		ImageIcon imgbg1 = new ImageIcon(lbbg1);
		Image lbbg2 = new ImageIcon(ClassLoader.getSystemResource("PuzzleBG.png")).getImage();
		ImageIcon imgbg2 = new ImageIcon(lbbg2);
		Image lbbg3 = new ImageIcon(ClassLoader.getSystemResource("back.png")).getImage();
		ImageIcon imgbg3 = new ImageIcon(lbbg3);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(imgbg1);
		lblNewLabel.setBounds(-14, 11, 112, 87);
		contentPane.add(lblNewLabel);

		JLabel lbltopTitlePalace = new JLabel("Palace");
		lbltopTitlePalace.setForeground(new Color(117, 81, 57));
		lbltopTitlePalace.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 39));
		lbltopTitlePalace.setBounds(89, 40, 156, 76);
		contentPane.add(lbltopTitlePalace);

		JLabel lblTopTitlePuzzle = new JLabel("Puzzle");
		lblTopTitlePuzzle.setForeground(new Color(117, 81, 57));
		lblTopTitlePuzzle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 39));
		lblTopTitlePuzzle.setBounds(89, 0, 156, 76);
		contentPane.add(lblTopTitlePuzzle);

		lblEasy = new JLabel("Easy");
		lblEasy.setForeground(new Color(255, 239, 213));
		lblEasy.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblEasy.setBounds(163, 199, 91, 69);
		contentPane.add(lblEasy);
		lblEasy.addMouseListener(this);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(imgbg);
		lblNewLabel_1.setBounds(72, 196, 242, 87);
		contentPane.add(lblNewLabel_1);

		lblMedium = new JLabel("Medium");
		lblMedium.setForeground(new Color(255, 239, 213));
		lblMedium.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblMedium.setBounds(365, 274, 152, 69);
		contentPane.add(lblMedium);
		lblMedium.addMouseListener(this);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(imgbg);
		lblNewLabel_1_1.setBounds(304, 274, 242, 87);
		contentPane.add(lblNewLabel_1_1);

		lblHard = new JLabel("Hard");
		lblHard.setForeground(new Color(255, 239, 213));
		lblHard.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblHard.setBounds(632, 354, 91, 69);
		contentPane.add(lblHard);
		lblHard.addMouseListener(this);

		JLabel lblHaredBG = new JLabel("");
		lblHaredBG.setIcon(imgbg);
		lblHaredBG.setBounds(548, 349, 242, 87);
		contentPane.add(lblHaredBG);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(imgbg2);
		lblNewLabel_2.setBounds(533, 11, 91, 74);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(imgbg2);
		lblNewLabel_2_2.setBounds(838, 84, 91, 74);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(imgbg2);
		lblNewLabel_2_3.setBounds(758, 199, 91, 74);
		contentPane.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setIcon(imgbg2);
		lblNewLabel_2_4.setBounds(838, 349, 91, 74);
		contentPane.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setIcon(imgbg2);
		lblNewLabel_2_5.setBounds(807, 515, 91, 74);
		contentPane.add(lblNewLabel_2_5);

		JLabel lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.setIcon(imgbg2);
		lblNewLabel_2_6.setBounds(608, 109, 91, 74);
		contentPane.add(lblNewLabel_2_6);

		JLabel lblNewLabel_2_7 = new JLabel("");
		lblNewLabel_2_7.setIcon(imgbg2);
		lblNewLabel_2_7.setBounds(672, 486, 91, 74);
		contentPane.add(lblNewLabel_2_7);

		JLabel lblNewLabel_2_8 = new JLabel("");
		lblNewLabel_2_8.setIcon(imgbg2);
		lblNewLabel_2_8.setBounds(533, 542, 91, 74);
		contentPane.add(lblNewLabel_2_8);

		JLabel lblNewLabel_2_9 = new JLabel("");
		lblNewLabel_2_9.setIcon(imgbg2);
		lblNewLabel_2_9.setBounds(383, 556, 91, 74);
		contentPane.add(lblNewLabel_2_9);

		JLabel lblNewLabel_2_10 = new JLabel("");
		lblNewLabel_2_10.setIcon(imgbg2);
		lblNewLabel_2_10.setBounds(372, -20, 91, 74);
		contentPane.add(lblNewLabel_2_10);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(imgbg2);
		lblNewLabel_2_1.setBounds(720, 70, 91, 74);
		contentPane.add(lblNewLabel_2_1);

		Rankinglbl = new JLabel("Home");
		Rankinglbl.setForeground(new Color(139, 69, 19));
		Rankinglbl.setFont(new Font("Rockwell", Font.BOLD, 29));
		Rankinglbl.setBounds(780, 11, 91, 69);
		contentPane.add(Rankinglbl);
		Rankinglbl.addMouseListener(this);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(imgbg3);
		lblNewLabel_3.setBounds(746, -6, 152, 104);
		contentPane.add(lblNewLabel_3);

	}

	public JFrame getFrameInstance() {
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ChoosingPage cp;
		// Chanint to EasyMediumPage
		if (lblEasy == e.getSource()) {
			cp = new ChoosingPage(3);
			this.dispose();
			cp.setVisible(true);
			cp.setLocationRelativeTo(null);
		}
		if (lblMedium == e.getSource()) {
			cp = new ChoosingPage(4);
			this.dispose();
			cp.setVisible(true);
			cp.setLocationRelativeTo(null);
		}
		if (lblHard == e.getSource()) {
			cp = new ChoosingPage(5);
			this.dispose();
			cp.setVisible(true);
			cp.setLocationRelativeTo(null);
		}
		if (Rankinglbl == e.getSource()) {
			this.setVisible(false);
			StartPage ranking = new StartPage();
			ranking.setVisible(true);
			ranking.setLocationRelativeTo(null);
			this.dispose();

		}
		// BackAction

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (lblEasy == e.getSource()) {
			lblEasy.setForeground(new Color(193, 154, 107));
		}
		if (lblHard == e.getSource()) {
			lblHard.setForeground(new Color(193, 154, 107));
		}
		if (lblMedium == e.getSource()) {
			lblMedium.setForeground(new Color(193, 154, 107));
		}
		if (Rankinglbl == e.getSource()) {
			Rankinglbl.setForeground(new Color(255, 239, 213));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (lblEasy == e.getSource()) {
			lblEasy.setForeground(new Color(255, 239, 213));
		}
		if (lblEasy == e.getSource()) {
			lblEasy.setForeground(new Color(255, 239, 213));
		}
		if (lblHard == e.getSource()) {
			lblHard.setForeground(new Color(255, 239, 213));
		}
		if (lblMedium == e.getSource()) {
			lblMedium.setForeground(new Color(255, 239, 213));
		}
		if (Rankinglbl == e.getSource()) {
			Rankinglbl.setForeground(new Color(139, 69, 19));
		}
	}
}
