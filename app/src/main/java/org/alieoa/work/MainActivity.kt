package org.alieoa.work

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.alieoa.work.test.TestActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showTest()
    }

    private fun showTest() {
        startActivity(Intent(this,TestActivity::class.java))
    }
}