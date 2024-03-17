package project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class PlayTimeManager extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/puzzle";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private JTextField playTimeInput;

    public PlayTimeManager() {
        // Set up the frame
        setTitle("Play Time Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create UI components
        JLabel playTimeLabel = new JLabel("Enter Play Time (in seconds):");
        playTimeInput = new JTextField();
        JButton storeButton = new JButton("Store Play Time");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Play Time");
        JTable playTimeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(playTimeTable);

        // Add components to the frame
        setLayout(new GridLayout(4, 1));
        add(playTimeLabel);
        add(playTimeInput);
        add(storeButton);
        add(scrollPane);

        // Add action listener to the storeButton
        storeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storePlayTime(tableModel);
            }
        });

        // Display the frame
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void storePlayTime(DefaultTableModel tableModel) {
        String playTimeStr = playTimeInput.getText();
        try {
            int playTime = Integer.parseInt(playTimeStr);

            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String insertQuery = "INSERT INTO playtime_table (play_time) VALUES (?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setInt(1, playTime);
                    preparedStatement.executeUpdate();
                }

                // Clear the input field
                playTimeInput.setText("");

                // Refresh the table to display the updated data
                tableModel.setRowCount(0);
                retrieveAndPopulateData(tableModel);
            }
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    private void retrieveAndPopulateData(DefaultTableModel tableModel) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String selectQuery = "SELECT play_time FROM playtime_table ORDER BY play_time DESC";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int playTime = resultSet.getInt("play_time");
                    Vector<Object> row = new Vector<>();
                    row.add(playTime);
                    tableModel.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlayTimeManager());
    }
}
