package br.com.ranieri.desafiologin.request;

import android.content.Context;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Requester {

    private final String url = "http://example.com/post";

    private Context context;

    public void Requester(Context context) {
        this.context = context;
    }

    public void start(FutureCallback<JsonObject> callback) {
        JsonObject json = new JsonObject();
        json.addProperty("foo", "bar");

        Ion.with(context)
                .load(url)
                .setJsonObjectBody(json)
                .asJsonObject()
                .setCallback(callback);
    }
}
