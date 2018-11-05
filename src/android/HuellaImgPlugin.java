package com.deka.WSQConvert;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.util.Base64;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.jnbis.api.Jnbis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WSQGenerator extends CordovaPlugin {
	
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("converttoWSQ")) {
            this.convert(args, callbackContext);
            Log.e("Convercion es :",convert(args, callbackContext));
            return true;
        }
        return false;
    }

    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
    }
    
    @TargetApi(Build.VERSION_CODES.O)
    public String convert(JSONArray args, CallbackContext callbackContext) throws JSONException {
    	String base64 = "";
    	String base64Imagen = "";


   	  try {

   			byte[] filedata =Base64.getDecoder().decode(base64);
   			    byte[] gifBytes = Jnbis.wsq()
   	                    .decode(filedata)
   	                    .toGif()
   	                    .asByteArray();

   			base64Imagen= new String(Base64.getEncoder().encode(gifBytes));


   			} catch (Exception e) {
          Log.e("Convercion es error:",e.getMessage());
   				// cordovaCallback.error("Native pasing arguments: " + e.getMessage());

   			}
   	  return base64Imagen;
 
    }
}
