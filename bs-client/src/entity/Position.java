package entity;

import java.io.Serializable;

public class Position implements Serializable {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Position position) {
        return this.x == position.x && this.y == position.y;
    }

}
