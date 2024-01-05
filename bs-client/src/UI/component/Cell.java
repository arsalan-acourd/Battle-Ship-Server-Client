package UI.component;

import entity.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class    Cell extends JPanel {
    private Boolean lock;
    private Boolean setter;

    public Position position;
    boolean isOccupied, isSelected;

    public Cell(Position position, Boolean lock) {
        this.lock = lock;
        this.position = position;
        this.isSelected = false;

        this.setBackground(new Color(185, 180, 180,216));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        if (!lock){
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                select();
            }

                @Override
                public void mouseEntered(MouseEvent e) {
                hoverIn();
            }

                @Override
                public void mouseExited(MouseEvent e) {
                hoverOut();
            }
            });

        }


        this.setOpaque(true);
        this.setVisible(true);
    }

    public Cell(Position position, Boolean lock, Boolean setter, int[][]map) {
        this.setter = setter;
        this.lock = lock;
        this.position = position;
        this.isSelected = false;

        this.setBackground(new Color(185, 180, 180,216));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {select_set(map);
                }

                @Override
                public void mouseEntered(MouseEvent e) {hoverIn();}

                @Override
                public void mouseExited(MouseEvent e) {hoverOut();}
            });
        this.setOpaque(true);
        this.setVisible(true);
    }

    public void hoverIn(){
        if(!this.isSelected) {
            this.setBackground(new Color(225, 225, 225));
            this.repaint();
        }
    }

    public void hoverOut(){
        if(!this.isSelected) {
            this.setBackground(new Color(185, 180, 180,216));
        }
    }
    public void select() {
        if (!this.isSelected) {
            isSelected = true;
            if (!this.isOccupied) {
                ImageIcon red_X = new ImageIcon(new ImageIcon("x.png")
                        .getImage()
                        .getScaledInstance
                                (this.getWidth() / 2,
                                        this.getWidth() / 2,
                                        Image.SCALE_DEFAULT));
                JLabel label = new JLabel();
                label.setIcon(red_X);
                label.setAlignmentX(JLabel.CENTER);
                label.setAlignmentY(JLabel.CENTER);
                label.setIconTextGap(0);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setHorizontalAlignment(JLabel.CENTER);
                this.add(label);
            } else {
                this.setBackground(new Color(22, 224, 22));
            }

            this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0x000000)));
        }
    }
    public void select_set (int[][]map){
        if (!this.isSelected) {
            isSelected = true;
            if (!this.isOccupied) {
                map[this.position.y][this.position.x] = 1;
                System.out.println("done");
                ImageIcon red_X = new ImageIcon(new ImageIcon("anchor.png")
                        .getImage()
                        .getScaledInstance
                                (this.getWidth() / 2,
                                        this.getWidth() / 2,
                                        Image.SCALE_DEFAULT));

                JLabel label = new JLabel();
                label.setIcon(red_X);
                label.setAlignmentX(JLabel.CENTER);
                label.setAlignmentY(JLabel.CENTER);
                label.setIconTextGap(0);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setHorizontalAlignment(JLabel.CENTER);
                this.add(label);
            }
            this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0x000000)));
        }
    }
}


