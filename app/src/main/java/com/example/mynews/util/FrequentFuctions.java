package com.example.mynews.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FrequentFuctions {

    public static LinkedHashMap<String, String> createCountryList(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("India","in");
        map.put("Japan","jp");
        map.put("USA","us");
        map.put("Sri lanka","lk");
        map.put("England","gb");
        map.put("Canada","cn");
        map.put("Australia","au");
        return map;
    }
    public static List<String> getCountryNames(){
        LinkedHashMap<String, String> map=createCountryList();
        List<String> countryNames=new ArrayList<>();
        for (String key:map.keySet()){
            countryNames.add(key);
        }
        return countryNames;
    }
    public static String getCountryCodes(String key){
        LinkedHashMap<String, String> map=createCountryList();
        return map.get(key);
    }
}
