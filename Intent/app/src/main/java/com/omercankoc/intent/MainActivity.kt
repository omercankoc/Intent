package com.omercankoc.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Definition
    var editTextName : EditText? = null
    var editTextSurname : EditText? = null
    var buttonNext : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize
        editTextName = findViewById<View>(R.id.editTextName) as EditText
        editTextSurname = findViewById<View>(R.id.editTextSurname) as EditText
        buttonNext = findViewById<View>(R.id.buttonNext) as Button
    }

    fun onClickNext(view : View){

        /*
        * Intent, uygulama bileşenleri arasında veri alışverişini ve bilgi aktarımını sağlayan bir haberleşme nesnesidir.
        * Bu nesne Android uygulamalarının vazgeçilmez bir bileşenidir.
        * Bir Activity‘ den başka bir Activity‘ e geçişi sağlayan veya bilgi aktarımını yapan bu Intent nesnesidir.
        * Nesne olmasının sebebi Intent sınıfından üretilerek kullanılmasından dolayıdır.
         */

        // Intent nesnesi oluştur.
        val intent = Intent(applicationContext,NextActivity::class.java)
        // Name ve Surname alanlarinin "null" kontrolunu yap.
        if(editTextName!!.text.toString()!="" && editTextSurname!!.text.toString()!=""){

            /*
             * Key-Value tipinde tutulan ve baska Activity'lere gonderilecek verilerin olusturulmasi.
             */
            intent.putExtra("name",editTextName!!.text.toString())
            intent.putExtra("surname",editTextSurname!!.text.toString())
            // Intent'i baslat.
            startActivity(intent)
            // Diger Activity'lere gecerken mevcut Activity'yi "destroy" et.
            finish()
            // Toast Message olustur.
            Toast.makeText(applicationContext,"Hello!",Toast.LENGTH_LONG).show()
        }

        // Aksi halde kullaniciya AlertDialog icerisinde Toast Messsage gonder.
        else{
            // Alert Dialog olustur.
            var alert = AlertDialog.Builder(this)
            // Alert Dialog basligini ata.
            alert.setTitle("Error!")
            // Alert Dialog mesaji olustur.
            alert.setMessage("You have entered missing information. Would you like to reset your information?")
            // Alert Dialog "YES" operasyonu icerigini olustur.
            alert.setPositiveButton("Yes"){dialog, which ->
                val restartIntent = Intent(applicationContext,MainActivity::class.java)
                startActivity(restartIntent)
            }
            // Alert Dialog "NO" operasyonu icerigini olustur.
            alert.setNegativeButton("No"){dialog, which ->
                super.onDestroy()
            }
            // Alert Dialog'u goster.
            alert.show()

        }

    }
}
