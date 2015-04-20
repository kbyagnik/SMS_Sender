package com.example.root.sms_sender;

import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.provider.Settings.Secure;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by DC on 27/3/15.
 */



public class MainActivity extends Activity implements OnItemClickListener {
 //   private final static String final_status="";
    private static MainActivity inst;
    ArrayList<String> msgList = new ArrayList<String>();//check
    ListView msgListView;
    ArrayAdapter arrayAdapter;

    public static MainActivity instance() {
        return inst;
    }

    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgListView = (ListView) findViewById(R.id.smsList); // place in .xml
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, msgList);
        msgListView.setAdapter(arrayAdapter);
        msgListView.setOnItemClickListener(this);

        //checkinbox();



    }

    public void updateList(final String smsMessage) {
        arrayAdapter.insert(smsMessage, 0);
        arrayAdapter.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        try {
            String[] Msgs = msgList.get(pos).split("\n");
            String address = Msgs[0];
            String smsMessage = "";
            for (int i = 1; i < Msgs.length; ++i) {
                smsMessage += Msgs[i];
            }

            String smsMessageStr = address + "\n";
            smsMessageStr += smsMessage;
            Toast.makeText(this, smsMessageStr, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void updateSMSOnServer(final String sender,final String txt){
        String tag_string_req = "putsms";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Serverconfig.SMS_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String serverResponse) {

                try {
                    JSONObject jObj = new JSONObject(serverResponse);
                    boolean error = jObj.getBoolean("error");
                    if (error) {
                        String errorMessage = jObj.getString("error_msg");
                        //               Toast.makeText(getApplicationContext(),
                        //                     errorMessage, Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError smsUpdateError) {
                //   Toast.makeText(getApplicationContext(),
                //           msgUpdateError.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {

                Long tsLong = System.currentTimeMillis()/1000;
                String ts = tsLong.toString();

                Map<String, String> parameters = new HashMap<String, String>();
               // String android_id = Secure.getString(MainActivity.this.getApplicationContext().getContentResolver(),
              //         Secure.ANDROID_ID);
                //Log.d("test ",android_id);
                //Toast.makeText(this, deviceId, Toast.LENGTH_SHORT).show();
                parameters.put("tag", "putsms");
                //parameters.put("uid",android_id);
                parameters.put("address",sender);
                parameters.put("tym",ts);
                parameters.put("messg", txt);

                return parameters;
            }

        };
        Log.d("tag",tag_string_req );
        //Log.d("aaaloo",stringRequest);
        Servermanage.getInstance().addToRequestQueue(stringRequest,tag_string_req);



       // getStatus(sender, txt);


    }


    public static void getStatus(final String sender,final String txt)
    {
        final String[] elements = txt.split(" ") ;
        if (!elements[0].equals("Booking") || !elements[1].equals("Status") || elements[2].isEmpty())
        {
            //final String statusgot;
            String tag_string_req = "status";

            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    Serverconfig.SMS_URL, new Response.Listener<String>() {

                @Override
                public void onResponse(String serverResponse) {

                    try {
                        JSONObject jObj = new JSONObject(serverResponse);
                        String statusgot="";
                        statusgot=jObj.getString("status");

                        Log.d("status is ", statusgot);

                        SmsManager smsManager = SmsManager.getDefault() ;
                        Log.d("sendSMS", "Sending the SMS for "+ statusgot + " to " + sender ) ;
                        smsManager.sendTextMessage(sender, null, statusgot, null, null) ;

                        boolean error = jObj.getBoolean("error");
                        if (error) {
//                            String errorMessage = jObj.getString("error_msg");
                            //               Toast.makeText(getApplicationContext(),
                            //                     errorMessage, Toast.LENGTH_LONG).show();
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError smsUpdateError) {
                    //   Toast.makeText(getApplicationContext(),
                    //           msgUpdateError.getMessage(), Toast.LENGTH_LONG).show();

                }
            }) {

                @Override
                protected Map<String, String> getParams() {


                    Map<String, String> parameters = new HashMap<String, String>();
                    // String android_id = Secure.getString(MainActivity.this.getApplicationContext().getContentResolver(),
                    //         Secure.ANDROID_ID);
                    //Log.d("test ",android_id);
                    //Toast.makeText(this, deviceId, Toast.LENGTH_SHORT).show();
                    parameters.put("tag", "status");
                    //parameters.put("uid",android_id);
                    parameters.put("uid",elements[2]);
                    Log.d("element2",elements[2]);
                    return parameters;
                }

            };
            Log.d("tag",tag_string_req );
            //Log.d("aaaloo",stringRequest);
            Servermanage.getInstance().addToRequestQueue(stringRequest,tag_string_req);



            return ;
        }
        return ;

    }

}
