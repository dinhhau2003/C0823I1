package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService{
    private static Map<String, String> stringMap=new HashMap<>();
    static {
        stringMap.put("dog", "chó");
        stringMap.put("cat", "mèo");
        stringMap.put("tiger", "hổ");
        stringMap.put("lion", "sư tử");
        stringMap.put("fish", "cá");
    }
    @Override
    public String searchEng(String eng) {
        if (stringMap.containsKey(eng)){
            return stringMap.get(eng);
        }
        return "không có trong từ điển";
    }
}
