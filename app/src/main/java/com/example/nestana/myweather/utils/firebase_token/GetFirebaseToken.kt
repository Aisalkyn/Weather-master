package com.example.nestana.myweather.firebase_token

import android.os.Build
import android.provider.Settings
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService


class GetFirebaseToken: FirebaseInstanceIdService() {

    private var android_id: String? = null

    var device_name: String? = null


    override fun onTokenRefresh() {
        android_id = Settings.Secure.getString(applicationContext.getContentResolver(),
                Settings.Secure.ANDROID_ID)

        device_name = (Build.MANUFACTURER
                + " " + Build.MODEL + " " + Build.VERSION.RELEASE
                + " " + Build.VERSION_CODES::class.java.fields[android.os.Build.VERSION.SDK_INT].name)

        var deviceToken: String = FirebaseInstanceId.getInstance().getToken()!!
        Log.d("DeviceToken ==> ", deviceToken)

    }

}