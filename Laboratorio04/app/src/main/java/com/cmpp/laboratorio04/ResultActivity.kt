package com.cmpp.laboratorio04
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        bind()

        intent.extras?.apply {
            val name = intent.getStringExtra("name").toString()
            val email = intent.getStringExtra("email").toString()
            val phone= intent.getStringExtra("phone").toString()
            findViewById<TextView>(R.id.display_result_name).apply {
                text = getString(R.string.text_result_name, name)
            }
            findViewById<TextView>(R.id.display_result_email).apply {
                text = getString(R.string.text_result_email, email)
            }
            findViewById<TextView>(R.id.display_result_phone).apply {
                text = getString(R.string.text_result_phone, phone)
            }

            ShareInfo(name, email, phone)
            nameTextView.text = "Nombre: $name"
            emailTextView.text = "Correo electronico: $email"
            phoneTextView.text = "Telefono: $phone"
        }
    }

    fun bind() {
        nameTextView = findViewById(R.id.display_result_name)
        emailTextView = findViewById(R.id.display_result_email)
        phoneTextView = findViewById(R.id.display_result_phone)
        shareButton = findViewById(R.id.button_share)
    }

    private fun ShareInfo(name: String, email: String, phone: String) {
        shareButton.setOnClickListener{
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nombre: $name\nCorreo electronico:$email\nTelefono: $phone")
                type = "text/plain"
            }
            val shareIntent = Intent .createChooser(intent, null)
            startActivity(shareIntent)
        }
    }
}