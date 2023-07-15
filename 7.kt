import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import java.util.*



class MainActivity : AppCompatActivity() {
private lateinit var speakBtn:Button
private lateinit var userText:EditText
private lateinit var seekBerPitch:SeekBar
private lateinit var seekBerSpeed:SeekBar
private lateinit var mTTs :TextToSpeech


override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)


speakBtn = findViewById(R.id.btnSpeak)
userText = findViewById(R.id.edTv)
seekBerPitch = findViewById(R.id.seekBar_pitch)
seekBerSpeed = findViewById(R.id.seekBar_speed)

mTTs = TextToSpeech(this){status->
if (status == TextToSpeech.SUCCESS){
val result = mTTs.setLanguage(Locale.ENGLISH)
if (result == TextToSpeech.LANG_MISSING_DATA
|| result == TextToSpeech.LANG_NOT_SUPPORTED){
Log.e("TTs","Language is not Supported")


}else{
speakBtn.isEnabled = true
}
}
else{
Log.e("TTs","Initialization failed")
}
}
speakBtn.setOnClickListener { speak() }
}

@Suppress("DEPRECATION")
private fun speak() {
val text = userText.text.toString()
var pitch = seekBerPitch.progress.toFloat()/50
if (pitch<0.1) pitch = 0.1f
var speed = seekBerSpeed.progress.toFloat()/50
if (speed<0.1) speed = 0.1f
mTTs.setPitch(pitch)
mTTs.setSpeechRate(speed)
mTTs.speak(text,TextToSpeech.QUEUE_FLUSH,null)

}

override fun onDestroy() {
if (mTTs != null){

mTTs.stop()
mTTs.shutdown()
}
super.onDestroy()
}

}



Manifest


<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
package="com.example.">

<queries>
<intent>
<action android:name="android.intent.action.TTS_SERVICE" />
</intent>
</queries>

<application
android:allowBackup="true"
android:icon="@mipmap/ic_launcher"
android:label="@string/app_name"
android:roundIcon="@mipmap/ic_launcher_round"
android:supportsRtl="true"
android:theme="@style/Theme.TextToSpeech">
<activity android:name=".MainActivity">
<intent-filter>

<action android:name="android.intent.action.MAIN" />
<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
</activity>
</application>
</manifest>