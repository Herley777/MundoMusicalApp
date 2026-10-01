package com.example.mundomusical

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Instrumento(
    val nome: String,
    val regiao: String,
    val descricao: String
)

private val instrumentos = listOf(
    Instrumento(
        "Berimbau",
        "Brasil",
        "Instrumento de corda associado à capoeira e à cultura brasileira."
    ),
    Instrumento(
        "Sitar",
        "Índia",
        "Instrumento de cordas tradicional da música clássica indiana."
    ),
    Instrumento(
        "Koto",
        "Japão",
        "Instrumento japonês de cordas, tradicionalmente tocado com os dedos."
    ),
    Instrumento(
        "Djembe",
        "África Ocidental",
        "Tambor de mão tradicional encontrado em diversas culturas da África Ocidental."
    ),
    Instrumento(
        "Didgeridoo",
        "Austrália",
        "Instrumento de sopro tradicional de povos aborígenes australianos."
    ),
    Instrumento(
        "Oud",
        "Oriente Médio",
        "Instrumento de cordas dedilhadas muito presente em tradições musicais do Oriente Médio."
    )
)

private val LaranjaHome = Color(0xFFFF6B00)
private val LaranjaClaroHome = Color(0xFFFF9A3D)
private val PretoHome = Color(0xFF121212)
private val CardHome = Color(0xFF1E1E1E)
private val BrancoHome = Color(0xFFFFFFFF)
private val CinzaHome = Color(0xFFD0D0D0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onLogout: () -> Unit
) {
    Scaffold(
        containerColor = PretoHome,

        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "♫",
                            color = LaranjaHome,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Mundo Musical",
                            color = BrancoHome,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PretoHome,
                    titleContentColor = BrancoHome
                ),

                actions = {
                    TextButton(
                        onClick = onLogout
                    ) {
                        Text(
                            text = "SAIR",
                            color = LaranjaClaroHome,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 18.dp),

            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            // CABEÇALHO
            item {
                Column(
                    modifier = Modifier.padding(
                        top = 18.dp,
                        bottom = 4.dp
                    )
                ) {

                    Text(
                        text = "Instrumentos Musicais",
                        color = BrancoHome,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Explore sons, culturas e tradições de diferentes partes do mundo.",
                        color = CinzaHome,
                        fontSize = 15.sp,
                        lineHeight = 21.sp
                    )
                }
            }

            // DESTAQUE
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = LaranjaHome
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "🌎  MÚSICA PELO MUNDO",
                            color = PretoHome,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Conheça instrumentos de diferentes culturas.",
                            color = PretoHome,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "Cada instrumento carrega uma história e uma identidade cultural.",
                            color = Color(0xFF2A1608),
                            fontSize = 14.sp
                        )
                    }
                }
            }

            // INSTRUMENTOS
            items(instrumentos) { instrumento ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = CardHome
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        LaranjaHome.copy(alpha = 0.45f)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = instrumento.nome,
                                color = BrancoHome,
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "♫",
                                color = LaranjaHome,
                                fontSize = 24.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(7.dp))

                        Surface(
                            shape = RoundedCornerShape(50.dp),
                            color = LaranjaHome.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = instrumento.regiao,
                                modifier = Modifier.padding(
                                    horizontal = 12.dp,
                                    vertical = 6.dp
                                ),
                                color = LaranjaClaroHome,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = instrumento.descricao,
                            color = CinzaHome,
                            fontSize = 14.sp,
                            lineHeight = 20.sp
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}