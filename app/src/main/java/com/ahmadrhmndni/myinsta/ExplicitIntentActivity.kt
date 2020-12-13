package com.ahmadrhmndni.myinsta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_explicit_intent.*

class ExplicitIntentActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_HARGA = "extra_harga"
        const val EXTRA_DESKRIPSI = "extra_deskripsi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        txt_nama.text = intent.getStringExtra(EXTRA_NAME)
        txt_harga.text = intent.getStringExtra(EXTRA_HARGA)
        txt_deskripsi.text = intent.getStringExtra(EXTRA_DESKRIPSI)

        btn_back.setOnClickListener {
            val backItem = Intent(this@ExplicitIntentActivity, MainActivity::class.java )
            startActivity(backItem)
        }
    }
}