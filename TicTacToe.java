import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class TicTacToe {
    public int boardWidth = 660;
    public int boardHeight = 460;
    public int playerXScore = 0;
    public int playerOScore = 0;
    public int gameCount = 0;

    public static Font font = new Font("Verdana", Font.BOLD, 20);
	public static Font smallerFont = new Font("Verdana", Font.BOLD, 18);
	public static Font largeFont = new Font("Verdana", Font.BOLD, 30);

    public boolean won = false;
	public boolean pcWon = false;
	public boolean tie = false;

    public static String title = "Tic-Tac-Toe";
	public String wonString = "Congratulations, you won!";
	public String pcWonString = "Sorry you lost, computer won!";
	public String tieString = "Game ended in a tie";

    JFrame frame = new JFrame(title);
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel leftBoardPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel scoresPanel = new JPanel();
    JPanel scorePanel = new JPanel();
    JPanel scoresTitlePanel = new JPanel(); 
    Border border = BorderFactory.createLineBorder(Color.GREEN, 3);

    JLabel boardTitleLabel = new JLabel();
    JLabel scoresLabel = new JLabel();
    JLabel scoreLabel = new JLabel();
    JLabel wonLabel = new JLabel();
    JLabel loseLabel = new JLabel();
    JLabel tieLabel = new JLabel();
    JLabel gameEndLabel = new JLabel();
    JLabel scoresTitle = new JLabel();
    JLabel playerLabel = new JLabel();
    JLabel footerLabel = new JLabel();

    JButton[][] board = new JButton[3][3];
    public String playerX = "X";
    public String playerO = "O";
    public String currentPlayer = playerX;

    public boolean gameOver = false;
    int turns = 0;

    TicTacToe() {
        frame.setBackground(Color.DARK_GRAY);
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(textPanel, BorderLayout.NORTH);

        frame.getContentPane().setBackground(Color.decode("#00747c"));

		textLabel.setBackground(Color.decode("#00747c"));
		textLabel.setForeground(Color.WHITE);
        textLabel.setFont(largeFont);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText(title);
        textLabel.setOpaque(true);
        textLabel.setBounds(0, 0, 300, 80);

        textPanel.setBackground(Color.decode("#00747c"));
        // textPanel.setPreferredSize(new Dimension((boardWidth - 300), 80));
        textPanel.setLayout(new BorderLayout());
        // textPanel.setBounds(0, 0, (boardWidth - 300), 80);
        textPanel.add(textLabel);

        

        leftBoardPanel.setBounds(0, 0, (boardWidth - 300), boardHeight);
        leftBoardPanel.setPreferredSize(new Dimension(300, boardHeight));
        leftBoardPanel.setLayout(new GridLayout(3, 3));
        leftBoardPanel.setBackground(Color.decode("#014247"));
        frame.add(leftBoardPanel);

        frame.add(footerPanel, BorderLayout.SOUTH);

		footerLabel.setBackground(Color.decode("#00747c"));
		footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(font);
        footerLabel.setHorizontalAlignment(JLabel.CENTER);
        footerLabel.setText("Made with love by Yonela Johannes");
        footerLabel.setOpaque(true);
        footerLabel.setBounds(0, 0, 300, 80);

        footerPanel.setBackground(Color.decode("#00747c"));
        // footerPanel.setPreferredSize(new Dimension((boardWidth - 300), 80));
        footerPanel.setLayout(new BorderLayout());
        // footerPanel.setBounds(0, 0, (boardWidth - 300), 80);
        footerPanel.add(footerLabel);

        rightPanel.setBorder(border);

        rightPanel.setBackground(Color.decode("#2b2b2b"));
        rightPanel.setPreferredSize(new Dimension(300, boardHeight));
        // rightPanel.setLayout(new BorderLayout());
        // rightPanel.setBounds(0, 0, 300, boardHeight);
        frame.add(rightPanel, BorderLayout.EAST);

        rightPanel.add(scoresPanel, BorderLayout.EAST);

        scoresLabel.setText("Score board");
        scoresLabel.setForeground(Color.white);
        scoresLabel.setFont(font);
        scoresLabel.setVerticalAlignment(JLabel.CENTER);
        scoresLabel.setHorizontalAlignment(JLabel.CENTER);
        scoresLabel.setBounds(0, 0, 300, 25);
        scoresLabel.setBorder(border);

        scoresPanel.setBackground(Color.decode("#00747c"));
        // scoresPanel.setBounds(0, 0, 300, 60);
        scoresPanel.add(scoresLabel);
        

        rightPanel.add(scorePanel, BorderLayout.CENTER);

        scoreLabel.setText("Score");
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(smallerFont);
        scoreLabel.setBorder(border);
        // scoreLabel.set
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setBounds(0, 0, 300, 25);

        scorePanel.setBackground(Color.decode("#00747c"));
        scorePanel.setBounds(0, 0, 300, 60);
        scorePanel.add(scoreLabel);

        // rightPanel.add(scoresTitle, BorderLayout.CENTER);

        // scoresTitle.setText("Player" + playerX + ": " + playerXScore);
        // scoresTitle.setForeground(Color.white);
        // scoresTitle.setFont(font);
        // scoresTitle.setVerticalAlignment(JLabel.TOP);
        // scoresTitle.setHorizontalAlignment(JLabel.CENTER);
        // scoresTitle.setOpaque(true);

        // rightPanel.add(scoresTitle, BorderLayout.CENTER);
        
        // scoresTitle.setText("Player" + playerO + ": " + playerOScore);
        // scoresTitle.setForeground(Color.white);
        // scoresTitle.setFont(font);
        // scoresTitle.setVerticalAlignment(JLabel.TOP);
        // scoresTitle.setHorizontalAlignment(JLabel.CENTER);
        // scoresTitle.setOpaque(true);

        // rightPanel.add(scoresTitle, BorderLayout.CENTER);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                leftBoardPanel.add(tile);

                tile.setBackground(Color.getColor("#3d3d3d"));
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText() == "") {
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s turn.");
                            }
                        }

                    }
                });
            }
        }
    }
    
    void checkWinner() {
        //horizontal
        for (int r = 0; r < 3; r++) {
            if (board[r][0].getText() == "") continue;

            if (board[r][0].getText() == board[r][1].getText() &&
                board[r][1].getText() == board[r][2].getText()) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }

        //vertical
        for (int c = 0; c < 3; c++) {
            if (board[0][c].getText() == "") continue;
            
            if (board[0][c].getText() == board[1][c].getText() &&
                board[1][c].getText() == board[2][c].getText()) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }

        //diagonally
        if (board[0][0].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][2].getText() &&
            board[0][0].getText() != "") {
            for (int i = 0; i < 3; i++) {
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }

        //anti-diagonally
        if (board[0][2].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][0].getText() &&
            board[0][2].getText() != "") {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            return;
        }

        if (turns == 9) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
        }
    }

    void setWinner(JButton tile) {
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
        textLabel.setText(currentPlayer + " is the winner!");
    }

    void setTie(JButton tile) {
        tile.setForeground(Color.orange);
        tile.setBackground(Color.gray);
        textLabel.setText("Tie!");
    }
}
