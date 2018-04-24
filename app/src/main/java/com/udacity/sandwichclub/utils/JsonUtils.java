package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        String mainName, placeOfOrigin, description, image;
        List<String> alsoKnownAs, ingredients;
        System.out.println("json in parse " + json);
        if (json == null || json.isEmpty()) {
            return null;
        } else {
            try {
                alsoKnownAs = new ArrayList<>();
                ingredients = new ArrayList<>();
                JSONObject sandwich = new JSONObject(json);
                JSONObject name = sandwich.getJSONObject("name");
                mainName = name.getString("mainName");
                placeOfOrigin = sandwich.getString("placeOfOrigin");
                description = sandwich.getString("description");
                image = sandwich.getString("image");
                JSONArray array1 =  name.getJSONArray("alsoKnownAs");
                JSONArray array2 = sandwich.getJSONArray("ingredients");
                for (int i = 0; i < array1.length(); i++) {
                    alsoKnownAs.add((String) array1.get(i));
                }
                for (int i = 0; i < array2.length(); i ++) {
                    ingredients.add((String) array2.get(i));
                }

                return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
            } catch (JSONException e) {
                System.out.println("lol" + e.getMessage());
                e.printStackTrace();
            }

            return null;
        }
    }
}
