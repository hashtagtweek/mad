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


  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:gravity="center"
tools:context=".MainActivity">

<ScrollView
android:layout_width="match_parent"
android:layout_height="wrap_content">
<LinearLayout
android:orientation="vertical"
android:layout_width="match_parent"
android:layout_height="wrap_content">
<EditText
android:id="@+id/edTv"
android:hint="Enter Text"
android:textSize="19sp"
android:textStyle="bold"
android:layout_margin="15dp"
android:padding="15dp"

android:textColor="@color/purple_500"
android:layout_width="match_parent"
android:layout_height="wrap_content"/>
<TextView
android:text="Pitch"
android:textColor="@color/purple_500"
android:textStyle="bold"
android:textSize="18sp"
android:layout_margin="10dp"
android:layout_width="wrap_content"
android:layout_height="wrap_content"/>
<SeekBar
android:id="@+id/seekBar_pitch"
android:progress="50"
android:layout_width="200dp"
android:layout_height="wrap_content"/>
<TextView
android:text="Speed"
android:textColor="@color/purple_500"
android:textStyle="bold"
android:textSize="18sp"
android:layout_margin="10dp"
android:layout_width="wrap_content"
android:layout_height="wrap_content"/>
<SeekBar
android:id="@+id/seekBar_speed"
android:progress="50"
android:layout_width="200dp"

android:layout_height="wrap_content"/>
<Button
android:id="@+id/btnSpeak"
android:text="Convert text to speech!"
android:textSize="19sp"
android:textStyle="bold"
android:textAllCaps="false"
android:layout_gravity="center"
android:layout_margin="20dp"
android:layout_width="wrap_content"
android:layout_height="wrap_content"/>

</LinearLayout>
</ScrollView>
</LinearLayout>
