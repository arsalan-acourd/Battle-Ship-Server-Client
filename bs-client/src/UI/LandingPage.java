package UI;

import logic.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame implements ActionListener {
    private static LandingPage instance;
    JButton StartButton = new JButton("START");
    JButton login_Button = new JButton("LOG IN");
    JButton sign_up_Button = new JButton("SIGN UP");
    JButton submit_Button = new JButton("SUBMIT");
    JTextField textField;
    JLabel textlabel = new JLabel();
    JLabel textlabel2 = new JLabel();
    JLabel textlabel3 = new JLabel();

    private LandingPage() {
        StartButton.setBounds(100, 150, 200, 40);
        StartButton.setFocusable(true);
        StartButton.addActionListener(this);
        StartButton.setVisible(false);

        sign_up_Button.setBounds(100, 100, 200, 40);
        sign_up_Button.setFocusable(true);
        sign_up_Button.addActionListener(this);

        login_Button.setBounds(100, 50, 200, 40);
        login_Button.setFocusable(true);
        login_Button.addActionListener(this);

        submit_Button.setBounds(150, 150, 100, 30);
        submit_Button.addActionListener(this);
        submit_Button.addActionListener(this);
        submit_Button.setVisible(false);

        textField = new JTextField();
        textField.setBounds(100, 100, 200, 40);
        textField.setText("username");
        textField.setVisible(false);

        textlabel.setText("welcome to our yet to be battleship game");
        textlabel.setVisible(true);
        textlabel.setBounds(80,0,420,50);

        textlabel2.setText("Please enter your username");
        textlabel2.setVisible(false);
        textlabel2.setBounds(120,0,420,50);

        textlabel3.setText("Please enter a username that you want");
        textlabel3.setVisible(false);
        textlabel3.setBounds(80,0,420,50);

        this.add(StartButton);
        this.add(login_Button);
        this.add(sign_up_Button);
        this.add(submit_Button);
        this.add(textField);
        this.add(textlabel);
        this.add(textlabel2);
        this.add(textlabel3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);

        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static LandingPage getInstance() {
        if (LandingPage.instance != null) return LandingPage.instance;
        LandingPage.instance = new LandingPage();
        return LandingPage.instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==StartButton) {
            Service.start();
            LandingPage.getInstance().close();
            Shipsetter.getInstance().open();
        }
        if(e.getSource()== login_Button) {
            Service.login();
            textlabel2.setVisible(true);
            login_Button.setVisible(false);
            sign_up_Button.setVisible(false);
            textlabel.setVisible(false);
            textField.setVisible(true);
            submit_Button.setVisible(true);
        }
        if(e.getSource()== sign_up_Button) {
            Service.signUp();
            textlabel3.setVisible(true);
            login_Button.setVisible(false);
            sign_up_Button.setVisible(false);
            textlabel.setVisible(false);
            textField.setVisible(true);
            submit_Button.setVisible(true);
        }
        if(e.getSource()== submit_Button) {
            textField.getText();
            submit_Button.setEnabled(false);
            textField.setEditable(false);
            textField.setVisible(false);
            submit_Button.setVisible(false);
            StartButton.setVisible(true);

        }
    }

    public void close() {
        this.setVisible(false);
    }

    public void open() {
        this.setVisible(true);
    }
}


