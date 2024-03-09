package br.com.fiap.esgworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.esgworld.ui.theme.ESGWorldTheme
import br.com.fiap.esgworld.ui.theme.roboto

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ESGWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PagLogin()
                }
            }
        }
    }
}

@Composable
fun PagLogin() {

    var usuario = remember {
        mutableStateOf("")
    }
    var senha = remember {
        mutableStateOf("")}
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color(0xfff3498DB))
            .fillMaxSize()
            .height(500.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(40.dp)

        ) {

            Column {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth()
                        .height(150.dp)
                )
                Text(
                    text = "FAZER LOGIN",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = roboto
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Usuário",
                    modifier = Modifier.padding(horizontal = 10.dp),
                    fontWeight = FontWeight.Black,
                    fontFamily = roboto
                )
                OutlinedTextField(
                    value = usuario.value,
                    onValueChange = {
                                    usuario.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = RoundedCornerShape(10.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Senha",
                    modifier = Modifier.padding(horizontal = 10.dp),
                    fontWeight = FontWeight.Black,
                    fontFamily = roboto
                )
                OutlinedTextField(
                    value = senha.value,
                    onValueChange = {
                                    senha.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = RoundedCornerShape(10.dp),
                    visualTransformation = PasswordVisualTransformation()
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(200.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff3498DB))
                ) {
                    Text(text = "Entrar",
                        fontFamily = roboto)

                }
            }
        }
    }
}

@Composable
fun PagPrincipal() {

    Box() {
        Column {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xfff3498DB))
                    .height(60.dp)
            ) {
                Text(
                    text = "ESG World",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontFamily = roboto

                )
            }
            Column {
                Text(
                    text = "Progresso Usuário",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = roboto
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(horizontal = 5.dp)
                        .align(Alignment.CenterHorizontally),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(150.dp)
                                .padding(vertical = 10.dp, horizontal = 5.dp),
                            elevation = CardDefaults.cardElevation(5.dp)

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.grafico),
                                contentDescription = ""
                            )
                            Text(
                                text = "Environmental",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = roboto,
                                fontSize = 13.sp
                            )
                        }
                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(150.dp)
                                .padding(vertical = 10.dp, horizontal = 5.dp),
                            elevation = CardDefaults.cardElevation(5.dp)

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.grafico),
                                contentDescription = ""
                            )
                            Text(
                                text = "Social",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = roboto
                            )
                        }
                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(150.dp)
                                .padding(vertical = 10.dp, horizontal = 5.dp),
                            elevation = CardDefaults.cardElevation(5.dp)

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.grafico),
                                contentDescription = ""
                            )
                            Text(
                                text = "Governance",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = roboto
                            )
                        }
                    }
                }
            }
            Text(
                text = "Frequencia semana",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = roboto
            )
            Card(modifier = Modifier.padding(horizontal = 10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier
                            .height(140.dp)


                    ) {
                        Text(
                            text = "SEG",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(50.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.concluido),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .height(140.dp)


                    ) {
                        Text(
                            text = "TER", textAlign = TextAlign.Center,
                            modifier = Modifier.width(50.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.concluido),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .height(140.dp)


                    ) {
                        Text(
                            text = "QUA", textAlign = TextAlign.Center,
                            modifier = Modifier.width(50.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.concluido),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .height(140.dp)


                    ) {
                        Text(
                            text = "QUI", textAlign = TextAlign.Center,
                            modifier = Modifier.width(50.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.concluido),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .height(140.dp)


                    ) {
                        Text(
                            text = "SEX", textAlign = TextAlign.Center,
                            modifier = Modifier.width(50.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.concluido),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .height(140.dp)


                    ) {
                        Text(
                            text = "SAB", textAlign = TextAlign.Center,
                            modifier = Modifier.width(50.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.concluido),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .height(140.dp)


                    ) {
                        Text(
                            text = "DOM", textAlign = TextAlign.Center,
                            modifier = Modifier.width(50.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.concluido),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp)
                        )
                    }


                }
            }
            Button(
                onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                colors = ButtonDefaults.buttonColors(Color(0xfff3498DB))
            ) {
                Text(text = "Conferir Desafios e Recompensas",
                    fontFamily = roboto)
            }
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
            )
        }

    }
}

@Composable
fun PagRecompensasDesafios() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xfff3498DB))
                .height(60.dp)
        ) {
            Text(
                text = "ESG World",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontFamily = roboto

            )
        }
        Text(
            text = "Desafios", modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontFamily = roboto

        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(5.dp)
        ) {

            Text(
                text = "Desafio de redução de resíduos",
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = roboto
            )
            Text(
                text = "Reduzir a quantidade de resíduos gerados no escritório, adotando práticas de redução e reutilização.",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = roboto
            )
            Row ( modifier = Modifier
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "10 pontos", textAlign = TextAlign.Center, modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 10.dp),
                    fontFamily = roboto)
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(0xfff3498DB))) {
                  Text(text = "Concluir")
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(5.dp)
        ) {
            Text(
                text = "Desafio de Voluntariado Social",
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = roboto
            )
            Text(
                text = "Os colaboradores são desafiados a se envolverem em atividades voluntárias que beneficiem a comunidade local",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = roboto
            )
            Row ( modifier = Modifier
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "10 pontos", textAlign = TextAlign.Center, modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 10.dp),
                    fontFamily = roboto)
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(0xfff3498DB))) {
                    Text(text = "Concluir")
                }
            }

        }
        Text(
            text = "Recompensas", modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontFamily = roboto
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(5.dp)
        ) {
            Text(
                text = "Folga Remunerada", fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = roboto
            )
            Text(
                text = "Uma recompensa em que o colaborador ganha folgas remuneradas por seu compromisso com os desafios ESG.",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = roboto
            )
            Row ( modifier = Modifier
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "100 pontos", textAlign = TextAlign.Center, modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 10.dp),
                    fontFamily = roboto)
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(0xfff3498DB))) {
                    Text(text = "Resgatar")
                }
            }

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(5.dp)
        ) {
            Text(text = "Assinatura de Serviços de Streaming", fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = roboto)
            Text(text = "Uma assinatura de um serviço de streaming popular de filmes, séries, e programas de TV",modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = roboto)
            Row ( modifier = Modifier
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "60 pontos", textAlign = TextAlign.Center, modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 10.dp),
                    fontFamily = roboto)
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(0xfff3498DB))) {
                    Text(text = "Resgatar")
                }
            }

        }


    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PagLoginPreview() {
    ESGWorldTheme {
        PagPrincipal()

    }
}

