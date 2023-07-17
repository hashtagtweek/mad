import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
private lateinit var saveBtn: Button
private lateinit var callBtn: Button

private lateinit var zero: TextView
private lateinit var one: TextView
private lateinit var two: TextView
private lateinit var three: TextView
private lateinit var four: TextView
private lateinit var five: TextView
private lateinit var six: TextView
private lateinit var seven: TextView
private lateinit var eight: TextView
private lateinit var nine: TextView
private lateinit var star: TextView
private lateinit var hash: TextView
private lateinit var clear: TextView

 



private lateinit var contact: TextView

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)

saveBtn = findViewById(R.id.save)
callBtn = findViewById(R.id.call)

zero = findViewById(R.id.zero)
one = findViewById(R.id.one)
two = findViewById(R.id.two)
three = findViewById(R.id.three)
four = findViewById(R.id.four)
five = findViewById(R.id.five)
six = findViewById(R.id.six)
seven = findViewById(R.id.seven)
eight = findViewById(R.id.eight)
nine = findViewById(R.id.nine)
star = findViewById(R.id.star)
hash = findViewById(R.id.hash)
clear = findViewById(R.id.clear)

contact = findViewById(R.id.contact)

zero.setOnClickListener {
pressButton("0", true)

 



}

one.setOnClickListener {
pressButton("1", true)
}

two.setOnClickListener {
pressButton("2", true)
}

three.setOnClickListener {
pressButton("3", true)
}

four.setOnClickListener {
pressButton("4", true)
}

five.setOnClickListener {
pressButton("5", true)
}

six.setOnClickListener {
pressButton("6", true)
}

seven.setOnClickListener {
pressButton("7", true)

 



}

eight.setOnClickListener {
pressButton("8", true)
}

nine.setOnClickListener {
pressButton("9", true)
}

star.setOnClickListener {
pressButton("*", true)
}

hash.setOnClickListener {
pressButton("#", true)
}

clear.setOnClickListener {
contact.text = ""
}

callBtn.setOnClickListener {
val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "${contact.text}"))
startActivity(intent)
}

 



saveBtn.setOnClickListener {
val intent = Intent(
ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,
Uri.parse("tel:" + contact.text))
intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE, true)
startActivity(intent)
}

}

fun pressButton(string: String, clear: Boolean) {
if (!clear) {
contact.text = ""
} else {
contact.append(string)
}
}

}




Manifest



<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
package="com.example.">
<uses-permission android:name="android.permission.CALL_PHONE" />
<uses-permission android:name="android.permission.WRITE_CONTACTS" />
<uses-permission android:name="android.permission.READ_CONTACTS" />


<application
android:allowBackup="true"
android:icon="@mipmap/ic_launcher"
android:label="@string/app_name"
android:roundIcon="@mipmap/ic_launcher_round"
android:supportsRtl="true"
android:theme="@style/Theme.PhoneDialer">
<activity android:name=".MainActivity">
<intent-filter>
<action android:name="android.intent.action.MAIN" />
<category android:name="android.intent.category.LAUNCHER" />



 xml



<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">

<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="vertical"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintHorizontal_bias="0.5"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toTopOf="parent">

<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

 


<com.google.android.material.textview.MaterialTextView
android:id="@+id/contact"
android:layout_width="200dp"
android:layout_height="100dp"
android:gravity="center"
android:textSize="24sp"/>

<com.google.android.material.textview.MaterialTextView
android:id="@+id/clear"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="X"
android:textSize="24sp" />

</LinearLayout>

<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

<com.google.android.material.textview.MaterialTextView
android:id="@+id/one"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"


android:text="1"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/two"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="2"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/three"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="3"
android:textSize="24sp" />

</LinearLayout>

<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

<com.google.android.material.textview.MaterialTextView
android:id="@+id/four"

 



android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="4"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/five"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="5"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/six"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="6"
android:textSize="24sp" />

</LinearLayout>

<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

 



<com.google.android.material.textview.MaterialTextView
android:id="@+id/seven"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="7"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/eight"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="8"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/nine"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="9"
android:textSize="24sp" />

</LinearLayout>

<LinearLayout

 



android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

<com.google.android.material.textview.MaterialTextView
android:id="@+id/star"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="*"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/zero"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="0"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/hash"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="#"
android:textSize="24sp" />

 



</LinearLayout>

<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

<com.google.android.material.button.MaterialButton
android:id="@+id/call"
android:layout_width="134dp"
android:layout_height="54dp"
android:layout_margin="8dp"
android:text="Call"/>

<com.google.android.material.button.MaterialButton
android:id="@+id/save"
android:layout_width="134dp"
android:layout_height="54dp"
android:layout_margin="8dp"
android:text="Save"/>

</LinearLayout>

</LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>

 



</intent-filter>
</activity>
</application>
</manifest>
