package com.gerald.smsapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (!intent?.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)){
            return
        }
        val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)

        smsMessages.forEach {

            val sms = it.displayMessageBody
            val sender = it.displayOriginatingAddress
            Toast.makeText(context,"$sender: $sms ",Toast.LENGTH_LONG ).show()
            Log.d("MESSAGE_RECEIVEDX",sender)
            Log.d("MESSAGE_RECEIVEDX",sms)

            if (sender.contains("713203700") || sms.contains("dear")){
                //abortBroadcast()//stopping the sms from going to the inbox
            }


        }
    }
}