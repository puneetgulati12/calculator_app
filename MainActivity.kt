package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    tvOne.setOnClickListener { appendonExpression("1" , true) }
    TvTwo.setOnClickListener { appendonExpression("2" , true) }
    tvThree.setOnClickListener { appendonExpression("3" , true) }
    tvFour.setOnClickListener { appendonExpression("4" , true) }
    tvFive.setOnClickListener { appendonExpression("5" , true) }
    tvSix.setOnClickListener { appendonExpression("6" , true) }
    tvSeven.setOnClickListener { appendonExpression("7" , true) }
    tvEight.setOnClickListener { appendonExpression("8" , true) }
    tvNine.setOnClickListener { appendonExpression("9" , true) }
    TvZero.setOnClickListener { appendonExpression("0" , true) }
    tvDot.setOnClickListener { appendonExpression("." , true) }

    tvDiv.setOnClickListener { appendonExpression("/" , false) }
    tvPlus.setOnClickListener { appendonExpression("+" , false) }
    tvMul.setOnClickListener { appendonExpression("*" , false) }
    tvMinus.setOnClickListener { appendonExpression("-" , false) }
    tvopen.setOnClickListener { appendonExpression("(" , false) }
    tvClose.setOnClickListener { appendonExpression(")" , false) }


        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""}

        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()){
                tvExpression.text = string.substring(0 , string.length-1)
            }
            tvResult.text = ""
        }
        tvEqual.setOnClickListener {
            try {
                val expression  = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()
                if (result == longresult.toDouble()){
                    tvResult.text = longresult.toString()
                }else{
                    tvResult.text = result.toString()
                }
            }catch (e : Exception){
                Log.e("Exception" , "message : " + e.message )

            }
        }
    }
    fun appendonExpression( string : String ,  canClear :Boolean){
        if (tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }
        if (canClear){
            tvResult.text = ""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

}
