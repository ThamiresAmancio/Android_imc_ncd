package br.senai.sp.jandira.imc_app_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_resultado_ncd.*

class ResultadoNcdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_ncd)

       val  textViewNcd : TextView = findViewById(R.id.text_resultado_ncd)
        val textViewTitulo : TextView = findViewById(R.id.tex_view_titulo_dica)
        val TextViewDica : TextView = findViewById(R.id.text_dica)


        val peso = intent.getIntExtra("peso",0)
        val idade = intent.getIntExtra("idade", 0)
        val sexo = intent.getIntExtra("sexo", 0)
        val tipoAtividade = intent.getStringExtra("tipoAtividade")



        val ncd = calcularNcd(peso,idade,tipoAtividade,sexo)
        textViewNcd.text = String.format("%.1f",ncd)


        val dicas = dicasNcd()

        textViewTitulo.text = dicas[0]
        text_dica.text = dicas[1]





    }
}