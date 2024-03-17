package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.sql.*;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

public class PlayPage extends JFrame implements MouseListener {

	private JPanel contentPane, PlayingBGPanel, puzzlePanel;
	private BufferedImage oldImage, newImage;
	private ArrayList<JLabel> piecesList, originalList;
	private int Gsize;
	private String Gimage;
	private Point selectPiece;
	private JLabel tempPiece, Moves, playtimeLabel, lblBack;
	private int seconds;
	private int count = 0;
	private Timer timer;
	String userInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayPage frame = new PlayPage(null, null);
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
	@SuppressWarnings("serial")
	public PlayPage(Integer size, String image) {
		Gsize = size;
		Gimage = image;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 628);
		try {
			setIconImage(ImageIO.read(new File("Image\\Puzzle_House.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBackground(new Color(16577485));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Image
		Image lbbg3 = new ImageIcon(ClassLoader.getSystemResource("back.png")).getImage();
		ImageIcon imgbg3 = new ImageIcon(lbbg3);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// to reshuffle
		JButton btnshuffle = new JButton("Shuffle");

		btnshuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				shuffleAndAdd();
				seconds = 0;
				timer.start();
				count = 0;
				Moves.setText("Move : " + count);

				// To show in presentation ( make the full image)
//				puzzlePanel.removeAll();
//				for (JLabel jLabel : originalList) {
//					puzzlePanel.add(jLabel);
//				}
//				puzzlePanel.revalidate();
//				puzzlePanel.repaint();
				
				if (isPuzzleSolved()) {
					originalList.get(originalList.size() - 1).setIcon(tempPiece.getIcon());
					timer.stop();
					ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

					scheduledExecutorService.schedule(() -> {
						ShowingScore sS = new ShowingScore(seconds, count, Gsize, Gimage);
						dispose();
						sS.setVisible(true);

						scheduledExecutorService.shutdown();
					}, 3, TimeUnit.SECONDS);
				}
			}
		});
		btnshuffle.setForeground(new Color(139, 69, 19));
		btnshuffle.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnshuffle.setBounds(731, 469, 113, 40);
		contentPane.add(btnshuffle);

		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				JOptionPane.showMessageDialog(null, "Game is pause", "Pause", JOptionPane.OK_OPTION);
			}
		});
		btnPause.setForeground(new Color(139, 69, 19));
		btnPause.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnPause.setBounds(608, 469, 113, 40);
		contentPane.add(btnPause);

		playtimeLabel = new JLabel("Duration: 00:00");
		playtimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		playtimeLabel.setForeground(new Color(248, 236, 205));
		playtimeLabel.setFont(new Font("Arial", Font.BOLD, 22));
		playtimeLabel.setBounds(653, 418, 170, 40);
		contentPane.add(playtimeLabel);

		Moves = new JLabel("Count : 00");
		Moves.setHorizontalAlignment(SwingConstants.LEFT);
		Moves.setForeground(new Color(248, 236, 205));
		Moves.setFont(new Font("Arial", Font.BOLD, 22));
		Moves.setBounds(678, 375, 132, 40);
		contentPane.add(Moves);

