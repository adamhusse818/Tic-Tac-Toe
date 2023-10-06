import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Thread;

public class TicTacToe implements ActionListener{
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel topPanel = new JPanel();
    JPanel playBoard = new JPanel();
    JLabel label = new JLabel("Tic-Tac-Toe! Let's see who's first...");
    JButton[] buttons = new JButton[9];
    int playerTurn;
    int count = 0;
    boolean threeInARow = false;

    public TicTacToe() {
        // Setting up the frame
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        // Setting up the label for the top panel
        label.setForeground(Color.yellow);
        label.setFont(new Font("Comic Sans", Font.BOLD, 30));

        // Setting up the top panel which displays title, turn, and who wins
        topPanel.setBackground(Color.black);
        topPanel.setBounds(0, 0, 600, 50);
        topPanel.add(label);
        frame.add(topPanel);

        // Setting up the actual board for the game
        playBoard.setLayout(new GridLayout(3, 3, 5, 5));
        playBoard.setBackground(Color.lightGray);
        playBoard.setBounds(0, 50, 600, 520);
        frame.add(playBoard);

        // Creating the buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            playBoard.add(buttons[i]);
            buttons[i].setEnabled(false);
        }

        // Determine who goes first
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            System.exit(0);
        }
        for(JButton b : buttons){
            b.setEnabled(true);
        }
        Random rand = new Random();
        int first = rand.nextInt(2) + 1;
        if(first == 1){
            playerTurn = 1;
            label.setText("Player 1, you're first!");
        }
        else{
            playerTurn = 2;
            label.setText("Player 2, you're first!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton b : buttons){
            if (e.getSource() == b && playerTurn == 1 && b.getText().isEmpty()){
                b.setText("X");
                b.setForeground(Color.blue);
                count++;
                label.setText("Player 2, you're next!");
                didTheyWin();
                playerTurn = 2;
            }
            if (e.getSource() == b && playerTurn == 2 && b.getText().isEmpty()){
                b.setText("O");
                b.setForeground(Color.red);
                count++;
                label.setText("Player 1, you're next!");
                didTheyWin();
                playerTurn = 1;
            }
        }
    }

    public void didTheyWin(){
        // First we will test the conditions for if player 1 won
        if(buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")){
            label.setText("Player 1 wins!!");
            buttons[0].setBackground(Color.green);
            buttons[1].setBackground(Color.green);
            buttons[2].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")){
            label.setText("Player 1 wins!!");
            buttons[3].setBackground(Color.green);
            buttons[4].setBackground(Color.green);
            buttons[5].setBackground(Color.green);
            for (JButton b : buttons){
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")){
            label.setText("Player 1 wins!!");
            buttons[6].setBackground(Color.green);
            buttons[7].setBackground(Color.green);
            buttons[8].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")){
            label.setText("Player 1 wins!!");
            buttons[0].setBackground(Color.green);
            buttons[3].setBackground(Color.green);
            buttons[6].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")){
            label.setText("Player 1 wins!!");
            buttons[1].setBackground(Color.green);
            buttons[4].setBackground(Color.green);
            buttons[7].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")){
            label.setText("Player 1 wins!!");
            buttons[2].setBackground(Color.green);
            buttons[5].setBackground(Color.green);
            buttons[8].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")){
            label.setText("Player 1 wins!!");
            buttons[0].setBackground(Color.green);
            buttons[4].setBackground(Color.green);
            buttons[8].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")){
            label.setText("Player 1 wins!!");
            buttons[2].setBackground(Color.green);
            buttons[4].setBackground(Color.green);
            buttons[6].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }

        // Now we will test if player 2 wins
        if(buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")){
            label.setText("Player 2 wins!!");
            buttons[0].setBackground(Color.green);
            buttons[1].setBackground(Color.green);
            buttons[2].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")){
            label.setText("Player 2 wins!!");
            buttons[3].setBackground(Color.green);
            buttons[4].setBackground(Color.green);
            buttons[5].setBackground(Color.green);
            for (JButton b : buttons){
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")){
            label.setText("Player 2 wins!!");
            buttons[6].setBackground(Color.green);
            buttons[7].setBackground(Color.green);
            buttons[8].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")){
            label.setText("Player 2 wins!!");
            buttons[0].setBackground(Color.green);
            buttons[3].setBackground(Color.green);
            buttons[6].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")){
            label.setText("Player 2 wins!!");
            buttons[1].setBackground(Color.green);
            buttons[4].setBackground(Color.green);
            buttons[7].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")){
            label.setText("Player 2 wins!!");
            buttons[2].setBackground(Color.green);
            buttons[5].setBackground(Color.green);
            buttons[8].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")){
            label.setText("Player 2 wins!!");
            buttons[0].setBackground(Color.green);
            buttons[4].setBackground(Color.green);
            buttons[8].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }
        if(buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")){
            label.setText("Player 2 wins!!");
            buttons[2].setBackground(Color.green);
            buttons[4].setBackground(Color.green);
            buttons[6].setBackground(Color.green);
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            threeInARow = true;
        }

        // Worst case scenario, nobody wins
        if(count == 9 && !threeInARow){
            for(JButton b : buttons){
                b.setEnabled(false);
            }
            label.setText("Sucks to suck. Nobody won!");
        }
    }
}