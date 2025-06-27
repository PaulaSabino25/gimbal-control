package com.example.gimbalcontrol

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.controlwear.virtual.joystick.android.JoystickView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPower = findViewById<Button>(R.id.btnPower)
        val btnMode = findViewById<Button>(R.id.btnMode)
        val joystick = findViewById<JoystickView>(R.id.joystickView)

        btnPower.setOnClickListener {
            // TODO: Implementar comando BLE para ligar/desligar o gimbal
        }

        btnMode.setOnClickListener {
            // TODO: Implementar comando BLE para alternar modo
        }

        joystick.setOnMoveListener { angle, strength ->
            // TODO: Implementar comandos BLE para mover o gimbal
            // Use angle (0-360) e strength (0-100)
        }
    }
}
