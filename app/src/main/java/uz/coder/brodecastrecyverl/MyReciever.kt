package uz.coder.brodecastrecyverl

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReciever:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        when(action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED->{
                val booleanExtra = intent.getBooleanExtra("state",false)
                var status = if(booleanExtra)"yondi" else "o'chdi"
                Toast.makeText(context, "Airplane Mode $status", Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_BATTERY_CHANGED ->{
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
            }
            CUSTOM_BROADCAST ->{
                Toast.makeText(context, "cutom broadcast bosildi", Toast.LENGTH_SHORT).show()
            }
            CUSTOM_BROADCAST_FROM_SERVISE ->{
                val percent = intent.getIntExtra("percent", 0)
                Toast.makeText(context, "percent $percent", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object{
        const val CUSTOM_BROADCAST = "custom_broadcast"
        const val CUSTOM_BROADCAST_FROM_SERVISE = "loader"
    }

}