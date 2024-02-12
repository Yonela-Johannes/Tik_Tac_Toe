import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe {
    public int boardWidth = 660;
    public int boardHeight = 460;
    public int playerXScore = 0;
    public int playerOScore = 0;
    public int gameCount = 1;
    public int gameRounds = 0;

    private int button1 = 10;
    private int button2 = 10;
    private int button3 = 10;
    private int button4 = 10;
    private int button5 = 10;
    private int button6 = 10;
    private int button7 = 10;
    private int button8 = 10;
    private int button9 = 10;
    private int iterator = 0;

    public static Font font = new Font("Verdana", Font.BOLD, 20);
	public static Font smallerFont = new Font("Verdana", Font.BOLD, 18);
    public static Font scoreFont = new Font("Verdana", Font.PLAIN, 14);
	public static Font largeFont = new Font("Verdana", Font.BOLD, 30);

    public static String title = "Tic-Tac-Toe";

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
    JLabel playerXLabel = new JLabel();
    JLabel playerOLabel = new JLabel();

    JLabel boardTitleLabel = new JLabel();
    JLabel scoresLabel = new JLabel();
    JLabel scoreLabel = new JLabel();
    JLabel wonLabel = new JLabel();
    JLabel turnLabel = new JLabel();
    JLabel loseLabel = new JLabel();
    JLabel tieLabel = new JLabel();
    JLabel gameEndLabel = new JLabel();
    JLabel scoresTitle = new JLabel();
    JLabel playerLabel = new JLabel();
    JLabel footerLabel = new JLabel();

    JPanel buttonPanel = new JPanel();

    JButton btnReset = new JButton();
    JButton btnExit = new JButton();
    JButton[][] board = new JButton[3][3];
    JButton btn1 = new JButton("");
    JButton btn2 = new JButton("");
    JButton btn3 = new JButton("");
    JButton btn4 = new JButton("");
    JButton btn5 = new JButton("");
    JButton btn6 = new JButton("");
    JButton btn7 = new JButton("");
    JButton btn8 = new JButton("");
    JButton btn9 = new JButton("");

    public String playerX = "X";
    public String playerO = "O";
    public String currentPlayer = playerX;

    public boolean roundOver = false;
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
        textPanel.setLayout(new BorderLayout());
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
        footerPanel.setLayout(new BorderLayout());
        footerPanel.add(footerLabel);

        rightPanel.setBackground(Color.decode("#2b2b2b"));
        rightPanel.setPreferredSize(new Dimension(300, boardHeight));
        rightPanel.setLayout(null);
        rightPanel.setBounds(0, 0, 300, boardHeight);
        frame.add(rightPanel, BorderLayout.EAST);

        rightPanel.add(scoresLabel, BorderLayout.NORTH);

        scoresLabel.setText("Score board");
        scoresLabel.setForeground(Color.white);
        scoresLabel.setFont(font);
        scoresLabel.setVerticalAlignment(JLabel.CENTER);
        scoresLabel.setHorizontalAlignment(JLabel.CENTER);
        scoresLabel.setBorder(border);
        scoresLabel.setBounds(0, 0, 300, 25);

        rightPanel.add(playerXLabel);
        rightPanel.add(playerOLabel);
        rightPanel.add(scoreLabel);
        rightPanel.add(turnLabel);

        getScores();

        playerXLabel.setForeground(Color.white);
        playerXLabel.setFont(smallerFont);
        playerXLabel.setHorizontalAlignment(JLabel.CENTER);
        playerXLabel.setBounds(0, 60, 300, 25);
        

        playerOLabel.setForeground(Color.white);
        playerOLabel.setFont(smallerFont);
        playerOLabel.setHorizontalAlignment(JLabel.CENTER);
        playerOLabel.setBounds(0, 100, 300, 25);
        
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(scoreFont);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setBounds(0, 180, 300, 25);

        turnLabel.setForeground(Color.white);
        turnLabel.setFont(scoreFont);
        turnLabel.setHorizontalAlignment(JLabel.CENTER);
        turnLabel.setBounds(0, 200, 300, 25);

        btnReset.setBackground(Color.decode("#00747c"));
        btnReset.setForeground(Color.WHITE);
        btnReset.setText("Reset");
        btnReset.setBounds(50, boardHeight - 150, 80, 25);
        btnReset.setHorizontalAlignment(JButton.CENTER);
        btnReset.setVerticalAlignment(JButton.CENTER);
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));

        rightPanel.add(btnReset, BorderLayout.SOUTH);
        rightPanel.add(btnExit, BorderLayout.CENTER);

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnReset){
                    frame = new JFrame("RESET");
                    if(JOptionPane.showConfirmDialog(frame, "Are You Sure You Want To Reset Game", "Tik-Tac-Toe",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                        clearBoard();
                        playerXScore = 0;
                        playerOScore = 0;
                        gameCount = 1;
                        gameRounds = 0;
                        getScores();
                    }
                }
            }
        });

        btnExit.setBackground(Color.decode("#00747c"));
        btnExit.setForeground(Color.WHITE);
        btnExit.setText("Exit");
        btnExit.setBounds(170, boardHeight - 150, 90, 25);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnExit){
                    frame = new JFrame("EXIT");
                    if(JOptionPane.showConfirmDialog(frame, "Cofirm You Want To Exit", "Tik-Tac-Toe",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                        System.exit(0);
                    }
                }
            }
        });

        tileButton(btn1, 0, 0, "btn1");
        tileButton(btn2, 0, 1, "btn2");
        tileButton(btn3, 0, 2, "btn3");
        tileButton(btn4, 1, 0, "btn4");
        tileButton(btn5, 1, 1, "btn5");
        tileButton(btn6, 1, 2, "btn6");
        tileButton(btn7, 2, 0, "btn7");
        tileButton(btn8, 2, 1, "btn8");
        tileButton(btn9, 2, 2, "btn9");
    }
    

    void setTie(JButton tile) {
        tile.setForeground(Color.orange);
        tile.setBackground(Color.gray);
        gameCount++;
        getScores();
        textLabel.setText("It's a tie!");
    }

    public void clearBoard() {
        btn1.setText(null);
        btn2.setText(null);
        btn3.setText(null);
        btn4.setText(null);
        btn5.setText(null);
        btn6.setText(null);
        btn7.setText(null);
        btn8.setText(null);
        btn9.setText(null);
        button1=10;
        button2=10;
        button3=10;
        button4=10;
        button5=10;
        button6=10;
        button7=10;
        button8=10;
        button9=10;
        iterator=0;
    }
    public void getScores(){
        playerXLabel.setText("Player" + playerX + ": " + playerXScore);
        playerOLabel.setText("Player" + playerO + ": " + playerOScore);
        scoreLabel.setText("GAME: "+ gameCount + "-" + 5);
    }

    private void winningGame(){
        // Player X
        if(button1 == 1 && button2 == 1 && button3 == 1){
            gameCount++;          
            getScores();
            roundOver = true;
            clearBoard();
            xMessage();
        }else if(button4 == 1 && button5 == 1 && button6 == 1){
            gameCount++;          
            getScores();
            roundOver = true;
            clearBoard();
            xMessage();
        }else if(button7 == 1 && button8 == 1 && button9 == 1){
            gameCount++;          
            getScores();
            roundOver = true;
            clearBoard();
            xMessage();
        }else if(button1 == 1 && button4 == 1 && button7 == 1){
            gameCount++;         
            getScores();
            roundOver = true;
            clearBoard();
            xMessage();
        }else if(button2 == 1 && button5 == 1 && button8 == 1){
            gameCount++;         
            getScores();
            roundOver = true;
            clearBoard();
            xMessage();
        }else if(button3 == 1 && button6 == 1 && button9 == 1){
            gameCount++;         
            getScores();
            roundOver = true;
            clearBoard();
            xMessage();
        }else if(button1 == 1 && button5 == 1 && button9 == 1){
            gameCount++;         
            getScores();
            roundOver = true;
            clearBoard();
            xMessage();
        }else if(button3 == 1 && button5 == 1 && button7 == 1){
            gameCount++;         
            getScores();
            roundOver = true;
            clearBoard();
            xMessage();
        }else if(button1 == 0 && button2 == 0 && button3 == 0){ //Player O
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            oMessage();
        }else if(button4 == 0 && button5 == 0 && button6 == 0){
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            oMessage();
        }else if(button7 == 0 && button8 == 0 && button9 == 0){
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            oMessage();
        }else if(button1 == 0 && button4 == 0 && button7 == 0){
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            oMessage();
        }else if(button2 == 0 && button5 == 0 && button8 == 0){
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            oMessage();
        }else if(button3 == 0 && button6 == 0 && button9 == 0){
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            oMessage();
        }else if(button1 == 0 && button5 == 0 && button9 == 0){
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            oMessage();
        }else if(button3 == 0 && button5 == 0 && button7 == 0){
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            oMessage();
        }else if(iterator == 9){
            getScores();
            roundOver = true;
            clearBoard();
            gameCount++;
            tMessage();
        }
    }

    // Player X Popup
    public void xMessage(){
        JOptionPane.showMessageDialog(frame, "Player X Wins", "Tik-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
        playerXScore++;
        getScores();
    }
    // Player O Popup
    public void oMessage(){
        JOptionPane.showMessageDialog(frame, "Player O Wins", "Tik-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
        playerOScore++;
        getScores();
    }
    // Tie Popup
    public void tMessage(){
        JOptionPane.showMessageDialog(frame, "It's A Tie!", "Tik-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
    }

        // Tie Popup
    public void gameOverMessage(){
        JOptionPane.showMessageDialog(frame, "Game over!", "Tik-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
    }

    // Error Play Popup
    public void existMessage(){
        JOptionPane.showMessageDialog(frame, "Invalid move!", "Tik-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
    }
    private void tileButton(JButton buttonParam, int btnPlacement, int btnIndex, String type) {
        board[btnPlacement][btnIndex] = buttonParam;
        leftBoardPanel.add(buttonParam); 
        
        buttonParam.setBackground(Color.getColor("#3d3d3d"));
        buttonParam.setForeground(Color.decode("#2b2b2b"));
        buttonParam.setFont(new Font("Arial", Font.BOLD, 120));
        buttonParam.setMargin(new Insets(0, 0, 0, 0));
        buttonParam.setFocusable(false);

        buttonParam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameCount == 6){
                    gameOverMessage();
                    roundOver = true;
                    return;
                }
                if (roundOver) {
                    clearBoard();
                    roundOver = false;
                }
                String exist = buttonParam.getText();
                System.out.print("EXIST: "+ exist);
                if(exist != "")
                {
                    existMessage();
                    return;
                } else {
                    buttonParam.setText(currentPlayer);
                }

                if(currentPlayer.equalsIgnoreCase("X"))
                {
                    buttonParam.setForeground(Color.RED);
                    checkXButtonTile(type);
                    iterator++;
                }
                else if(currentPlayer.equalsIgnoreCase("O"))
                {
                    buttonParam.setForeground(Color.BLUE);
                    checkOButtonTile(type);
                    iterator++;
                }

                winningGame();

                if (!roundOver) {
                    if(currentPlayer == playerX) {
                        currentPlayer = playerO;
                    } else if(currentPlayer == playerO){
                        currentPlayer = playerX;
                    };

                    turnLabel.setText(currentPlayer + "'s turn.");
                }
            }

            public void checkXButtonTile(String buttonParam){
                switch(buttonParam){
                    case "btn1":
                        button1 = 1;
                        break;
                    case "btn2":
                        button2 = 1;
                        break;
                    case "btn3":
                        button3 = 1;
                        break;
                    case "btn4":
                        button4 = 1;
                        break;
                    case "btn5":
                        button5 = 1;
                        break;
                    case "btn6":
                        button6 = 1;
                        break;
                    case "btn7":
                        button7 = 1;
                        break;
                    case "btn8":
                        button8 = 1;
                        break;
                    case "btn9":
                        button9 = 1;
                        break;
                    default:
                        break;
                }
            }

            public void checkOButtonTile(String buttonParam){
                switch(buttonParam){
                    case "btn1":
                        button1 = 0;
                        break;
                    case "btn2":
                        button2 = 0;
                        break;
                    case "btn3":
                        button3 = 0;
                        break;
                    case "btn4":
                        button4 = 0;
                        break;
                    case "btn5":
                        button5 = 0;
                        break;
                    case "btn6":
                        button6 = 0;
                        break;
                    case "btn7":
                        button7 = 0;
                        break;
                    case "btn8":
                        button8 = 0;
                        break;
                    case "btn9":
                        button9 = 0;
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
