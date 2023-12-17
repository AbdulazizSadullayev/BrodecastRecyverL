package uz.coder.brodecastrecyverl

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.coder.brodecastrecyverl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val myReciever= object :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action
            when(action){
                MyReciever.CUSTOM_BROADCAST_FROM_SERVISE ->{
                    val percent = intent.getIntExtra("percent", 0)
                    binding.apply {
                        button.setOnClickListener {
                            progress.progress = percent
                        }

                    }
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_BATTERY_CHANGED)
            addAction(MyReciever.CUSTOM_BROADCAST)
            addAction(MyReciever.CUSTOM_BROADCAST_FROM_SERVISE)
        }
        registerReceiver(myReciever,intentFilter)
        Intent(this,MyServise::class.java).apply {
            startService(this)
        }

//        binding.apply {
//            button.setOnClickListener {
//                val intent = Intent(MyReciever.CUSTOM_BROADCAST)
//                sendBroadcast(intent)
//            }
//        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReciever)
    }
}