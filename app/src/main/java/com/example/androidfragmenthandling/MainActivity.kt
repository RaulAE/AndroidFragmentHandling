package com.example.androidfragmenthandling

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfragmenthandling.fragments.fragment1
import com.example.androidfragmenthandling.fragments.fragment2

class MainActivity : AppCompatActivity(), Comm1 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)

        val frag1 = fragment1()
        val frag2 = fragment2()

        // ALlows fragment to be loaded into any 1 container
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, frag1)
            commit()
        }

        btn1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, frag1)
                addToBackStack(null)    //Helps when people hit back button
                commit()
            }
        }

        btn2.setOnClickListener{
            val et1 = findViewById<EditText>(R.id.edit1)
            frag2.arguments = passTheData(et1.text.toString())
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, frag2)
                addToBackStack(null)    //Helps when people hit back button
                commit()
            }
        }
    }

    override fun passTheData(PassingText: String): Bundle {
        val bundle = Bundle()
        bundle.putString("txtAtoB", PassingText)

        return bundle
    }
}