package br.senai.sp.jandira.imc_app_b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_n_c_d.*

class NCDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_n_c_d)

        val editTextPeso : EditText = findViewById(R.id.edit_text_peso)
        val spinnerIdade : Spinner = findViewById(R.id.spinner_idade)
        val spinnerAtividade : Spinner = findViewById(R.id.spinner_Atividade)
        val radioButtonMasculino : RadioButton = findViewById(R.id.button_masculino)
        val radioButtonFeminino : RadioButton = findViewById(R.id.button_feminino)

        val buttonCalcular : Button = findViewById(R.id.button_calcular_ncd)


        var faixaEtaria : Int = 0
        var textoSpinner : String = ""

        buttonCalcular.setOnClickListener {
            faixaEtaria = spinnerIdade.selectedItemPosition
            textoSpinner = spinnerIdade.getItemAtPosition(faixaEtaria).toString()
            Toast.makeText(this, textoSpinner.toString(), Toast.LENGTH_SHORT).show()

            faixaEtaria = spinnerAtividade.selectedItemPosition
            textoSpinner = spinnerAtividade.getItemAtPosition(faixaEtaria).toString()
            Toast.makeText(this, textoSpinner, Toast.LENGTH_SHORT).show()


            if (editTextPeso.text.isEmpty()) {
                editTextPeso.error = "Você não me disse o seu peso!"
            } else if (radioButtonMasculino.text.isEmpty()) {
                radioButtonMasculino.error = "Você não me disse o seu gênero!"
            } else if (radioButtonFeminino.text.isEmpty()) {
                radioButtonFeminino.error = "Você não me disse o seu gênero!"
            } else {
                val intent = Intent(this, ResultadoNcdActivity::class.java)

                intent.putExtra("peso", editTextPeso.text.toString().toDouble())
                intent.putExtra("masculino", radioButtonMasculino.text.toString())
                intent.putExtra("feminino", radioButtonFeminino.text.toString())
                startActivity(intent)
            }

        }
        spinnerIdade.setSelection(1)
        spinnerAtividade.setSelection(2)
    }
}