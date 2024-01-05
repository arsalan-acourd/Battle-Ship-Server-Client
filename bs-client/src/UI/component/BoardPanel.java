package UI.component;

import entity.Position;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    int[][] map;
    Cell[][] cells;

    //for opponent display
    public BoardPanel() {
        this.setLayout(new GridLayout(10, 10));
        this.setBorder(BorderFactory.createLineBorder(Color.blue));

        cells = new Cell[10][10];

        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                Position position = new Position(i, j);
                cells[i][j] = new Cell(position,true);
                if (map[i][j] == 1)
                    cells[i][j].isOccupied = true;

                this.add(cells[i][j]);
            }
        }
    }

    //for player play
    public BoardPanel(int[][] map,Boolean setter) {
        this.setLayout(new GridLayout(10, 10));
        this.setBorder(BorderFactory.createLineBorder(Color.blue));

        cells = new Cell[10][10];

        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                Position position = new Position(i, j);
                cells[i][j] = new Cell(position,false);
                if (map[i][j] == 1)
                    cells[i][j].isOccupied = true;

                this.add(cells[i][j]);
            }
        }
    }

    //for setting the ship
    public BoardPanel(int[][] map,Boolean lock,Boolean setter) {
        this.setLayout(new GridLayout(10, 10));
        this.setBorder(BorderFactory.createLineBorder(Color.blue));

        cells = new Cell[10][10];

        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                Position position = new Position(j, i);
                cells[i][j] = new Cell(position,false,true,map);
                if (map[i][j] == 1)
                    cells[i][j].isOccupied = true;

                this.add(cells[i][j]);
            }
        }
    }
}
