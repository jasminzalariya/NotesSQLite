package com.android.notessqlite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.notessqlite.databinding.ActivityMainBinding
import com.android.notessqlite.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db: NoteDatabaseHelper
    private var noteId: Int =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NoteDatabaseHelper(this)
        noteId = intent.getIntExtra("note_id",-1)
        if(noteId == -1){
            finish()
            return
        }
        val note = db.getNoteByID(noteId)
        binding.updatetitlEditText.setText(note.title)
        binding.updatecontentedittext.setText(note.content)

        binding.updateSaveButton.setOnClickListener{
            val newtitle = binding.updatetitlEditText.text.toString()
            val newcontent = binding.updatecontentedittext.text.toString()
            val updateNote= Note(noteId,newtitle,newcontent)
            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"Note Edited", Toast.LENGTH_SHORT).show()
        }
    }
}