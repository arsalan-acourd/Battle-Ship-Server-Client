package UI;

import UI.component.BoardPanel;

import javax.swing.*;
import java.awt.*;

public class  GameFrame extends JFrame{
    private static GameFrame instance;
    JButton newGame;
    JPanel locker = new JPanel();
    BoardPanel destroying_sheet;

    private GameFrame() {
        this.setTitle("Battle Sheep");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        locker.setBounds(0,0,800,600);
        locker.setBackground(Color.BLACK);
        JLabel textlabel = new JLabel();
        textlabel.setText("please wait for other player");
        textlabel.setForeground(Color.white);
        locker.add(textlabel);
        locker.setVisible(false);


        newGame = new JButton();
        newGame.setText("new game");
        newGame.setHorizontalTextPosition(JButton.CENTER);
        newGame.setVerticalTextPosition(JButton.CENTER);
        newGame.setFocusable(false);
        newGame.setBounds(0,500,100,20);
        newGame.setBackground(new Color(120,100,100));
        this.add(newGame);
        newGame.addActionListener(e -> {
            this.dispose();
        });

        int[][] map = null;
        destroying_sheet = new BoardPanel(map,false);
        destroying_sheet.setBounds(100, 50, 250, 250);
        destroying_sheet.setBorder(BorderFactory.createLineBorder(Color.black));

        BoardPanel setSheet = new BoardPanel(map,false);
        setSheet.setBounds(450, 50, 250, 250);
        setSheet.setBorder(BorderFactory.createLineBorder(Color.black));


        this.add(locker);
        this.add(setSheet);
        this.add(destroying_sheet);

               /*use to be waiting on client locker.setVisible(true);
       use to de active hover destroying_sheet.setVisible(false);*/
       // pause();

        this.setVisible(true);
        this.pack();
        this.setMinimumSize(new Dimension(800, 600));
    }

    public static GameFrame getInstance() {
        if (GameFrame.instance != null) return GameFrame.instance;
        GameFrame.instance = new GameFrame();
        return GameFrame.instance;
    }

    public void pause(){
        locker.setVisible(true);
        destroying_sheet.setVisible(false);
    }

    public void close() {
        this.setVisible(false);
    }

    public void open() {
        this.setVisible(true);
    }
}
