package entity;

public class ShipStatus {

    public final Ship ship;
    public int hitCount;
    public Boolean destroyed;

    public ShipStatus(Ship ship) {
        this.ship = ship;
        this.hitCount = 0;
        this.destroyed = false;
    }

    public String handleAttack(Position position) {
        for (Position shipPositions : this.ship.positions) {
            if (position.equals(shipPositions)) {
                hitCount++;
                if (hitCount == this.ship.positions.length) {
                    this.destroyed = true;
                    return "HIT_AND_DESTROY_SHIP";
                }
                return "HIT";
            }
        }
        return "NOT_HIT";
    }

}
