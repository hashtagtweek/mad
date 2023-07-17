import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.os.CountDownTimer


class MainActivity : AppCompatActivity() {
private lateinit var counterValue:TextView
private lateinit var startCounter : Button
private lateinit var stopCounter : Button
private lateinit var resetCounter : Button

val timer = MyCounter(10000000, 10)
var countervalue : Int = 0
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)

counterValue = findViewById(R.id.counter_value)
startCounter = findViewById(R.id.start_counter)

startCounter.setOnClickListener {
timer.start()
startCounter.isEnabled=false
}
stopCounter = findViewById(R.id.stop_counter)
stopCounter.setOnClickListener {
timer.cancel()
startCounter.isEnabled=true
}
resetCounter = findViewById(R.id.reset_counter)
resetCounter.setOnClickListener {

countervalue = 0
counterValue.text = (countervalue).toString()
}

}

inner class MyCounter(millisInFuture: Long, countDownInterval: Long) :
CountDownTimer(millisInFuture, countDownInterval) {
override fun onFinish() {
}

override fun onTick(millisUntilFinished: Long) {
countervalue++
counterValue.text = (countervalue).toString()
}
}
}

xml


<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">

<com.google.android.material.textview.MaterialTextView
android:id="@+id/counter_value"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginTop="8dp"
android:layout_marginBottom="8dp"
android:text="Counter Value"
android:textSize="24sp"
app:layout_constraintBottom_toTopOf="@+id/start_counter"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintHorizontal_bias="0.5"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toTopOf="parent"
app:layout_constraintVertical_bias="0.25"
app:layout_constraintVertical_chainStyle="packed" />

<com.google.android.material.button.MaterialButton
android:id="@+id/start_counter"
android:layout_width="wrap_content"
android:layout_height="54dp"
android:layout_marginTop="8dp"
android:layout_marginBottom="8dp"
android:text="Start"
app:layout_constraintBottom_toTopOf="@+id/stop_counter"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintHorizontal_bias="0.5"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/counter_value" />

<com.google.android.material.button.MaterialButton
android:id="@+id/stop_counter"
android:layout_width="wrap_content"
android:layout_height="54dp"
android:layout_marginTop="8dp"
android:layout_marginBottom="8dp"
android:text="Stop"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintHorizontal_bias="0.5"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/start_counter" />

<com.google.android.material.button.MaterialButton
android:id="@+id/reset_counter"
android:layout_width="wrap_content"
android:layout_height="54dp"
android:layout_marginTop="8dp"
android:layout_marginBottom="8dp"
android:text="Reset"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintHorizontal_bias="0.5"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/start_counter" />
</androidx.constraintlayout.widget.ConstraintLayout>
