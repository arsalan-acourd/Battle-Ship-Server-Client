package entity;

import java.io.Serializable;

public class Ship implements Serializable {
    Position[] positions;

    public Ship(Position[] positions) {
        this.positions = positions;
    }
}
