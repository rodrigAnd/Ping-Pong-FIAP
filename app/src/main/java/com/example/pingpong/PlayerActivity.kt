package com.example.pingpong

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pingpong.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        extras()
    }

    private fun extras() {

        binding.btnStart.setOnClickListener {
            val player1 = binding.etPlayer1.text.toString()
            val player2 = binding.etPlayer2.text.toString()
            if (binding.etPlayer1.text.toString().isBlank() ||
                binding.etPlayer2.text.toString().isBlank()
            ) {
                Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            } else {
                val bundleExtra = Bundle().apply {
                    putString("PLAYER1", player1)
                    putString("PLAYER2", player2)
                }
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtras(bundleExtra)
                }
                startActivity(intent)
            }
        }
    }
}