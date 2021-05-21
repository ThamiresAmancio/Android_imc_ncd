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

        val buttonCalcular: Button = findViewById(R.id.button_calcular_ncd)
        val editTextPeso: EditText = findViewById(R.id.edit_text_peso)
        val editTextIdade: EditText = findViewById(R.id.edit_text_idade)
        val spinnerAtividade: Spinner = findViewById(R.id.spinner_Atividade)
        val radioButtonMasculino: RadioButton = findViewById(R.id.button_masculino)
       val radioButtonFeminino: RadioButton = findViewById(R.id.button_feminino)


        ArrayAdapter.createFromResource(
            this,
            R.array.faixaEtariaAtividade,
            R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinnerAtividade.adapter = adapter
        }


        var sexo = 0
        buttonCalcular.setOnClickListener {

            if (editTextPeso.text.isEmpty()) {
                editTextPeso.error = "Você não me informou o seu peso!"
            } else if (editTextIdade.text.isEmpty()) {
                editTextIdade.error = "Você não me informou sua idade!"
            } else {
                val intent = Intent(this, ResultadoNcdActivity::class.java)
                if (radioButtonMasculino.isChecked) {
                    sexo = 1

                } else if (radioButtonFeminino.isChecked) {
                    sexo = 2
                }
                intent.putExtra("peso", editTextPeso.text.toString().toInt())
                intent.putExtra("idade", editTextIdade.text.toString().toInt())
                intent.putExtra("sexo", sexo.toString().toInt())
                intent.putExtra("tipoAtividade", spinnerAtividade.selectedItem.toString())
                startActivity(intent)

            }

            }

        }

    }

