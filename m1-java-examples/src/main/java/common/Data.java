package common;

import java.util.List;
import java.util.TreeMap;

public class Data {

    public static List<String> CITY_LIST = createTreeMap().values().stream().toList();

    public static TreeMap<Integer, String> CITY_BY_OFFSET = createTreeMap();

    private static TreeMap<Integer, String> createTreeMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(-12, "Baker Island");
        map.put(-11, "Pago Pago");
        map.put(-10, "Honolulu");
        map.put(-9, "Anchorage");
        map.put(-8, "Los Angeles");
        map.put(-7, "Denver");
        map.put(-6, "Mexico City");
        map.put(-5, "New York City");
        map.put(-4, "São Paulo");
        map.put(-3, "Buenos Aires");
        map.put(-2, "Fernando de Noronha");
        map.put(-1, "Praia");
        map.put(0, "London");
        map.put(1, "Prague");
        map.put(2, "Athens");
        map.put(3, "Moscow");
        map.put(4, "Dubai");
        map.put(5, "Islamabad");
        map.put(6, "Dhaka");
        map.put(7, "Bangkok");
        map.put(8, "Beijing");
        map.put(9, "Tokyo");
        map.put(10, "Sydney");
        map.put(11, "Solomon Islands");
        map.put(12, "Auckland");
        return map;
    }

}
