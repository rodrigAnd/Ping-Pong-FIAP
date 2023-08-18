package com.example.pingpong

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.pingpong.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var playerOne = 0
    var playerTwo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListner()
        setupButton()
    }

    private fun setupListner() {
        val player1 = intent.getStringExtra("PLAYER1")
        val player2 = intent.getStringExtra("PLAYER2")

        setupView(player1, player2)
    }

    private fun setupView(player1: String?, player2: String?) {
        binding.tvPlayerOneName.text = player1
        binding.tvPlayerTwoName.text = player2
    }

    private fun setupButton() {
        binding.btPlayerOneScore.setOnClickListener {
            ++playerOne
            binding.tvPlayerOneScore.text = playerOne.toString()
        }

        binding.btPlayerTwoScore.setOnClickListener {
            ++playerTwo
            binding.tvPlayerTwoScore.text = playerTwo.toString()
        }
        binding.btFinishMatch.setOnClickListener {
            createAlert()
        }

        binding.btRevenge.setOnClickListener {
            revangeGame()
        }
    }

    private fun revangeGame() {
        playerOne = 0
        playerTwo = 0
        binding.tvPlayerOneScore.text = playerOne.toString()
        binding.tvPlayerTwoScore.text = playerTwo.toString()
    }

    private fun createAlert() {
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(R.string.ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        finish()
                    })
                setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })

                setMessage(R.string.app_name)

                if (playerOne == playerTwo) {
                    setMessage(R.string.empate)
                } else if (playerOne > playerTwo) {
                    setMessage(getString(R.string.vitoria, binding.tvPlayerOneName.text.toString()))
                } else {
                    setMessage(getString(R.string.vitoria, binding.tvPlayerTwoName.text.toString()))
                }
            }


            // Create the AlertDialog
            builder.create()
        }
        alertDialog.show()
    }
}