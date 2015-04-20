package com.example.root.sms_sender;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsMessage;
import android.os.Bundle;
import android.provider.Telephony.Sms.Intents;
import android.telephony.SmsMessage;
import android.util.Log;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/*
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

*/
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;




public class Msgstuff extends BroadcastReceiver {
public static final String sms_received = "pdus";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        //Log.v("tag ", action + " / " );
        Bundle intentmsg = intent.getExtras();

        if(intentmsg!=null){

            Object[] msg = (Object[]) intentmsg.get(sms_received);
            String messagerec = "";
            String msgaddress="";
            String msgbody="";
            for(int i=0;i<msg.length;i++){

                SmsMessage sms = SmsMessage.createFromPdu((byte[]) msg[i]);

                String msgtext = sms.getMessageBody().toString();
                String address = sms.getOriginatingAddress();

                messagerec += "Message From: " + address + "\n";
                messagerec += msgtext + "\n";

                msgbody+=msgtext;
                msgaddress+=address;
                            //now we can have the text as well as the address from where we received the message

            }
            Toast.makeText(context, messagerec, Toast.LENGTH_LONG).show();

            //this will update the UI with message

            MainActivity inst = MainActivity.instance();
            inst.updateList(messagerec);
            MainActivity.getStatus(msgaddress,msgbody);

        //    MainActivity inst1 = MainActivity.instance();
        //    inst.updateList(messagerec);
        //    MainActivity.updateSMSOnServer(msgaddress,msgbody);

        }

    }
};


/*
    public void doSMSstuff(){

        IntentFilter iF = new IntentFilter();
        iF.addAction();



    }
*/


