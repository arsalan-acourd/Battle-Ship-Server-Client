package UI;

import UI.component.BoardPanel;
import entity.Ship.Ship;
import logic.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shipsetter extends JFrame implements ActionListener {
    private static Shipsetter instance;
    JComboBox comboBox1;
    JComboBox comboBox2;
    public int[][] map = new int[10][10];
    JButton myButton = new JButton("READY");

    private Shipsetter() {
        this.setTitle("Pre Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        String[] ships = {"5 Carrier", "3 Cruiser", "2 Destroyer","3 Submarine","4 Battleship"};
        comboBox1 = new JComboBox(ships);
        comboBox1.addActionListener(this);
        comboBox1.setEditable(true);
        JPanel combopanel1 = new JPanel();
        combopanel1.add(comboBox1);
        combopanel1.setBounds(450,50,150,100);
        combopanel1.setVisible(true);


        String[] placing = {"toward right", "toward left", "upward", "downward"};
        comboBox2 = new JComboBox(placing);
        comboBox2.addActionListener(this);
        comboBox2.setEditable(true);
        JPanel combopanel2 = new JPanel();
        combopanel2.add(comboBox2);
        combopanel2.setBounds(450,170,150,100);
        combopanel2.setVisible(true);


        JPanel buttonpanel = new JPanel();
        buttonpanel.setBounds(0, 0, 50, 50);
        myButton.setBounds(100, 160, 200, 40);
        myButton.setFocusable(true);
        myButton.addActionListener(this);
        buttonpanel.add(myButton);
        buttonpanel.setVisible(true);


        BoardPanel shipset = new BoardPanel(map, false, true);
        shipset.setBounds(0, 50, 450, 450);
        shipset.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(shipset);
        //shipset.addMouseListener(new MouseAdapter (){comboBox1.removeItem();});

        // Border border = BorderFactory.createLineBorder(Color.BLACK);

        JLabel text1 = new JLabel();
        JLabel text2 = new JLabel();
        text1.setText("please place your ships in the cells.");
        text2.setText("when done with placing click the button reddy to start.");
        JPanel text_panel1 = new JPanel();
        JPanel text_panel2 = new JPanel();
        text_panel1.setBounds(0, 0, 600, 25);
        text_panel1.add(text1);
        text_panel1.setVisible(true);
        text_panel2.setBounds(0, 25, 600, 25);
        text_panel2.add(text2);
        text_panel2.setVisible(true);


        //pause panel for when the other player is choosing


        this.add(combopanel1);
        this.add(combopanel2);
        this.add(text_panel1);
        this.add(text_panel2);
        this.add(buttonpanel);

        this.setVisible(true);
    }

    public static Shipsetter getInstance() {
        if (Shipsetter.instance != null) return Shipsetter.instance;
        Shipsetter.instance = new Shipsetter();
        return Shipsetter.instance;
    }

    public void close() {
        this.setVisible(false);
    }
    public void open() {
        this.setVisible(true);
    }

    private Ship[] getShipPositions() {
        //           getShip
        return null;
    }

    //when click on ready button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButton) {
            Ship[] ships = getShipPositions();
            Service.settingShips(ships);
        }

        if (e.getSource() == comboBox1) {

        }

        if (e.getSource() == comboBox2) {

        }
    }
}