package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChoosingPage extends JFrame {
	public static ChoosingPage mInstance;
	private JPanel contentPane, PPanel;
	JLabel Add, imgFirst, imgSecond, imgThird, lblBack;
	private int size;

	JLabel image;
	ImageIcon imgbg;

//	 public static ChoosingPage getInstance() {
//	        if(mInstance == null) 
//	            mInstance = new ChoosingPage();
//	        return mInstance;
//	    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoosingPage frame = new ChoosingPage(null);

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
	public ChoosingPage(Integer mode) {
		size = mode;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 635);
		try {
			setIconImage(ImageIO.read(new File("Image\\Puzzle_House.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setLocation(-89, -407);
		contentPane.setBackground(new Color(16577485));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Image for this page
		Image lbbg = new ImageIcon(ClassLoader.getSystemResource("BkPiece.png")).getImage();
		imgbg = new ImageIcon(lbbg);
		Image lbbg1 = new ImageIcon(ClassLoader.getSystemResource("Puzzle_House_Small_Top.png")).getImage();
		ImageIcon imgbg1 = new ImageIcon(lbbg1);
		Image lbbg2 = new ImageIcon(ClassLoader.getSystemResource("PuzzleBG.png")).getImage();
		ImageIcon imgbg2 = new ImageIcon(lbbg2);
		Image lbbg3 = new ImageIcon(ClassLoader.getSystemResource("back.png")).getImage();
		ImageIcon imgbg3 = new ImageIcon(lbbg3);

		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(imgbg1);
		lblNewLabel.setBounds(-14, 11, 112, 87);
		contentPane.add(lblNewLabel);

//		// Customize Image for User
//		Add = new JLabel("Show more...");
//		Add.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 75));
//		Add.setForeground(new Color(255, 235, 205));
//		Add.setBounds(606, 416, 50, 76);
//		contentPane.add(Add);
//		Add.addMouseListener(new mouseCLicked());
//
//		JLabel lblNewLabel_1_3 = new JLabel("");
//		lblNewLabel_1_3.setIcon(imgbg);
//		lblNewLabel_1_3.setBounds(493, 348, 298, 210);
//		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(imgbg2);
		lblNewLabel_3_2.setBounds(801, 127, 93, 72);
		contentPane.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(imgbg2);
		lblNewLabel_3_3.setBounds(778, 288, 93, 72);
		contentPane.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(imgbg2);
		lblNewLabel_3_4.setBounds(554, 44, 93, 72);
		contentPane.add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_5 = new JLabel("");
		lblNewLabel_3_5.setIcon(imgbg2);
		lblNewLabel_3_5.setBounds(801, 486, 93, 72);
		contentPane.add(lblNewLabel_3_5);

		JLabel lblNewLabel_3_6 = new JLabel("");
		lblNewLabel_3_6.setIcon(imgbg2);
		lblNewLabel_3_6.setBounds(626, 549, 93, 72);
		contentPane.add(lblNewLabel_3_6);

		JLabel lblNewLabel_3_7 = new JLabel("");
		lblNewLabel_3_7.setIcon(imgbg2);
		lblNewLabel_3_7.setBounds(408, -15, 93, 72);
		contentPane.add(lblNewLabel_3_7);

		// Back Label
		lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(139, 69, 19));
		lblBack.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblBack.setBounds(780, 0, 91, 69);
		contentPane.add(lblBack);
		lblBack.addMouseListener(new mouseCLicked());

		JLabel lblNewLabel_3_8 = new JLabel("");
		lblNewLabel_3_8.setIcon(imgbg3);
		lblNewLabel_3_8.setBounds(750, -17, 152, 104);
		contentPane.add(lblNewLabel_3_8);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(imgbg2);
		lblNewLabel_3_1.setBounds(692, -15, 93, 72);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(imgbg2);
		lblNewLabel_3.setBounds(1569, -485, 93, 72);
		contentPane.add(lblNewLabel_3);

		PPanel = new JPanel(new GridLayout(0, 2));
		PPanel.setBounds(127, 127, 641, 378);
		contentPane.add(PPanel);

		showimg();

		JPanel oneTime = new JPanel();
		oneTime.setPreferredSize(new Dimension(298, 210));
		oneTime.setBackground(new Color(16577485));
		oneTime.setLayout(null);

		Add = new JLabel();
		try {
			Add.setIcon(new ImageIcon(resizeImage(ImageIO.read(new File("Image\\seeMore.png")), 221, 140)));
			Add.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 50));
			Add.setForeground(new Color(255, 235, 205));
			Add.setBounds(37, 35, 221, 140);
			Add.addMouseListener(new mouseCLicked());
			oneTime.add(Add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel oneTimeBG = new JLabel("");
		oneTimeBG.setIcon(imgbg);
		oneTimeBG.setBounds(10, 0, 298, 210);
		oneTime.add(oneTimeBG);

		PPanel.add(oneTime);

	}

	public JFrame getFrameInstance() {
		return this;
	}

	private void showimg() {

		try {
			Connection con = new DataBaseConnection().getConnect();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from imagetable order by playcount desc limit 3");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				try {
					BufferedImage newImage = resizeImage(ImageIO.read(new File(name)), 221, 140);
					toShowImage(newImage, name);

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private BufferedImage resizeImage(BufferedImage old, int width, int height) {
		BufferedImage resize = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resize.createGraphics();
		g2d.drawImage(old, 0, 0, width, height, null);
		g2d.dispose();
		return resize;
	}

	private void toShowImage(BufferedImage img, String name) {
		JPanel single = new JPanel();
		single.setPreferredSize(new Dimension(298, 210));
		single.setBackground(new Color(16577485));
		single.setLayout(null);

		image = new JLabel("");
		image.setIcon(new ImageIcon(img));
		image.setBounds(37, 35, 221, 140);
		image.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				To update the playcount
				try {
					Connection con = new DataBaseConnection().getConnect();
					Statement s = con.createStatement();

					PreparedStatement selectPs = con
							.prepareStatement("select imgID, playcount from imagetable where imgName = ?");
					selectPs.setString(1, name);
					ResultSet resultSet = selectPs.executeQuery();

					if (resultSet.next()) {
						int imgID = resultSet.getInt("imgID");
						int playcount = resultSet.getInt("playcount");

						PreparedStatement updatePs = con
								.prepareStatement("update imagetable set playcount = ? where imgID = ?");
						updatePs.setInt(1, playcount + 1);
						updatePs.setInt(2, imgID);
						updatePs.executeUpdate();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				PlayPage pP = new PlayPage(size, name);
				dispose();
				pP.setVisible(true);
				pP.setLocationRelativeTo(null);
			}
		});
		single.add(image);

		JLabel BGround = new JLabel("");
		BGround.setIcon(imgbg);
		BGround.setBounds(10, 0, 298, 210);
		single.add(BGround);

		single.revalidate();
		single.repaint();

		PPanel.add(single);

	}

	private class mouseCLicked extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			PlayPage pP;
			if (Add == e.getSource()) {
				ShowPhoto SPhoto = new ShowPhoto(size);
				dispose();
				SPhoto.setVisible(true);
				SPhoto.setLocationRelativeTo(null);
			}

			if (lblBack == e.getSource()) {
				setVisible(false);
				lblBack.setForeground(new Color(193, 154, 107));
				EasyMedim_Page.getInstance().getFrameInstance().setVisible(true);
				EasyMedim_Page.getInstance().getFrameInstance().setLocationRelativeTo(null);
			}

		}

		public void mouseEntered(MouseEvent e) {

		}

	}
}
/*
 * lblLoginTitle.setIcon(new ImageIcon("")); Image LoginTilteimg =new
 * ImageIcon(ClassLoader.getSystemResource("TitleLogin.png")).getImage().
 * getScaledInstance(100, 100,Image.SCALE_DEFAULT); ImageIcon LoginTitleIcon =
 * new ImageIcon(LoginTilteimg);
 */
