package br.senai.sp.jandira.imc_app_b


fun tipoAtividade (tipoAtividade : String, sexo : Int): Double {



    var resultados = 0.0
    if(sexo == 1){
        if(tipoAtividade == "Leve"){
            resultados = 1.6
        }else if (tipoAtividade == "Moderado"){
            resultados = 1.8
        }else if (tipoAtividade == "Intensa"){
            resultados = 2.1
        }
    }else if (sexo == 2){
        if(tipoAtividade == "Leve"){
            resultados = 1.6
        }else if(tipoAtividade == "Moderado"){
            resultados = 1.6
        }else if (tipoAtividade == "Intensa"){
            resultados = 1.8
        }

    }
    return resultados
}


fun  calcularNcd (peso: Int, idade: Int,tipoAtividade: String,sexo: Int): Double {
    var resultados = tipoAtividade(tipoAtividade,sexo)
    var ncdResultado = 0.0

    if(sexo == 1){
        if(idade > 16 && idade <= 30){
            ncdResultado = (15.3 * peso + 679) * resultados
        }else if( idade > 31 && idade <=60){
            ncdResultado = (11.6 * peso + 879) * resultados
        }else if(idade > 61) {
            ncdResultado= (13.5 * peso + 487) * resultados
        }
    }else if (sexo == 2){
        if(idade > 16 && idade <= 30){
            ncdResultado = (14.7 * peso + 496)* resultados
        }else if( idade > 31 && idade <=60){
            ncdResultado = (8.7 * peso + 829)* resultados
        }else if(idade > 61) {
            ncdResultado= (10.5 * peso + 596)* resultados
        }

    }

    return ncdResultado
}

















































