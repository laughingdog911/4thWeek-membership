package com.hj.myapplication

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.hj.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.view = this
    }


    fun onClick(v: View) {
        lateinit var birthday: String
        val phoneNumber = binding.phoneno.text
        val memberType = binding.membertype.text
        val email = binding.email.text
        val name = binding.name.text
        val infoList = listOf(email, name, birthday, phoneNumber, memberType)

        val at: Char = '@'
        var tag = email[0]
        val l: Int = email.length

        val EULAAgreed = binding.EULAAgree.isChecked
        val InfoAgreed = binding.informaticsAgree.isChecked

        when (v) {
            binding.choose -> {
                val datePicker =
                    DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth -> //why set as a val...?
                        birthday = "${year}, ${month + 1}, ${dayOfMonth}"
                    }
                val eventHandler = DialogInterface.OnClickListener { p0, p1 ->
                    if (p1 == DialogInterface.BUTTON_NEGATIVE)
                        null else if (p1 == DialogInterface.BUTTON_POSITIVE) {
                            birthday = binding.bdaydp.text.toString()
                    }
                }
            }
            binding.confirmButton -> {

                for (i in infoList) {
                    if (i == null) AlertDialog.Builder(this).run {
                        setTitle("공백 필드")
                        setMessage("모든 필드를 채워주세요.")
                        setPositiveButton("확인", null)
                        show()
                    }
                }

                for (c in email) {
                    if (tag != at) {
                        tag = email[+1]
                        when (tag == email[l - 1]) {
                            true -> AlertDialog.Builder(this).run {
                                setTitle("잘못된 이메일")
                                setMessage("잘못된 형식의 이메일입니다.")
                                setPositiveButton("확인", null)
                                show()
                            }

                            false -> null

                        }
                    }

                }

                val getPW = binding.pw.text
                if (getPW.length != 7){    //비밀번호의 길이가 8이 아니라면,
                    AlertDialog.Builder(this). run {
                        setTitle("안전하지 않은 비밀번호")
                        setMessage("보안을 위해 8자리 이상의 비밀번호를 설정해주세요.")
                        setPositiveButton("확인", null)
                        show()           //Dialog 띄우기.
                    }
                }

                val getCheckPW = binding.checkpw.text
                if (getCheckPW != getPW) {
                    AlertDialog.Builder(this).run {
                        setTitle("일치하지 않는 비밀번호")
                        setMessage("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
                        setPositiveButton("확인", null)
                        show()
                    }
                }


                if (EULAAgreed && InfoAgreed) {
                    null
                } else {
                    AlertDialog.Builder(this).run {
                        setTitle("동의 필요")
                        setMessage("최종 사용권 계약과 개인정보 수집 및 처리 방침을 읽고 동의해주세요.")
                        setPositiveButton("확인", null)
                    }
                }
            }

            else {
                AlertDialog.Builder(this).run {
                    setTitle("회원가입")
                    setMessage("다음 정보로 가입을 진행하시겠습니까?")
                    setItems(infoList)
                    setPositiveButton("예", null)
                    setNegativeButton("아니오", null)
                }
            }
        }
    }
}







