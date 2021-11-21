package com.example.davaleba3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var resetbtn: Button

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    private lateinit var XScore: TextView
    private lateinit var OScore: TextView

    var XPoint = 0
    var OPoint = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        XScore = findViewById(R.id.XScore)
        OScore = findViewById(R.id.OScore)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        resetbtn = findViewById(R.id.resetbtn)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)

        resetbtn.setOnClickListener() {
            resetGame()
        }


    }

    override fun onClick(clickedView: View?) {

        var buttonNumber = 0

        if (clickedView is Button){

            when(clickedView.id){

                R.id.btn1 -> buttonNumber = 1
                R.id.btn2 -> buttonNumber = 2
                R.id.btn3 -> buttonNumber = 3
                R.id.btn4 -> buttonNumber = 4
                R.id.btn5 -> buttonNumber = 5
                R.id.btn6 -> buttonNumber = 6
                R.id.btn7 -> buttonNumber = 7
                R.id.btn8 -> buttonNumber = 8
                R.id.btn9 -> buttonNumber = 9

            }
            if (buttonNumber != 0){
                playGame(clickedView, buttonNumber)
            }
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.WHITE)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }
        else{
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.WHITE)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (winnerPlayer == 1) {
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT ).show()
        }   else if (winnerPlayer == 2) {
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT ).show()
        }

        if (winnerPlayer == 1) {

            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false

        }

        if (winnerPlayer == 2) {

            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false

        }



    }
    private fun resetGame() {
        activePlayer = 1
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""

        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer = 1

        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true

        btn1.setBackgroundColor(Color.rgb(50, 71, 115))
        btn2.setBackgroundColor(Color.rgb(50, 71, 115))
        btn3.setBackgroundColor(Color.rgb(50, 71, 115))
        btn4.setBackgroundColor(Color.rgb(50, 71, 115))
        btn5.setBackgroundColor(Color.rgb(50, 71, 115))
        btn6.setBackgroundColor(Color.rgb(50, 71, 115))
        btn7.setBackgroundColor(Color.rgb(50, 71, 115))
        btn8.setBackgroundColor(Color.rgb(50, 71, 115))
        btn9.setBackgroundColor(Color.rgb(50, 71, 115))
    }


}