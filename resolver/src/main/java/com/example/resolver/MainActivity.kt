package com.example.resolver

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        label.setOnClickListener {
//            contentResolver?.query("content://com.flat.nemo/case".toUri(),null, null, null, null, null)
//            contentResolver?.delete("com.flat.nemo".toUri(),null, null)
            try {
                val res=contentResolver?.insert("content://com.flat.nemo/case".toUri(), ContentValues())
                Log.d("contentprovidercase",res.toString())
            }catch (e:Exception){
                Log.d("contentprovidercase",e.toString())
            }

        }
    }
}
