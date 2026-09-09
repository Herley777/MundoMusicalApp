package com.example.mundomusical

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Instrumento(
    val nome: String,
    val regiao: String,
    val descricao: String
)

private val instrumentos = listOf(
    Instrumento("Berimbau", "Brasil", "Instrumento de corda associado à capoeira e à cultura brasileira."),
    Instrumento("Sitar", "Índia", "Instrumento de cordas tradicional da música clássica indiana."),
    Instrumento("Koto", "Japão", "Instrumento japonês de cordas, tradicionalmente tocado com os dedos."),
    Instrumento("Djembe", "África Ocidental", "Tambor de mão tradicional encontrado em diversas culturas da África Ocidental."),
    Instrumento("Didgeridoo", "Austrália", "Instrumento de sopro tradicional de povos aborígenes australianos."),
    Instrumento("Oud", "Oriente Médio", "Instrumento de cordas dedilhadas muito presente em tradições musicais do Oriente Médio.")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onLogout: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mundo Musical 🎵") },
                actions = {
                    TextButton(onClick = onLogout) {
                        Text("Sair")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Column(modifier = Modifier.padding(vertical = 12.dp)) {
                    Text(
                        "Instrumentos Musicais do Mundo",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        "Conheça instrumentos tradicionais classificados por região e cultura.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            items(instrumentos) { instrumento ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text(instrumento.nome, style = MaterialTheme.typography.titleLarge)
                        Text(
                            instrumento.regiao,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.labelLarge
                        )
                        Text(
                            instrumento.descricao,
                            modifier = Modifier.padding(top = 6.dp)
                        )
                    }
                }
            }
        }
    }
}
