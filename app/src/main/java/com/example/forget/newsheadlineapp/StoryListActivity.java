package com.example.forget.newsheadlineapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.GridView;
import org.json.simple.JSONObject;

public class StoryListActivity extends BaseActivity {
    private GridViewModel gridViewModel = new GridViewModel();
    private GridViewPresenter gridViewPresenter = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        createActivity();
    }

    protected void initActivity() {
        super.initActivity();
        GridView gridView = (GridView)findViewById(R.id.grid_view);
        gridViewPresenter = new GridViewPresenter(this, gridView);
    }

    protected void loadData(){
        super.loadData();
        readData();
    }

    private void readData() {
        try {
            ReadDataTask readDataTask = new ReadDataTask();
            readDataTask.execute("https://api.nytimes.com/svc/topstories/v2/home.json?api-key=cf23f0334a174fff975fc2400ccbfdd9");
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    private class ReadDataTask extends AsyncTask<String, String, String>{
        protected String doInBackground(String... params) {
            try{
                return getData(params[0]);
            }catch (Exception exception){
                return "fail";
            }
        }

        protected void onPostExecute(String string) {
            super.onPostExecute(string);
            gridViewPresenter.UpdateData(gridViewModel.getData());
        }

        String getData(String urlString){
            JSONObject jsonObject = appUtil.GetJSONObject(urlString);
            if(jsonObject == null)
                return "fail";

            gridViewModel.setJSONObject(jsonObject);
            return "Success";
        }
    }
}
