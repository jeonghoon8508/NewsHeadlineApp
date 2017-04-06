package com.example.forget.newsheadlineapp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

class GridViewModel {
    private ArrayList<GridViewItem> gridViewItemArrayList = new ArrayList<>();

    public ArrayList<GridViewItem> getData(){
        return gridViewItemArrayList;
    }

    void setJSONObject(JSONObject jsonObject){
        gridViewItemArrayList.clear();
        parseData(jsonObject);
    }

    private void parseData(JSONObject jsonObject){
        JSONArray items = (JSONArray) (jsonObject.get("results"));
        for (int iItem = 0; iItem < items.size(); iItem++) {
            JSONObject itemObject = (JSONObject) items.get(iItem);
            String titleString = itemObject.get("title").toString();
            String urlString = itemObject.get("url").toString();
            String imageUrlString = "";
            JSONArray multimediaItems = (JSONArray) itemObject.get("multimedia");
            for (int imultimediaItem = 0; imultimediaItem < multimediaItems.size(); imultimediaItem++) {
                JSONObject multimediaItemObject = (JSONObject) multimediaItems.get(imultimediaItem);
                if (multimediaItemObject.get("format").toString().equals("mediumThreeByTwo210")) {
                    imageUrlString = multimediaItemObject.get("url").toString();
                    break;
                }
            }

            if(!titleString.isEmpty() && !urlString.isEmpty() && !imageUrlString.isEmpty()) {
                GridViewItem gridViewItem = new GridViewItem(titleString, urlString, imageUrlString);
                gridViewItemArrayList.add(gridViewItem);
            }
        }
    }
}
