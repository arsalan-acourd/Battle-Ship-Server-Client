package dto;


import entity.Position;
import entity.Ship;

import java.io.Serializable;

public class AttackResult implements Serializable {
    public Position position;
    public Boolean hit;
    public Boolean destroy;
    public Ship ship;

    public AttackResult(Boolean hit, Boolean destroy, Ship ship, Position position) {
        this.position = position;
        this.hit = hit;
        this.destroy = destroy;
        this.ship = ship;
    }

    public AttackResult(Boolean hit, Boolean destroy, Position position) {
        this.hit = hit;
        this.destroy = destroy;
        this.position = position;
    }
}
