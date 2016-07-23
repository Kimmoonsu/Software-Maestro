package onepercent.mobile.com.onepercent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import java.net.URLDecoder;


public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {
    private static final String TAG = "GCMBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // Explicitly specify that GcmIntentService will handle the intent.
        ComponentName comp = new ComponentName(context.getPackageName(),
                GcmIntentService.class.getName());
        // Start the service, keeping the device awake while it is launching.
        startWakefulService(context, (intent.setComponent(comp)));

        setResultCode(Activity.RESULT_OK);



        String action = intent.getAction();
        Log.d(TAG, "action : " + action);

        if (action != null) {
            if (action.equals("com.google.android.c2dm.intent.RECEIVE")) { // 푸시 메시지 수신 시
                String msg = intent.getStringExtra("msg");
                String content = intent.getStringExtra("content");
                String from_id = intent.getStringExtra("from_id");
                String from_name = intent.getStringExtra("from_name");
                String latitude = intent.getStringExtra("latitude");
                String longitude = intent.getStringExtra("longitude");
                String data = "";

                try {
                    data = URLDecoder.decode(msg, "euc-kr");
                    content = URLDecoder.decode(content, "euc-kr");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // 액티비티로 전달
                sendToActivity(context, data, from_id, from_name, content, latitude, longitude);

            } else {
                Log.d(TAG, "Unknown action : " + action);
            }
        } else {
            Log.d(TAG, "action is null.");
        }
    }

    private void sendToActivity(Context context, String data, String from_id, String from_name, String content, String latitude, String longitude) {
//
//        Intent intent = new Intent(context, CardActivity.class);
//        intent.putExtra("data", data);
////        intent.putExtra("sender", sender);
////        intent.putExtra("receiver", receiver);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        context.startActivity(intent);
    }
}
