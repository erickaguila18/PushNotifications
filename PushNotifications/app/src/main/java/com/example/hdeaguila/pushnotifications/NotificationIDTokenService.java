package com.example.hdeaguila.pushnotifications;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by hd.eaguila on 25/07/2016.
 */
public class NotificationIDTokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        sendToken(token);
    }

    public void sendToken(String token){

    }
}
