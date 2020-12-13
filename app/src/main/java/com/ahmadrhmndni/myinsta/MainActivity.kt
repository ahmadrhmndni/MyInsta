package com.ahmadrhmndni.myinsta

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.ahmadrhmndni.myinsta.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val  REQUEST_CODE = 100

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple_intent.setOnClickListener {
            val SimpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(SimpleIntent)
        }
        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent (this@MainActivity, ExplicitIntentActivity::class.java)
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_NAME,"Lenovo Legion Y520")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_HARGA," Rp.12.000.000")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_DESKRIPSI,"Lenovo Legion Y520 punya banyak pilihan spesifikasi gahar dengan prosesor Intel Core i7 generasi ke7 Kaby Lake dengan dukungan RAM hingga 16GB. Tentu saja sebagai laptop gaming, Y520 dipersenjatai dengan kartu grafis NVIDIA GTX 1050/TI. Kamu dapat memilih  jenis menyimpanan yang ditawarkan, yakni SSD hingga berkapasitas 512GB atau HDD hingga 2TB.")
            startActivity(dataIntent)
        }

        btn_intent_parcelabel.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcelActivity::class.java)
            val user = User ( "Lenovo Legion Y520", "Rp.12.000.000", "Lenovo Legion Y520 punya banyak pilihan spesifikasi gahar dengan prosesor Intel Core i7 generasi ke7 Kaby Lake dengan dukungan RAM hingga 16GB. Tentu saja sebagai laptop gaming, Y520 dipersenjatai dengan kartu grafis NVIDIA GTX 1050/TI. Kamu dapat memilih  jenis menyimpanan yang ditawarkan, yakni SSD hingga berkapasitas 512GB atau HDD hingga 2TB.")
            parcelIntent.putExtra(ParcelActivity.EXTRA_PRODUCT, user)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "0895601117953"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200) {
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }


}