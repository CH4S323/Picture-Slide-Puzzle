package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Warning;

public class ShowingScore extends JFrame implements MouseListener {

	private JPanel LoginContentPane;
	JLabel lblSave,lblPlayAgain,lblMenu;
	private int size, time1, count1;
	private String imageString;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowingScore frame = new ShowingScore(null, null, null, null);
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
	public ShowingScore(Integer time, Integer move, Integer grid, String icon) {
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                setLocationRelativeTo(null);
            }
        });
		size = grid;
		imageString = icon;
		time1 = time;
		count1 = move;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 642);
		try {
			setIconImage(ImageIO.read(new File("Image\\Puzzle_House.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginContentPane = new JPanel();
		LoginContentPane.setBackground(new Color(16577485));
		LoginContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Image for this page
		Image lbbg = new ImageIcon(ClassLoader.getSystemResource("TitleLoginSmall.png")).getImage();
		ImageIcon imgbg = new ImageIcon(lbbg);
		Image lbbg1 = new ImageIcon(ClassLoader.getSystemResource("Puzzle_House_Small_Top.png")).getImage();
		ImageIcon imgbg1 = new ImageIcon(lbbg1);
		Image lbbg2 = new ImageIcon(ClassLoader.getSystemResource("PuzzleBG.png")).getImage();
		ImageIcon imgbg2 = new ImageIcon(lbbg2);
		Image lbbg3 = new ImageIcon(ClassLoader.getSystemResource("login.png")).getImage();
		ImageIcon imgbg3 = new ImageIcon(lbbg3);
		Image lbbg4 = new ImageIcon(ClassLoader.getSystemResource("titleOneLevel.png")).getImage();
		ImageIcon imgbg4 = new ImageIcon(lbbg4);

		setContentPane(LoginContentPane);
		LoginContentPane.setLayout(null);
		
		JLabel lblMovement = new JLabel();
		lblMovement.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovement.setText("Total Moves : " + move);
		lblMovement.setForeground(new Color(238, 232, 170));
		lblMovement.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 21));
		lblMovement.setBounds(388, 211, 173, 97);
		LoginContentPane.add(lblMovement);
		
		JLabel lblTopLogo = new JLabel("");
		lblTopLogo.setIcon(imgbg1);
		lblTopLogo.setBounds(0, -18, 118, 154);
		LoginContentPane.add(lblTopLogo);
		
		JLabel lblTopTitlePuzzle = new JLabel("Puzzle");
		lblTopTitlePuzzle.setForeground(new Color(7688505));
		lblTopTitlePuzzle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 39));
		lblTopTitlePuzzle.setBounds(113, 0, 156, 76);
		LoginContentPane.add(lblTopTitlePuzzle);
		
		JLabel lbltopTitlePalace = new JLabel("Palace");
		lbltopTitlePalace.setForeground(new Color(117, 81, 57));
		lbltopTitlePalace.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 39));
		lbltopTitlePalace.setBounds(113, 42, 156, 76);
		LoginContentPane.add(lbltopTitlePalace);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(imgbg2);
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 39));
		lblNewLabel.setBounds(796, -18, 131, 97);
		LoginContentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 39));
		lblNewLabel_2.setBounds(796, 0, 131, 97);
		LoginContentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(imgbg2);
		lblNewLabel_3.setBounds(845, 122, 92, 81);
		LoginContentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(imgbg2);
		lblNewLabel_3_1.setBounds(757, 230, 131, 81);
		LoginContentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(imgbg2);
		lblNewLabel_3_1_1.setBounds(655, -18, 131, 81);
		LoginContentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setIcon(imgbg2);
		lblNewLabel_3_1_1_1.setBounds(685, 370, 131, 81);
		LoginContentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("");
		lblNewLabel_3_1_1_2.setIcon(imgbg2);
		lblNewLabel_3_1_1_2.setBounds(833, 413, 131, 81);
		LoginContentPane.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_1_1_2_1_1 = new JLabel("");
		lblNewLabel_3_1_1_2_1_1.setIcon(imgbg2);
		lblNewLabel_3_1_1_2_1_1.setBounds(-24, 141, 131, 81);
		LoginContentPane.add(lblNewLabel_3_1_1_2_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_2 = new JLabel("");
		lblNewLabel_3_1_1_2_1_2.setIcon(imgbg2);
		lblNewLabel_3_1_1_2_1_2.setBounds(75, 230, 131, 81);
		LoginContentPane.add(lblNewLabel_3_1_1_2_1_2);
		
		JLabel lblNewLabel_3_1_1_2_1_3 = new JLabel("");
		lblNewLabel_3_1_1_2_1_3.setIcon(imgbg2);
		lblNewLabel_3_1_1_2_1_3.setBounds(-24, 355, 131, 81);
		LoginContentPane.add(lblNewLabel_3_1_1_2_1_3);
		
		JLabel lblNewLabel_3_1_1_2_1_4 = new JLabel("");
		lblNewLabel_3_1_1_2_1_4.setIcon(imgbg2);
		lblNewLabel_3_1_1_2_1_4.setBounds(32, 558, 102, 76);
		LoginContentPane.add(lblNewLabel_3_1_1_2_1_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("High Score");
		lblNewLabel_1_1.setForeground(new Color(238, 232, 170));
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(409, 103, 131, 97);
		LoginContentPane.add(lblNewLabel_1_1);
		
		JLabel lblLoginTitle = new JLabel("");
		lblLoginTitle.setIcon(imgbg);
		lblLoginTitle.setBounds(289, 73, 366, 175);
		LoginContentPane.add(lblLoginTitle);
		
		JLabel lblTimer = new JLabel();
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setText(String.format("Duration : %02d:%02d", time/60, time%60));
		lblTimer.setForeground(new Color(238, 232, 170));
		lblTimer.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 21));
		lblTimer.setBounds(387, 272, 186, 97);
		LoginContentPane.add(lblTimer);
		
		JLabel lblSaveYourScore = new JLabel("Well Done");
		lblSaveYourScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveYourScore.setForeground(new Color(238, 232, 170));
		lblSaveYourScore.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 19));
		lblSaveYourScore.setBounds(420, 346, 102, 70);
		LoginContentPane.add(lblSaveYourScore);
		
		JLabel EnterForName = new JLabel("");
		EnterForName.setIcon(imgbg3);
		EnterForName.setBounds(348, 225, 275, 209);
		LoginContentPane.add(EnterForName);
		
		lblSave = new JLabel("Save");
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setForeground(new Color(255, 239, 213));
		lblSave.setFont(new Font("Rockwell", Font.BOLD, 28));
		lblSave.setBounds(148, 484, 91, 69);
		LoginContentPane.add(lblSave);
		lblSave.addMouseListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(57, 481, 242, 87);
		lblNewLabel_1.setIcon(imgbg4);
		LoginContentPane.add(lblNewLabel_1);
		
		lblPlayAgain = new JLabel("Play Again");
		lblPlayAgain.setForeground(new Color(255, 239, 213));
		lblPlayAgain.setFont(new Font("Rockwell", Font.BOLD, 28));
		lblPlayAgain.setBounds(660, 487, 156, 69);
		LoginContentPane.add(lblPlayAgain);
		lblPlayAgain.addMouseListener(this);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBounds(599, 481, 242, 87);
		lblNewLabel_1_2.setIcon(imgbg4);
		LoginContentPane.add(lblNewLabel_1_2);
		
		lblMenu = new JLabel("Home");
		lblMenu.setForeground(new Color(255, 239, 213));
		lblMenu.setFont(new Font("Rockwell", Font.BOLD, 28));
		lblMenu.setBounds(426, 484, 113, 69);
		LoginContentPane.add(lblMenu);
		lblMenu.addMouseListener(this);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setBounds(331, 481, 242, 87);
		lblNewLabel_1_2_1.setIcon(imgbg4);
		LoginContentPane.add(lblNewLabel_1_2_1);
		
		
		
		/*lblLoginTitle.setIcon(new ImageIcon(""));
		Image LoginTilteimg =new ImageIcon(ClassLoader.getSystemResource("TitleLogin.png")).getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon LoginTitleIcon = new ImageIcon(LoginTilteimg);*/
	}

	public void checkUName(JTextField name,Object holder) {
		if(JOptionPane.showConfirmDialog(null, holder,"Enter User Name",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
			if (name != null && !name.getText().isEmpty()) {
				Ranking ranking = new Ranking(size);
				store(name.getText());
				this.dispose();
				ranking.setVisible(true);
				ranking.setLocationRelativeTo(null);

			} else {
				JOptionPane.showMessageDialog(this, "Enter Name to save the High Score");
				checkUName(name, holder);
			}
		}
	}
	
	private void store(String name) {
		try (Connection con = new DataBaseConnection().getConnect()) {
			String insertQuery = "insert into puzzletime values(null, ?, ?, ?, ?)";
			try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
				pst.setString(1, name);
				pst.setInt(2, time1);
				pst.setInt(3, count1);
				pst.setInt(4, size);
				pst.executeUpdate();
			}

		} catch (NumberFormatException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == lblSave) {
			JTextField name = new JTextField();
			Object[] namefield = {"User Name : ",name};
			checkUName(name, namefield);

		}
		if(e.getSource()== lblPlayAgain) {
			
			PlayPage playPage = new PlayPage(size, imageString);
			this.dispose();
			playPage.setVisible(true);
			playPage.setLocationRelativeTo(null);
		}
		if(lblMenu==e.getSource()) {
			if(JOptionPane.showConfirmDialog(null, "You have not save the score yet, Do u want to go to Menu", "Check", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {				
				StartPage st = new StartPage();
				this.dispose();
				st.setVisible(true);
				st.setLocationRelativeTo(null);
			}
		}
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(lblSave==e.getSource()) {
			lblSave.setForeground(new Color(193, 154, 107));
		}
		if(lblPlayAgain==e.getSource()) {
			lblPlayAgain.setForeground(new Color(193, 154, 107));
		}
		if(lblMenu==e.getSource()) {
			lblMenu.setForeground(new Color(193, 154, 107));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(lblSave==e.getSource()) {
			lblSave.setForeground(new Color(255, 239, 213));
//			Ranking ranking = new Ranking();
//			this.dispose();
//			ranking.setVisible(true);
		}
		if(lblPlayAgain==e.getSource()) {
			lblPlayAgain.setForeground(new Color(255, 239, 213));
//			PlayPage playPage = new PlayPage(size, imageString);
//			this.dispose();
//			playPage.setVisible(true);
		}
		if(lblMenu==e.getSource()) {
			lblMenu.setForeground(new Color(255, 239, 213));
		}
		
	}
}
