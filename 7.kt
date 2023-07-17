import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar

class MainActivity : AppCompatActivity()
{
    private lateinit var tts : TextToSpeech
    private lateinit var e1 : EditText
    private lateinit var b1 : Button
    private lateinit var pitchbar : SeekBar
    private lateinit var speedbar : SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        e1 = findViewById(R.id.edtext)
        b1 = findViewById(R.id.texttospeech)
        pitchbar = findViewById(R.id.setpitch)
        speedbar = findViewById(R.id.setspeachrate)

        b1.setOnClickListener {

            var pitch = pitchbar.progress.toFloat()/50
            if (pitch < 0.1) pitch = 0.1f

            var speed = speedbar.progress.toFloat()/50
            if (speed < 0.1 ) speed = 0.1f


            tts = TextToSpeech(applicationContext,TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS)
                {
                    tts.setPitch(pitch)
                    tts.setSpeechRate(speed)
                    tts.speak(e1.text.toString(),TextToSpeech.QUEUE_ADD,null)
                }
            })

        }
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

xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/edtext"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="101dp"
        android:layout_marginTop="84dp"
        android:layout_marginEnd="101dp"
        android:ems="10"
        android:gravity="start|top"
        android:inputType="textMultiLine"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="SpeakableTextPresentCheck,TouchTargetSizeCheck" />

    <Button
        android:id="@+id/texttospeech"
        android:layout_width="192dp"
        android:layout_height="60dp"
        android:layout_marginStart="161dp"
        android:layout_marginEnd="156dp"
        android:layout_marginBottom="352dp"
        android:text="TEXT TO SPEECH"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.544"
        app:layout_constraintStart_toStartOf="parent" />

    <SeekBar
        android:id="@+id/setpitch"
        android:layout_width="294dp"
        android:layout_height="34dp"
        android:layout_marginStart="58dp"
        android:layout_marginTop="90dp"
        android:layout_marginEnd="59dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/texttospeech" />

    <SeekBar
        android:id="@+id/setspeachrate"
        android:layout_width="294dp"
        android:layout_height="34dp"
        android:layout_marginStart="58dp"
        android:layout_marginEnd="59dp"
        android:layout_marginBottom="136dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
