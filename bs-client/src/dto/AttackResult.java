package dto;


import entity.Ship.Ship;

import java.io.Serializable;

public class AttackResult implements Serializable {
    public Boolean hit;
    public Boolean destroy;
    public Ship ship;

    public AttackResult(Boolean hit, Boolean destroy, Ship ship) {
        this.hit = hit;
        this.destroy = destroy;
        this.ship = ship;
    }

    public AttackResult(Boolean hit, Boolean destroy) {
        this.hit = hit;
        this.destroy = destroy;
    }
}
