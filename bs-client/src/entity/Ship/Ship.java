package entity.Ship;

import entity.Position;

import java.io.Serializable;
import java.util.ArrayList;

public class Ship implements Serializable {
    public int length;
    private ArrayList<Position> positions = new ArrayList<>();

    public Ship(int length) {
        this.length = length;

    }
    public void setPositions(Position position_of_ship){
        positions.add(position_of_ship);
    }
    public Position[] getPositions(){
        Position[] final_positions = new Position[this.length];
        for (int i = 0; i < this.length; i++) {
            final_positions[i] = positions.get(i) ;
        }
        return final_positions;
    }
}