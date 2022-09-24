package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumberstoButtons()
        button1.setOnClickListener {
            checkAnswer(true)
            assignNumberstoButtons()
        }

        button2.setOnClickListener {
            checkAnswer(false)
            assignNumberstoButtons()
        }
    }

    private fun checkAnswer(isLeftBtnSelected: Boolean){
        val lbutton = button1.text.toString().toInt()
        val rbutton = button2.text.toString().toInt()

        val LeftButton = if(isLeftBtnSelected) lbutton > rbutton else lbutton < rbutton
        if(LeftButton){
            tvHeading.setBackgroundColor(Color.GREEN)
            Toast.makeText(this,"Correct Answer",Toast.LENGTH_SHORT).show()
        }
        else{
            tvHeading.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong Answer",Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumberstoButtons() {
        val leftnum = Random.nextInt(10)  //Assigning random values
        var rightnum = leftnum
        while (leftnum == rightnum){      // To avoid leftnum and rightnum from being equal
            rightnum = Random.nextInt(10)
        }
        button1.text = leftnum.toString()
        button2.text = rightnum.toString()
    }
}
