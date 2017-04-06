package com.example.forget.newsheadlineapp;

class GridViewItem {
    private String  titleString;
    private String  imageUrlString;
    private String  urlString;

    GridViewItem(String _titleString, String _urlString, String _imageUrlString){
        titleString     = _titleString;
        urlString       = _urlString;
        imageUrlString  = _imageUrlString;
    }

    String getImageUrlString() {
        return imageUrlString;
    }

    String getTitleString() {
        return titleString;
    }

    String getUrlString() {
        return urlString;
    }
}
