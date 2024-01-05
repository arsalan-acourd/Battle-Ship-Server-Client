package dto;

import entity.Ship.Ship;

public class SettingShipsDTO extends BaseRequest {
    public SettingShipsDTO(Ship[] ships) {
        super("SETTING_SHIPS", ships);
    }
}
