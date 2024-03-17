package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class StartPage extends JFrame implements MouseListener {

	private JPanel contentPane;
	JLabel lblExit,lblPlay,lblRanking;
	Ranking rank;
	EasyMedim_Page easyM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage frame = new StartPage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartPage() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 634);
		try {
			setIconImage(ImageIO.read(new File("Image\\Puzzle_House.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBackground(new Color(16577485));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Image for this page
				Image lbbg = new ImageIcon(ClassLoader.getSystemResource("titleOneLevel.png")).getImage();
				ImageIcon imgbg = new ImageIcon(lbbg);
				Image lbbg1 = new ImageIcon(ClassLoader.getSystemResource("Puzzle_House_Small_Top.png")).getImage();
				ImageIcon imgbg1 = new ImageIcon(lbbg1);
				Image lbbg2 = new ImageIcon(ClassLoader.getSystemResource("PuzzleBG.png")).getImage();
				ImageIcon imgbg2 = new ImageIcon(lbbg2);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlay = new JLabel("Play");
		lblPlay.setForeground(new Color(255, 239, 213));
		lblPlay.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblPlay.setBounds(404, 118, 91, 69);
		contentPane.add(lblPlay);
		lblPlay.addMouseListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setIcon(imgbg);
		lblNewLabel_1.setBounds(313, 115, 242, 87);
		contentPane.add(lblNewLabel_1);
		
		lblRanking = new JLabel("Ranking");
		lblRanking.setForeground(new Color(255, 239, 213));
		lblRanking.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblRanking.setBounds(374, 275, 147, 69);
		lblRanking.addMouseListener(this);
		contentPane.add(lblRanking);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(313, 275, 242, 87);
		lblNewLabel_1_1.setIcon(imgbg);
		contentPane.add(lblNewLabel_1_1);
		
		lblExit = new JLabel("Exit");
		lblExit.setForeground(new Color(255, 239, 213));
		lblExit.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblExit.setBounds(404, 435, 91, 69);
		lblExit.addMouseListener(this);
		contentPane.add(lblExit);
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(313, 435, 242, 87);
		lblNewLabel_1_1_1.setIcon(imgbg);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel topLogo = new JLabel("");
		topLogo.setBounds(-13, -1, 112, 87);
		topLogo.setIcon(imgbg1);
		contentPane.add(topLogo);
		
		JLabel lblTopTitlePuzzle = new JLabel("Puzzle");
		lblTopTitlePuzzle.setForeground(new Color(117, 81, 57));
		lblTopTitlePuzzle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 39));
		lblTopTitlePuzzle.setBounds(90, -12, 156, 76);
		contentPane.add(lblTopTitlePuzzle);
		
		JLabel lbltopTitlePalace = new JLabel("Palace");
		lbltopTitlePalace.setForeground(new Color(117, 81, 57));
		lbltopTitlePalace.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 39));
		lbltopTitlePalace.setBounds(90, 28, 156, 76);
		contentPane.add(lbltopTitlePalace);
		
		JLabel lblbg = new JLabel("");
		lblbg.setIcon(imgbg2);
		lblbg.setBounds(701, -1, 91, 74);
		contentPane.add(lblbg);
		
		JLabel lblbg_1 = new JLabel("");
		lblbg_1.setIcon(imgbg2);
		lblbg_1.setBounds(812, 96, 91, 74);
		contentPane.add(lblbg_1);
		
		JLabel lblbg_1_1 = new JLabel("");
		lblbg_1_1.setIcon(imgbg2);
		lblbg_1_1.setBounds(773, 243, 91, 74);
		contentPane.add(lblbg_1_1);
		
		JLabel lblbg_1_2 = new JLabel("");
		lblbg_1_2.setIcon(imgbg2);
		lblbg_1_2.setBounds(812, 388, 91, 74);
		contentPane.add(lblbg_1_2);
		
		JLabel lblbg_1_3 = new JLabel("");
		lblbg_1_3.setIcon(imgbg2);
		lblbg_1_3.setBounds(722, 512, 91, 74);
		contentPane.add(lblbg_1_3);
		
		JLabel lblbg_1_4 = new JLabel("");
		lblbg_1_4.setIcon(imgbg2);
		lblbg_1_4.setBounds(-11, 97, 91, 74);
		contentPane.add(lblbg_1_4);
		
		JLabel lblbg_1_5 = new JLabel("");
		lblbg_1_5.setIcon(imgbg2);
		lblbg_1_5.setBounds(68, 243, 91, 74);
		contentPane.add(lblbg_1_5);
		
		JLabel lblbg_1_6 = new JLabel("");
		lblbg_1_6.setIcon(imgbg2);
		lblbg_1_6.setBounds(8, 414, 91, 74);
		contentPane.add(lblbg_1_6);
		
		JLabel lblbg_1_7 = new JLabel("");
		lblbg_1_7.setIcon(imgbg2);
		lblbg_1_7.setBounds(102, 539, 91, 74);
		contentPane.add(lblbg_1_7);
		
		JLabel lblbg_1_4_1 = new JLabel("");
		lblbg_1_4_1.setIcon(imgbg2);
		lblbg_1_4_1.setBounds(245, -12, 91, 74);
		contentPane.add(lblbg_1_4_1);
		
		 easyM = new EasyMedim_Page();
		 rank = new Ranking(0);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(lblPlay==e.getSource()) {
			this.setVisible(false);
			easyM.setVisible(true);
			easyM.setLocationRelativeTo(null);
			
		}
		if(lblRanking==e.getSource()) {
			System.out.println("rank");
			this.setVisible(false);
			rank.setVisible(true);
			rank.setLocationRelativeTo(null);
		}
		if(lblExit==e.getSource()) {
			System.exit(1);
		}
		
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
		if(lblPlay==e.getSource()) {
			lblPlay.setForeground(new Color(193, 154, 107));
		}
		if(lblRanking==e.getSource()) {
			lblRanking.setForeground(new Color(193, 154, 107));
		}
		if(lblExit==e.getSource()) {
			lblExit.setForeground(new Color(193, 154, 107));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(lblPlay==e.getSource()) {
			lblPlay.setForeground(new Color(255, 239, 213));
		}
		if(lblRanking==e.getSource()) {
			lblRanking.setForeground(new Color(255, 239, 213));
		}
		if(lblExit==e.getSource()) {
			lblExit.setForeground(new Color(255, 239, 213));
		}
		
		
	}
}
