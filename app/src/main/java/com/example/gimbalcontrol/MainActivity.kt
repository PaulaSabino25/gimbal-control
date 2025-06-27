package com.example.gimbalcontrol

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.controlwear.virtual.joystick.android.JoystickView
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattService
import android.content.Context
import android.util.Log

class MainActivity : AppCompatActivity() {
    private var bluetoothAdapter: BluetoothAdapter? = null
    private var gimbalDevice: BluetoothDevice? = null
    private var gatt: BluetoothGatt? = null

    // Substitua pelos UUIDs reais do serviço e características do gimbal M01
    private val GIMBAL_SERVICE_UUID = java.util.UUID.fromString("0000xxxx-0000-1000-8000-00805f9b34fb")
    private val POWER_CHAR_UUID = java.util.UUID.fromString("0000xxxx-0000-1000-8000-00805f9b34fb")
    private val MODE_CHAR_UUID = java.util.UUID.fromString("0000xxxx-0000-1000-8000-00805f9b34fb")
    private val MOVE_CHAR_UUID = java.util.UUID.fromString("0000xxxx-0000-1000-8000-00805f9b34fb")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        val btnPower = findViewById<Button>(R.id.btnPower)
        val btnMode = findViewById<Button>(R.id.btnMode)
        val joystick = findViewById<JoystickView>(R.id.joystickView)

        btnPower.setOnClickListener {
            // Exemplo: alternar estado de energia
            sendPowerCommand()
        }

        btnMode.setOnClickListener {
            // Exemplo: alternar modo
            sendModeCommand()
        }

        joystick.setOnMoveListener { angle, strength ->
            // Enviar comando de movimento
            sendMoveCommand(angle, strength)
        }
    }

    // Métodos BLE simplificados (substitua pelos comandos reais do gimbal)
    private fun sendPowerCommand() {
        writeCharacteristic(POWER_CHAR_UUID, byteArrayOf(0x01)) // Exemplo: ligar/desligar
    }

    private fun sendModeCommand() {
        writeCharacteristic(MODE_CHAR_UUID, byteArrayOf(0x01)) // Exemplo: alternar modo
    }

    private fun sendMoveCommand(angle: Int, strength: Int) {
        // Exemplo: envie os valores como bytes (ajuste conforme protocolo do gimbal)
        val data = byteArrayOf(angle.toByte(), strength.toByte())
        writeCharacteristic(MOVE_CHAR_UUID, data)
    }

    private fun writeCharacteristic(charUuid: java.util.UUID, value: ByteArray) {
        val gatt = gatt ?: return
        val service = gatt.getService(GIMBAL_SERVICE_UUID) ?: return
        val characteristic = service.getCharacteristic(charUuid) ?: return
        characteristic.value = value
        gatt.writeCharacteristic(characteristic)
    }
}
}
