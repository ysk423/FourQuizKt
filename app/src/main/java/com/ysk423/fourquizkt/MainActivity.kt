package com.ysk423.fourquizkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    //タイトルの配列と、選択肢の二次元配列(正解、選択肢１、選択肢２、選択肢３の順）
    private val quizTitle = arrayOf("問題A","問題B","問題C","問題D")
    private val quizData = arrayOf(
        arrayOf("選択肢（正解）","選択肢（不正解）","選択肢（不正解）","選択肢（不正解）"),
        arrayOf("選択肢（正解）","選択肢（不正解）","選択肢（不正解）","選択肢（不正解）"),
        arrayOf("選択肢（正解）","選択肢（不正解）","選択肢（不正解）","選択肢（不正解）"),
        arrayOf("選択肢（正解）","選択肢（不正解）","選択肢（不正解）","選択肢（不正解）")
    )
    //カウント変数を用意
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //view取得
        val tvCount:TextView = findViewById(R.id.tvCount)
        val tvQuestion:TextView = findViewById(R.id.tvQuestion)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btnNext: Button = findViewById(R.id.btnNext)
        val btnMainClose: Button = findViewById(R.id.btnMainClose)

        //カウント数と、最初の問題を表示
        tvCount.text = "あと4問"
        tvQuestion.text = quizTitle[0]

        //0-3のリストを用意してシャッフル
        val list = listOf(0,1,2,3)
        val num = list.shuffled()

        //ひとまずボタンにquizDataを表示+Nextボタンを無効化
        //シャフルしたnumを入力
        btn0.text = quizData[0][num[0]]
        btn1.text = quizData[0][num[1]]
        btn2.text = quizData[0][num[2]]
        btn3.text = quizData[0][num[3]]
        btnNext.isEnabled = false

        //btn0を押したときの正誤判定
        btn0.setOnClickListener{
            if(btn0.text==quizData[i][0]){
                //正解処理
                correctAns()
            }else{
                //不正解処理
                incorrectAns()
            }
        }

        //btn1を押したときの正誤判定
        btn1.setOnClickListener{
            if(btn1.text==quizData[i][0]){
                //正解処理
                correctAns()
            }else{
                //不正解処理
                incorrectAns()
            }
        }

        //btn2を押したときの正誤判定
        btn2.setOnClickListener{
            if(btn2.text==quizData[i][0]){
                //正解処理
                correctAns()
            }else{
                //不正解処理
                incorrectAns()
            }
        }

        //btn3を押したときの正誤判定
        btn3.setOnClickListener{
            if(btn3.text==quizData[i][0]){
                //正解処理
                correctAns()
            }else{
                //不正解処理
                incorrectAns()
            }
        }

        //Nextボタンを押したときの処理
        btnNext.setOnClickListener {
            i++
            //もう一回シャッフル
            val numNext = list.shuffled()

            //i問目のタイトルと問題を表示
            tvCount.text = "あと" +(4-i)+ "問"
            tvQuestion.text = quizTitle[i]
            btn0.text = quizData[i][numNext[0]]
            btn1.text = quizData[i][numNext[1]]
            btn2.text = quizData[i][numNext[2]]
            btn3.text = quizData[i][numNext[3]]

            //ボタンを有効化する+ネクストボタンの無効化
            btn0.isEnabled=true
            btn1.isEnabled=true
            btn2.isEnabled=true
            btn3.isEnabled=true
            btnNext.isEnabled=false
        }

        //btnMainClose押したときの処理
        btnMainClose.setOnClickListener{
            finish()
        }

    }




    //正解の関数
    private fun correctAns(){
        val tvQuestion:TextView = findViewById(R.id.tvQuestion)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btnNext: Button = findViewById(R.id.btnNext)

        //全問正解条件分岐
        if(i==3){
            //クリア画面へ
            val intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
            finish()
        }else {
            //正解アラートダイアログ
            AlertDialog.Builder(this)
                .setTitle("正解！")
                .setMessage(quizData[i][0])
                .setPositiveButton("OK", null)
                .show()
            //ボタンの無効化+ネクストボタンの有効化
            btn0.isEnabled = false
            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btnNext.isEnabled = true
        }
    }

    //不正解の関数
    private fun incorrectAns(){

        val tvQuestion:TextView = findViewById(R.id.tvQuestion)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btnNext: Button = findViewById(R.id.btnNext)

        //不正解テキスト
        tvQuestion.text="不正解、GameOver"
        //ボタンの無効化
        btn0.isEnabled=false
        btn1.isEnabled=false
        btn2.isEnabled=false
        btn3.isEnabled=false
        btnNext.isEnabled=false
    }


}