package com.ahmadrhmndni.myinsta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmadrhmndni.myinsta.model.User
import kotlinx.android.synthetic.main.activity_explicit_intent.*

class ParcelActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PRODUCT = "extra_product"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcel)

        val user = intent.getParcelableExtra<User>(EXTRA_PRODUCT) as User

        txt_nama.text = user.name
        txt_harga.text = user.harga
        txt_deskripsi.text =  user.deskripsi

        btn_back.setOnClickListener {
            val backItem = Intent(this@ParcelActivity, MainActivity::class.java )
            startActivity(backItem)
        }
    }
}