package com.android.notessqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.notessqlite.databinding.ActivityAddNoteBinding
import com.android.notessqlite.databinding.ActivityMainBinding

class AddNoteACtivity : AppCompatActivity() {
    private  lateinit var binding: ActivityAddNoteBinding
    private lateinit var db:NoteDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NoteDatabaseHelper(this)
        binding.savebutton.setOnClickListener{
            val title = binding.titlEditText.text.toString()
            val content = binding.contentedittext.text.toString()
            val note = Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show()
        }

    }
}