package uz.coder.brodecastrecyverl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlin.concurrent.thread

class MyServise:Service() {


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread {
            for (i in 1..100 step 5) {
                Thread.sleep(1000)
                var broadcast = Intent(MyReciever.CUSTOM_BROADCAST_FROM_SERVISE).apply {
                    putExtra("percent", i)
                }
                sendBroadcast(broadcast)
            }

        }
        return super.onStartCommand(intent, flags, startId)
    }








    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}