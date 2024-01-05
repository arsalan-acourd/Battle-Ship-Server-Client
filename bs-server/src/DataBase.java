import entity.ShipStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    static Map<String, Boolean> StartStatus = new HashMap<>();
    static Map<String, ArrayList<ShipStatus>> ShipsStatus = new HashMap<>();
    static ArrayList<String> clientIds = new ArrayList<>();
    static String trun = null;
}
