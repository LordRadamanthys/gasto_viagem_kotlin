package com.example.testekotlin.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testekotlin.R
import com.example.testekotlin.model.Gastos
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            calculate()
        }
    }

    private fun isFieldsEmpty(): Boolean {
        return editextAutonomia.text.toString() != "" &&
                edittextDistancia.text.toString() != "" &&
                edittextPreco.text.toString() != ""
    }

    private fun calculate() {
        if (isFieldsEmpty()) {
            try {
                //(distancia*preco)/autonomia
                var gasto = Gastos(
                    edittextDistancia.text.toString().toDouble(),
                    edittextPreco.text.toString().toDouble(),
                    editextAutonomia.text.toString().toDouble()
                )
                textviewValor.text = "R$ ${gasto.calcular()}"
                cleanFields()
            } catch (nfe: NumberFormatException) {
                showToast(nfe.message.toString())
                cleanFields()
            } catch (e: Exception) {
                showToast(e.message.toString())
                cleanFields()
            }
        } else {
            showToast("Preencha os campos com valores validos!")
            cleanFields()
        }
    }

    private fun cleanFields() {
        edittextPreco.text.clear()
        edittextDistancia.text.clear()
        editextAutonomia.text.clear()
        edittextDistancia.requestFocus()
    }

    private fun showToast(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }
}
