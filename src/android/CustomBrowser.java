package com.example.custombrowser;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.inappbrowser.InAppBrowser;
import org.apache.cordova.inappbrowser.InAppBrowserDialog;
import org.apache.cordova.inappbrowser.InAppBrowserOptions;
import org.apache.cordova.inappbrowser.InAppBrowserResult;
import org.apache.cordova.inappbrowser.InAppWebView;

public class CustomBrowser extends CordovaPlugin {
    private InAppBrowser inAppBrowser = new InAppBrowser();

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("open")) {
            String url = args.getString(0);
            open(url, callbackContext);
            return true;
        }
        return false;
    }

    private void open(String url, CallbackContext callbackContext) {
        this.cordova.getActivity().runOnUiThread(() -> {
            inAppBrowser.open(url, "", callbackContext);
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        });
    }
}
