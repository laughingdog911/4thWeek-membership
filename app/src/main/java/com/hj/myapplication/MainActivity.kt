package com.hj.myapplication

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil

import com.hj.myapplication.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.Date

private fun AlertDialog.Builder.setItems(arrayOf: MutableList<String>) {
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.view = this
    }


    fun onClick(v: View) {
        val phoneNumber = binding.phoneno.text.toString()
        val email = binding.email.text.toString()
        val name = binding.name.text.toString()
        val birthday = binding.bdaydp.text.toString()
        val getPW = binding.pw.text.toString()
        val getCheckPW = binding.checkpw.text.toString()
        val infoList: MutableList<String> =
            mutableListOf(email, name, phoneNumber, getPW, getCheckPW)
        val eulaAgreed = binding.EULAAgree.isChecked
        val infoAgreed = binding.informaticsAgree.isChecked

        val selectedDate = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            binding.bdaydp.text = "${year}. ${month + 1}. ${day}"
        }
        val calendar = Calendar.getInstance()
        when (v) {
            binding.choose -> {

                DatePickerDialog(
                    this, selectedDate, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }


            binding.confirmButton -> {
                val empty = "empty"
                for (i in infoList.indices) {
                    if (infoList[i].isEmpty()) {
                        infoList[i] = empty
                    }
                }
                if (infoList.any { it == empty }) {                            //1. 공백필드 !!!!!!!!
                    AlertDialog.Builder(this).run {
                        setIcon(android.R.drawable.ic_dialog_alert)
                        setTitle("공백 필드")
                        setMessage("모든 필드를 채워주세요.")
                        setPositiveButton("확인", null)
                        show()
                    }
                } else if (!email.contains("@")) {                        //2. 잘못된 이메일 형식
                    AlertDialog.Builder(this).run {
                        setIcon(android.R.drawable.ic_dialog_alert)
                        setTitle("잘못된 이메일")
                        setMessage("잘못된 형식의 이메일입니다.")
                        setPositiveButton("확인", null)
                        show()
                    }
                } else if (getPW.length <= 7) {                                //3. 안전하지 않은 비밀번호
                    AlertDialog.Builder(this).run {
                        setIcon(android.R.drawable.ic_dialog_alert)
                        setTitle("안전하지 않은 비밀번호")
                        setMessage("보안을 위해 8자리 이상의 비밀번호를 설정해주세요.")
                        setPositiveButton("확인", null)
                        show()
                    }
                } else if (getCheckPW != getPW) {                              //4. 비밀번호 확인과 불일치
                    AlertDialog.Builder(this).run {
                        setIcon(android.R.drawable.ic_dialog_alert)
                        setTitle("일치하지 않는 비밀번호")
                        setMessage("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
                        setPositiveButton("확인", null)
                        show()
                    }
                } else if (!(eulaAgreed && infoAgreed)) {                       //5. 계약서 미동의
                    AlertDialog.Builder(this).run {
                        setIcon(android.R.drawable.ic_dialog_alert)
                        setTitle("동의 필요")
                        setMessage("최종 사용권 계약과 개인정보 수집 및 처리 방침을 읽고 동의해주세요.")
                        setPositiveButton("확인", null)
                        show()
                    }
                } else {                                                       //6. 마지막 회원가입 확인
                    AlertDialog.Builder(this).run {
                        setTitle("회원가입")
                        setMessage("다음 정보로 가입을 진행하시겠습니까?\n" +
                                "${name}\n" +
                                "${email}\n" +
                                "${birthday}\n" +                           //회원 유형도 넣기!!!!!!
                                "${phoneNumber}")
                        setIcon(android.R.drawable.ic_dialog_info)
                        setPositiveButton("예") { dialogInterface, which ->
                            dialogInterface.dismiss()
                            binding.confirmButton.visibility = View.INVISIBLE
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        setNegativeButton("아니오") { dialogInterface, which ->
                            dialogInterface.dismiss()
                        }
                        show()
                    }
                }
            }
        }
    }
}








