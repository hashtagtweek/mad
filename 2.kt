import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
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
private lateinit var addition: TextView
private lateinit var subtraction: TextView
private lateinit var multiplication: TextView
private lateinit var division: TextView
private lateinit var equals : TextView
private lateinit var clear: TextView
private lateinit var dot: TextView
private lateinit var result : TextView
private lateinit var expression : TextView

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)

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
dot = findViewById(R.id.dot)
clear = findViewById(R.id.clear)
addition = findViewById(R.id.addition)
subtraction = findViewById(R.id.subtraction)
division= findViewById(R.id.division)
multiplication = findViewById(R.id.multiplication)
equals = findViewById(R.id.equals)
result = findViewById(R.id.result)
expression = findViewById(R.id.expression)

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

addition.setOnClickListener {
pressButton("+", true)
}

subtraction.setOnClickListener {
pressButton("-", true)
}
multiplication.setOnClickListener {
pressButton("*", true)
}
division.setOnClickListener {
pressButton("/", true)
}
dot.setOnClickListener {
pressButton(".", true)
}
clear.setOnClickListener {
result.text = ""
expression.text = ""
}
equals.setOnClickListener {
val text = expression.text.toString()
val expression = ExpressionBuilder(text).build()
val expResult = expression.evaluate()
val longResult = expResult.toLong()
if (expResult == longResult.toDouble()) {
result.text = longResult.toString()
} else {
result.text = result.toString()
}
}
}
fun pressButton(string: String, clear: Boolean) {
if(clear) {
result.text = ""
expression.append(string)
} else {
expression.append(result.text)
expression.append(string)
result.text = ""
}
}
}

paste in  implementation 'net.objecthunter:exp4j:0.4.8'  in app level gradle



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

<com.google.android.material.textview.MaterialTextView
android:id="@+id/expression"
android:layout_width="400dp"
android:layout_height="100dp"
android:textSize="20sp"
android:gravity="center"/>
<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

<com.google.android.material.textview.MaterialTextView
android:id="@+id/result"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:textSize="24sp"/>

<com.google.android.material.textview.MaterialTextView
android:id="@+id/clear"
android:layout_width="400dp"
android:layout_height="100dp"
android:gravity="center"
android:text="C"
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
android:layout_height="50dp"
android:gravity="center"
android:text="2"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/three"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="3"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/division"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="/"
android:textSize="24sp" />

</LinearLayout>

<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

<com.google.android.material.textview.MaterialTextView
android:id="@+id/four"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="4"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/five"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="5"
android:textSize="24sp" />
<com.google.android.material.textview.MaterialTextView
android:id="@+id/six"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="6"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/multiplication"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="*"
android:textSize="24sp" />

</LinearLayout>

<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

<com.google.android.material.textview.MaterialTextView
android:id="@+id/seven"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="7"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/eight"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="8"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/nine"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="9"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/subtraction"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="-"
android:textSize="24sp" />

</LinearLayout>
<LinearLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="horizontal">

<com.google.android.material.textview.MaterialTextView
android:id="@+id/dot"
android:layout_width="100dp"
android:layout_height="100dp"
android:gravity="center"
android:text="."
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/zero"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="0"
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/equals"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="="
android:textSize="24sp" />

<com.google.android.material.textview.MaterialTextView
android:id="@+id/addition"
android:layout_width="100dp"
android:layout_height="50dp"
android:gravity="center"
android:text="+"
android:textSize="24sp" />
</LinearLayout>
</LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
