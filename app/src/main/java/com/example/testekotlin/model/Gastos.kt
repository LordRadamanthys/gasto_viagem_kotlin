package com.example.testekotlin.model

import java.text.DecimalFormat

class Gastos(var dis: Double, var preco: Double, var autonomia: Double) {

    private val df = DecimalFormat("#.##")

    fun calcular(): String {
        try {
            if (dis <= 0.0 || autonomia <= 0.0 || preco <= 0.0) throw Exception("valores não podem ser zero")
            var result = (dis * preco) / autonomia
            return df.format(result)
        } catch (nfe: NumberFormatException) {
            throw NumberFormatException("Preencha os campos com valores validos!")
        }
    }

}