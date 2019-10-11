package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeerStorage {

    private Map<BeerType, String> beerMap = new HashMap<>();

    public BeerStorage() {
        beerMap.put(BeerType.BLACK, "Bavaria black");
        beerMap.put(BeerType.WHITE, "El white");
        beerMap.put(BeerType.RED, "Bavaria red");
    }

    public List<String> getBeerList() {
        return new ArrayList<String>(beerMap.values());
    }

    public BeerType getBeerByName(String coloValue) {

        BeerType beer;
        try {
            beer = BeerType.getBeerTypeByColorName(coloValue);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            beer = BeerType.UNKNOWN;
        }

        return beerMap.entrySet().contains(beer) ? beer : BeerType.UNKNOWN;
    }



}
