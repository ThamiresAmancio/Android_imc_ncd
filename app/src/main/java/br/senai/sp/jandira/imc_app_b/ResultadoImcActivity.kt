package br.senai.sp.jandira.imc_app_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imc)

        // declarar os componentes
        val textViewImc: TextView = findViewById(R.id.text_view_resultado_imc)
        val textViewStatus: TextView = findViewById(R.id.text_view_status_imc)
        val textViewDicaStatus: TextView = findViewById(R.id.text_view_dica_status)
        val textViewDicas: TextView = findViewById(R.id.text_view_dica)
        val textViewTituloDica : TextView = findViewById(R.id.tex_view_titulo_dica)

        // recuperando o peso e a altura que estão na intent
        val peso = intent.getDoubleExtra("peso", 3.9)
        val altura = intent.getDoubleExtra("altura", 0.0)

        // calculo do imc
        val imc = calcularImc(peso, altura)

        // exibimos o valor do imc formatando com 1 casa decimal
        textViewImc.text = String.format("%.1f", imc)

        // recupera o status e a frase de status do IMC
        val resultados = obterStatus(imc)

        // exibimos os resultados - status e frase
        textViewStatus.text = resultados[0]
        textViewDicaStatus.text = resultados[1]

        // recupera a dica do dia , que é array (List<String>)
        val dica = getDicas()

        //Exibimos a dica recuperadas no array
        textViewTituloDica.text= dica[0]
        textViewDicas.text = dica[1]


    }
}