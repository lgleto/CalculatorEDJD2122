package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

enum class Operator {
    add,
    divide,
    subtract,
    multiply
}

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textViewDisplay : TextView
    var userIsInTheMiddleOfIntroduction = false

    var operator : Operator? = null
    var operand = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val button0 = findViewById<Button>(R.id.button0)
        val buttonDot = findViewById<Button>(R.id.buttonDot)
        val buttonAC = findViewById<Button>(R.id.buttonAC)
        val buttonPlus     = findViewById<Button>(R.id.buttonPlus    )
        val buttonMinus    = findViewById<Button>(R.id.buttonMinus   )
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide   = findViewById<Button>(R.id.buttonDivide  )
        val buttonEqual    = findViewById<Button>(R.id.buttonEqual   )


        textViewDisplay = findViewById<TextView>(R.id.textViewDisplay)
        button1.setOnClickListener {
            textViewDisplay.text = "${textViewDisplay.text}1"
        }

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button0.setOnClickListener(this)
        buttonDot.setOnClickListener(this)

        buttonPlus.setOnClickListener(doOperation)
        buttonMinus.setOnClickListener(doOperation)
        buttonMultiply.setOnClickListener(doOperation)
        buttonDivide.setOnClickListener(doOperation)
        buttonEqual.setOnClickListener {
            userIsInTheMiddleOfIntroduction = false
            performOperation()
        }

        buttonAC.setOnClickListener{
            textViewDisplay.text = "0"
            userIsInTheMiddleOfIntroduction = false
        }
    }

    fun performOperation() {
        operator?.let { op ->
            when(op) {
                Operator.add -> {
                    operand += textViewDisplay.text.toString().toDouble()
                }
                Operator.subtract -> {

                }
                Operator.multiply -> {

                }
                Operator.divide -> {

                }
            }
        }




        if (operand.rem(1)==0.0) {
            textViewDisplay.text = operand.toInt().toString()
        }else {
            textViewDisplay.text = operand.toString()
        }


    }

    val doOperation = object : View.OnClickListener{
        override fun onClick(view: View?) {
            val buttonPressed = view as Button
            operator = when (buttonPressed.text) {
                "+" ->  Operator.add
                "-" ->  Operator.subtract
                "*" ->  Operator.multiply
                "/" ->  Operator.divide
                else -> null
            }
            operand = textViewDisplay.text.toString().toDouble()
            userIsInTheMiddleOfIntroduction = false
        }

    }




    override fun onClick(view: View?) {
        val buttonPressed = view as Button
        if (userIsInTheMiddleOfIntroduction){
            if(!buttonPressed.text.equals(".")){
                textViewDisplay.text = "${textViewDisplay.text}${buttonPressed.text}"
            }else {
                if (!textViewDisplay.text.contains(".")){
                    textViewDisplay.text = "${textViewDisplay.text}${buttonPressed.text}"
                }
            }
        }else{
            textViewDisplay.text = buttonPressed.text
            if(buttonPressed.text.equals(".")){
                textViewDisplay.text = "0."
            }
            userIsInTheMiddleOfIntroduction = true
        }



    }
}