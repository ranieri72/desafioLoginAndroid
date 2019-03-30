package br.com.ranieri.desafiologin.request;

import android.content.Context;

import com.google.gson.Gson;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Requester {

    private final String wsUrl = "http://192.168.15.10:8080/desafioServer/rest";

    private Context context;

    public Requester(Context context) {
        this.context = context;
    }

    public void start(Object obj, WSmethods method, FutureCallback<String> callback) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        String url = wsUrl + method.toString();

        Ion.with(context)
                .load(url)
                .setStringBody(json)
                .asString()
                .setCallback(callback);
    }
}
