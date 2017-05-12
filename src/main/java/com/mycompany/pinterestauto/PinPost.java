/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pinterestauto;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author SaiBack
 */
public class PinPost {

    public void pin(String url, String imgUrl, String token,String note) {
        try {
            String board = firstOrCreateBoard(token);
            if (board != null) {
                HttpResponse<String> result = Unirest.post("https://api.pinterest.com/v1/pins/")
                        .queryString("access_token", token)
                        .field("board", board)
                        .field("link", url)
                        .field("note", note)
                        .field("image_url", imgUrl)
                        .asString();
                JSONObject createPin = new JSONObject(result.getBody());
                System.out.println(createPin.toString());
            } else {
                System.out.println("Loi");
            }
        } catch (UnirestException ex) {
            Logger.getLogger(PinPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String firstOrCreateBoard(String token) {
        try {
            JSONObject boardJson = JsonReader.readJsonFromUrl("https://api.pinterest.com/v1/me/boards/?access_token=" + token);
            JSONArray data = boardJson.getJSONArray("data");
            if (data.length() == 0) {
                HttpResponse<String> result = Unirest.post("https://api.pinterest.com/v1/boards/")
                        .queryString("access_token", token)
                        .field("name", "tshirt")
                        .asString();
                JSONObject createJson = new JSONObject(result.getBody());
                JSONObject createBoard = createJson.getJSONObject("data");
                return createBoard.getString("id");
            } else {
                JSONObject createBoard = (JSONObject) data.get(0);
                return createBoard.getString("id");
            }
        } catch (IOException | JSONException | UnirestException ex) {
            Logger.getLogger(PinPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
