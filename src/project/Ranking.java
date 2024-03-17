package project;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ranking extends JFrame implements MouseListener {
	public static Ranking mInstance;
	private JPanel contentPane, panel;
	Connection con;
	JLabel lblBack;
	DefaultTableModel dtm;
	int mode;
	String level;
	JLabel headLabel;
	JRadioButton RadioEasy, RadioMedium, RadioHard;

	public static Ranking getInstance() {
		if (mInstance == null)
			mInstance = new Ranking(null);
		return mInstance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking(null);
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
	public Ranking(Integer difficulty) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				checkState();
			}

		});
		mode = difficulty;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 632);
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
		Image lbbg1 = new ImageIcon(ClassLoader.getSystemResource("Puzzle_House_Small_Top.png")).getImage();
		ImageIcon imgbg1 = new ImageIcon(lbbg1);
		Image lbbg3 = new ImageIcon(ClassLoader.getSystemResource("back.png")).getImage();
		ImageIcon imgbg3 = new ImageIcon(lbbg3);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbltopTitlePalace = new JLabel("Palace");
		lbltopTitlePalace.setForeground(new Color(117, 81, 57));
		lbltopTitlePalace.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 35));
		lbltopTitlePalace.setBounds(77, 40, 156, 76);
		contentPane.add(lbltopTitlePalace);

		JLabel lblTopTitlePuzzle = new JLabel("Puzzle");
		lblTopTitlePuzzle.setForeground(new Color(117, 81, 57));
		lblTopTitlePuzzle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 35));
		lblTopTitlePuzzle.setBounds(77, 0, 156, 76);
		contentPane.add(lblTopTitlePuzzle);

		JLabel lblTopLogo = new JLabel("");
		lblTopLogo.setIcon(imgbg1);
		lblTopLogo.setBounds(-23, -28, 118, 154);
		contentPane.add(lblTopLogo);

		panel = new JPanel();
		panel.setBounds(224, 40, 457, 60);
		contentPane.add(panel);
		panel.setLayout(null);

		headLabel = new JLabel();
		headLabel.setBounds(40, 11, 377, 38);
		headLabel.setBackground(SystemColor.controlHighlight);
		headLabel.setForeground(new Color(117, 81, 57));
		headLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));

		JPanel BGPanel = new JPanel();
		BGPanel.setBounds(10, 176, 893, 408);
		BGPanel.setBackground(new Color(117, 81, 57));
		contentPane.add(BGPanel);
		BGPanel.setLayout(null);

		JPanel BGPanel2 = new JPanel();
		BGPanel2.setBounds(10, 11, 873, 386);
		BGPanel.add(BGPanel2);
		BGPanel2.setLayout(null);

		lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(139, 69, 19));
		lblBack.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblBack.setBounds(791, 0, 91, 69);
		contentPane.add(lblBack);
		lblBack.addMouseListener(this);

		JLabel lblNewLabel_3_8 = new JLabel("");
		lblNewLabel_3_8.setIcon(imgbg3);
		lblNewLabel_3_8.setBounds(761, -17, 152, 104);
		contentPane.add(lblNewLabel_3_8);

		dtm = new DefaultTableModel();
		dtm.addColumn("No.");
		dtm.addColumn("Name");
		dtm.addColumn("Time");
		dtm.addColumn("Total Moves");
		dtm.addColumn("Difficulty");
		JTable jt = new JTable(dtm);
		JScrollPane JSPane = new JScrollPane(jt);
		JSPane.setBounds(2, 9, 869, 386);
		jt.getTableHeader().setForeground(Color.BLACK);
		jt.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		BGPanel2.add(JSPane);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < jt.getColumnCount(); i++) {
			jt.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// RadioButton for Ranking Choice
		RadioEasy = new JRadioButton("Easy");
		RadioEasy.setBackground(new Color(16577485));
		RadioEasy.setForeground(new Color(139, 69, 19));
		RadioEasy.setFont(new Font("Arial Black", Font.BOLD, 20));
		RadioEasy.setBounds(247, 133, 111, 23);
		contentPane.add(RadioEasy);
		RadioEasy.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					toShowData(3, "Easy", 0);
					changeText("Easy");
				}
			}
		});

		RadioMedium = new JRadioButton("Medium");
		RadioMedium.setForeground(new Color(139, 69, 19));
		RadioMedium.setFont(new Font("Arial Black", Font.BOLD, 20));
		RadioMedium.setBackground(new Color(252, 243, 205));
		RadioMedium.setBounds(376, 133, 143, 23);
		contentPane.add(RadioMedium);
		RadioMedium.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					toShowData(4, "Medium", 0);
					changeText("Medium");
				}
			}
		});

		RadioHard = new JRadioButton("Hard");
		RadioHard.setForeground(new Color(139, 69, 19));
		RadioHard.setFont(new Font("Arial Black", Font.BOLD, 20));
		RadioHard.setBackground(new Color(252, 243, 205));
		RadioHard.setBounds(542, 133, 111, 23);
		contentPane.add(RadioHard);
		RadioHard.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					toShowData(5, "Hard", 0);
					changeText("Hard");
				}
			}
		});

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(RadioEasy);
		radioGroup.add(RadioMedium);
		radioGroup.add(RadioHard);

	}

	private void addData(int no, String name, String time, int move, DefaultTableModel dtm, String mode) {
		Object[] row = { no, name, time, move, mode };
		dtm.addRow(row);

	}

	private void changeText(String smthg) {
		headLabel.setText("Highest Score Ranking" + "(" + smthg + ")");
		headLabel.revalidate();
		headLabel.repaint();
		panel.revalidate();
		panel.repaint();
		panel.add(headLabel);
	}

	private void checkState() {
		if (mode == 0 || mode == 3) {

			RadioEasy.setSelected(true);

		} else if (mode == 4) {

			RadioMedium.setSelected(true);

		} else if (mode == 5) {

			RadioHard.setSelected(true);

		}

	}

	private void toShowData(int i, String difficulty, int id) {
		try {
			con = new DataBaseConnection().getConnect();
			dtm.setRowCount(0);
			ResultSet rs;

			PreparedStatement pStatement = con
					.prepareStatement("select * from puzzletime where diffiuclty = ? order by time asc");
			pStatement.setInt(1, i);
			rs = pStatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String time = String.format("%02d:%02d", rs.getInt(3) / 60, rs.getInt(3) % 60);
					addData(++id, rs.getString(2), time, rs.getInt(4), dtm, difficulty);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public JFrame getFrameInstance() {
		return this;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (lblBack == e.getSource()) {
			this.setVisible(false);
			EasyMedim_Page.getInstance().getFrameInstance().setVisible(true);
			EasyMedim_Page.getInstance().getFrameInstance().setLocationRelativeTo(null);
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
		if (lblBack == e.getSource()) {
			lblBack.setForeground(new Color(193, 154, 107));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (lblBack == e.getSource()) {
			lblBack.setForeground(new Color(139, 69, 19));
		}
	}

}
