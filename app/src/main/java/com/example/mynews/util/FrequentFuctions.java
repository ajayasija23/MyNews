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
        map.put("Sri lanka","sk");
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

    public static LinkedHashMap<String, String> createSourceList(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Google News","google-news-in");
        map.put("The Hindu","the-hindu");
        map.put("The Times of India","the-times-of-india");
        map.put("ABC News","abc-news");
        map.put("Al Jazeera English","al-jazeera-english");
        map.put("Ars Technica","ars-technica");
        map.put("Associated Press","associated-press");
        return map;
    }

    public static List<String> getSourceNames(){
        LinkedHashMap<String, String> map=createSourceList();
        List<String> sources=new ArrayList<>();
        for (String key:map.keySet()){
            sources.add(key);
        }
        return sources;
    }
    public static String getSourceId(String key){
        LinkedHashMap<String, String> map=createSourceList();
        return map.get(key)+",";
    }
}
