package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class TranslatorImpl implements Translator {

    private static HashMap<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("Hello World!","नमस्ते दुनिया!");
    }
    @Override
    public String getTranslatedValue(String text, String locale) {
        if(locale.equals("en_US")){
            return text;
        }
        if(dictionary.containsKey(text)){
            return dictionary.get(text);
        }
        return "Translation not available!";
    }
}