//		Create a Timer to update the label every second
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds++;
				updateDurationLabel();
			}
		});

		JLabel lbltopTitlePalace = new JLabel("Palace");
		lbltopTitlePalace.setForeground(new Color(117, 81, 57));
		lbltopTitlePalace.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 39));
		lbltopTitlePalace.setBounds(80, 29, 156, 76);
		contentPane.add(lbltopTitlePalace);

		JLabel lblTopTitlePuzzle = new JLabel("Puzzle");
		lblTopTitlePuzzle.setForeground(new Color(117, 81, 57));
		lblTopTitlePuzzle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 39));
		lblTopTitlePuzzle.setBounds(80, -13, 156, 76);
		contentPane.add(lblTopTitlePuzzle);

		JLabel lblTopLogo = new JLabel("");
		lblTopLogo.setIcon(new ImageIcon("Image\\Puzzle_House_Small_Top.png"));
		lblTopLogo.setBounds(-24, -36, 118, 154);
		contentPane.add(lblTopLogo);

		BufferedImage smallSize = resizeImage(loadImage(), 227, 140);
		JPanel fullImage = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(smallSize, 0, 0, null);
			}
		};
		fullImage.setLayout(null);
		fullImage.setBounds(617, 107, 227, 140);
		contentPane.add(fullImage);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Image\\BkPiece.png"));
		lblNewLabel_1.setBounds(593, 75, 298, 210);
		contentPane.add(lblNewLabel_1);

		JLabel big = new JLabel("");
		big.setIcon(new ImageIcon("Image\\DescriptionBG.png"));
		big.setBounds(557, 210, 354, 346);
		contentPane.add(big);

		PlayingBGPanel = new JPanel();
		PlayingBGPanel.setBackground(new Color(222, 184, 135));
		PlayingBGPanel.setBounds(10, 107, 537, 450);
		contentPane.add(PlayingBGPanel);
		PlayingBGPanel.setLayout(null);

		lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(139, 69, 19));
		lblBack.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblBack.setBounds(791, 0, 91, 69);
		contentPane.add(lblBack);
		lblBack.addMouseListener(this);

		JLabel lblNewLabel_3_8 = new JLabel("");
		lblNewLabel_3_8.setIcon(imgbg3);
		lblNewLabel_3_8.setBounds(759, -22, 152, 104);
		contentPane.add(lblNewLabel_3_8);

		contentPane.revalidate();
		contentPane.repaint();

		loadImage();
		getNew();

	}

	private void updateDurationLabel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				playtimeLabel.setText("Duration: " + formatDuration(seconds));
			}
		});
	}

	public String formatDuration(int seconds) {
		int minutes = seconds / 60;
		int second = seconds % 60;
		return String.format("%02d:%02d", minutes, second);

	}

	@SuppressWarnings("serial")
	private BufferedImage loadImage() {

		try {
			oldImage = ImageIO.read(new File(Gimage));
			return oldImage;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void getNew() {
		newImage = resizeImage(oldImage, 517, 428);

		// need to change to Gsize
		puzzlePanel = new JPanel(new GridLayout(Gsize, Gsize));
		splitImage();
		puzzlePanel.setBounds(10, 11, 517, 428);
		PlayingBGPanel.add(puzzlePanel);
	}

	private BufferedImage resizeImage(BufferedImage old, int width, int height) {
		BufferedImage resize = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resize.createGraphics();
		g2d.drawImage(old, 0, 0, width, height, null);
		g2d.dispose();
		return resize;
	}

	private void splitImage() {
		int pieceWidth = newImage.getWidth() / Gsize;
		int pieceHeight = newImage.getHeight() / Gsize;
		piecesList = new ArrayList<JLabel>();
		originalList = new ArrayList<JLabel>();

		for (int i = 0; i < Gsize; i++) {
			for (int j = 0; j < Gsize; j++) {
				int row = j * pieceWidth;
				int col = i * pieceHeight;

				BufferedImage pieces = newImage.getSubimage(row, col, pieceWidth, pieceHeight);
				if (i == Gsize - 1 && j == Gsize - 1) {
					tempPiece = new JLabel(new ImageIcon(pieces));
					JLabel temp = new JLabel();
					temp.setIcon(null);
					piecesList.add(temp);
					originalList.add(temp);
					temp.addMouseListener(new PieceClick());
					break;
				}
				JLabel l = new JLabel(new ImageIcon(pieces));
				l.addMouseListener(new PieceClick());
				piecesList.add(l);
				originalList.add(l);

			}
		}

		shuffleAndAdd();
	}

//	Shuffle List and add to panel
	private void shuffleAndAdd() {
//		Collections.shuffle(piecesList);
		shuffle(piecesList);

		for (JLabel piece : piecesList) {
			puzzlePanel.add(piece);

		}

		puzzlePanel.revalidate();
		puzzlePanel.repaint();

	}

	public static void shuffle(ArrayList<JLabel> list) {
		Random rand = new Random();

		for (int i = list.size() - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);

//			swap value of i & j
			swap(list, i, j);
		}
	}

	private static void swap(ArrayList<JLabel> list, int i, int j) {
		if (i != j) {
			JLabel temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
	}

	private class PieceClick extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			timer.start();
			JLabel clickedPiece = (JLabel) e.getSource();

//			can only swap with null piece
			selectPiece = getGridPositionWithNullIcon(clickedPiece);
			Point targetPiece = getGridPosition(clickedPiece);

			// Check if the two pieces are adjacent
			if (isAdjacentWithNullIcon(selectPiece, targetPiece)) {
				swapPieces(selectPiece, targetPiece);
				targetPiece = null;
				count++;
				Moves.setText("Move : " + count);
			}

			if (isPuzzleSolved()) {
				timer.stop();
				originalList.get(originalList.size() - 1).setIcon(tempPiece.getIcon());
				ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
				scheduledExecutorService.schedule(() -> {
					ShowingScore sS = new ShowingScore(seconds, count, Gsize, Gimage);
					dispose();
					sS.setVisible(true);
					sS.setLocationRelativeTo(null);

					scheduledExecutorService.shutdown();
				}, 2, TimeUnit.SECONDS);
			}

		}

		private Point getGridPositionWithNullIcon(JLabel puzzlePieceLabel) {
			int pieceIndex = puzzlePanel.getComponentZOrder(puzzlePieceLabel);
			int row = pieceIndex / Gsize;
			int column = pieceIndex % Gsize;

			// Iterate through adjacent pieces to find the one with a null icon
			for (int i = 0; i < Gsize; i++) {
				for (int j = 0; j < Gsize; j++) {
					int adjacentIndex = i * Gsize + j;
					if (Math.abs(row - i) + Math.abs(column - j) == 1
							&& piecesList.get(adjacentIndex).getIcon() == null) {
						return new Point(i, j);
					}
				}
			}
			return new Point(-1, -1);
		}

		private boolean isAdjacentWithNullIcon(Point piece1, Point piece2) {
			// Check if the two pieces are adjacent
			if (Math.abs(piece1.x - piece2.x) + Math.abs(piece1.y - piece2.y) == 1) {
				int index1 = piece1.x * Gsize + piece1.y;
				int index2 = piece2.x * Gsize + piece2.y;

				JLabel label1 = piecesList.get(index1);
				JLabel label2 = piecesList.get(index2);

				// Check if one of the pieces has a null icon
				return (label1.getIcon() == null && label2.getIcon() != null)
						|| (label1.getIcon() != null && label2.getIcon() == null);
			}

			return false;
		}

		private void swapPieces(Point selectPiece, Point targetPiece) {

			int index1 = selectPiece.x * Gsize + selectPiece.y;
			int index2 = targetPiece.x * Gsize + targetPiece.y;

			JLabel label1 = piecesList.get(index1);
			JLabel label2 = piecesList.get(index2);

			// Swap the positions in the puzzle panel
			puzzlePanel.setComponentZOrder(label1, index2);
			puzzlePanel.setComponentZOrder(label2, index1);

			// Update the puzzle piece list
			piecesList.set(index1, label2);
			piecesList.set(index2, label1);

			puzzlePanel.revalidate();
			puzzlePanel.repaint();

		}
	}

	private Point getGridPosition(JLabel puzzlePieceLabel) {
		int pieceIndex = puzzlePanel.getComponentZOrder(puzzlePieceLabel);

		int row = pieceIndex / Gsize;
		int column = pieceIndex % Gsize;

		return new Point(row, column);
	}

	private boolean isPuzzleSolved() {
		for (int i = 0; i < originalList.size(); i++) {
			JLabel puzzlePieceLabel = originalList.get(i);

			int expectedRow = i / Gsize;
			int expectedColumn = i % Gsize;

			// Check if the puzzle piece is in the correct position
			if (getGridPosition(puzzlePieceLabel).x != expectedRow
					|| getGridPosition(puzzlePieceLabel).y != expectedColumn) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (lblBack == e.getSource()) {
			Comfrim();
		}

	}

	private void Comfrim() {
		int choice = JOptionPane.showConfirmDialog(null, "Are you Sure?", "ConFirmDialog", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			StartPage start = new StartPage();
			this.dispose();
			start.setVisible(true);
			start.setLocationRelativeTo(null);
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
