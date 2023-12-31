
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

var myWallpaperList =
arrayOf(R.drawable.wallpaper1,R.drawable.wallpaper2,R.drawable.wallpaper3,R.drawable.wall
paper4,R.drawable.wallpaper5)

private lateinit var changeWallpaper:Button

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)

changeWallpaper = findViewById(R.id.change_wallpaper)
changeWallpaper.setOnClickListener { setWallpaper() }
}

//@Suppress("DEPRECATION")
fun setWallpaper() {
Toast.makeText(this, "Setting Wallpaper please wait.",
Toast.LENGTH_SHORT).show()
//@Suppress("DEPRECATION", "TrailingComma")
@Suppress("DEPRECATION")
Handler().postDelayed({
for(i in myWallpaperList) {
val bitmap: Bitmap = BitmapFactory.decodeResource(resources, i)
val wallpaperManager = WallpaperManager.getInstance(baseContext)
wallpaperManager.setBitmap(bitmap)
}
}, 2000)
}
}




manifest


<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
package="com.example.">

<uses-permission android:name="android.permission.SET_WALLPAPER" />
<application
android:allowBackup="true"
android:icon="@mipmap/ic_launcher"
android:label="@string/app_name"
android:roundIcon="@mipmap/ic_launcher_round"
android:supportsRtl="true"
android:theme="@style/Theme.Wallpaper">
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
<androidx.constraintlayout.widget.ConstraintLayout
xmlns:android="http://schemas.android.com/apk/res/android"

xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">
<com.google.android.material.button.MaterialButton
android:id="@+id/change_wallpaper"
android:layout_width="wrap_content"
android:layout_height="54dp"
android:text="Change Wallpaper"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintHorizontal_bias="0.5"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
