package br.senai.sp.jandira.imc_app_b

import java.util.*


fun dicasNcd () : List<String>{
    val dicas = listOf(
        listOf("Evite", "Evite açúcar e farinha branca."),
        listOf("Evite besteiras", "Evite doces como sobremesa,substitua por frutas."),
        listOf("Jejum", "Jamais fique em jejum.Coma a cada 3 a 4 horas."),
        listOf("Não exagere na gordura","Procure não abusar da gordura ao preparar alimentos."),
        listOf("Beba água","Beba 2 litros de água por dia entre as refeições"),
        listOf("Alimentação","Consuma peixe pelo menos 1 vez por semana")
    )

    val listagemDicas = Random()
    val dicaDoDia = listagemDicas.nextInt(dicas.size)
    return dicas[dicaDoDia]
}

