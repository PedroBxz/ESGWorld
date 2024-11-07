package br.com.fiap.esgworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material3.CardElevation
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.com.fiap.esgworld.ui.theme.ESGWorldTheme
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.VerticalAlignmentLine


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ESGWorldTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    Box(modifier = Modifier.fillMaxSize()) {

        // A imagem vai ficar no fundo
        Image(
            painter = painterResource(id = R.drawable.inicial), // Substitua com o nome da sua imagem
            contentDescription = null, // Descrição opcional
            modifier = Modifier
                .fillMaxSize()
                .zIndex(0f), // Coloca a imagem atrás
            contentScale = ContentScale.Crop
        )
        TopBar()
        // Conteúdo da tela que ficará sobre a imagem
        Column(modifier = Modifier
            .fillMaxSize()
            .zIndex(1f) // Garante que o conteúdo ficará sobre a imagem
            .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            ContentSection() // Esta é a tela principal
            Spacer(modifier = Modifier.weight(1f)) // Para empurrar o conteúdo e fixar a NavigationBar no final
        }

        // BottomNavigation ficará fixo no final da tela
        BottomNavigation(modifier = Modifier
            .align(Alignment.BottomCenter)
            .zIndex(1f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("ESG.web") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF376A55),
            titleContentColor = Color.White
        )
    )
}

@Composable
fun ContentSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()  // Faz a coluna preencher toda a tela
            .padding(16.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centraliza verticalmente
    ) {
        Text(
            text = "Bem-vindo(a) a plataforma que vai mudar o futuro!",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Crie e gerencie todas as suas iniciativas ESG.")

        Button(
            onClick = { /* Handle button click */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF376A55),
                contentColor = Color.White
            ),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Comece agora!")
        }

        Spacer(modifier = Modifier.height(16.dp))


        }
    }



@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = Color(0xFF376A55),
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { /* Handle navigation to main page */ },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.7f),
                unselectedTextColor = Color.White.copy(alpha = 0.7f)
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Handle navigation to initiatives */ },
            icon = { Icon(Icons.Default.List, contentDescription = "Iniciativas") },
            label = { Text("Iniciativas") },
                    colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            unselectedIconColor = Color.White.copy(alpha = 0.7f),
            unselectedTextColor = Color.White.copy(alpha = 0.7f)
        )
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Handle navigation to login */ },
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Login") },
            label = { Text("Login") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.7f),
                unselectedTextColor = Color.White.copy(alpha = 0.7f)
            )
        )
    }
}

@Composable
fun InitiativesPage() {
    TopBar()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(55.dp))

            Text(
                text = "Iniciativas ESG",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn {
                items(5) { index ->
                    TaskItem(
                        title = "Iniciativa ESG ${index + 1}",
                        date = "07/11/2024",
                        status = "Em andamento"
                    )

                }


            }
            Button(
                onClick = { /* Handle add new initiative */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF376A55),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Adicionar nova iniciativa")
            }

        }
        BottomNavigation(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun TaskItem(title: String, date: String, status: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            )
            Text(
                text = "Data de Atualização: $date",
                style = TextStyle(fontSize = 12.sp),
            )
            Text(
                text = "Status: $status",
                style = TextStyle(fontSize = 14.sp, color = Color.Green),
            )
        }

    }

    }


@Composable
fun LoginPage() {
    TopBar()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            BasicTextField(
                value = "",
                onValueChange = { /* Handle user input */ },
                textStyle = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .background(Color.Gray.copy(alpha = 0.1f), shape = MaterialTheme.shapes.small)
                    .padding(12.dp)
            )

            BasicTextField(
                value = "",
                onValueChange = { /* Handle password input */ },
                textStyle = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .background(Color.Gray.copy(alpha = 0.1f), shape = MaterialTheme.shapes.small)
                    .padding(12.dp)
            )

            Button(
                onClick = { /* Handle login */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF376A55),
                    contentColor = Color.White
                )
            ) {
                Text("Entrar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = { /* Handle navigate to registration page */ },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "Não tem uma conta? Registre-se",
                    color = Color(0xFF376A55),
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
        BottomNavigation(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun AddNewInitiativePage(

) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = "Adicionar Nova Iniciativa",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Campo de entrada para o título
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Campo de entrada para a descrição
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descrição") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                maxLines = 5
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botão para salvar
            Button(
                onClick = { null },
                enabled = title.isNotBlank() && description.isNotBlank(), // Habilita o botão apenas se os campos não estiverem vazios
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF376A55),
                    contentColor = Color.White
                )
            ) {
                Text("Salvar Iniciativa")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botão para cancelar
            OutlinedButton(
                onClick = { null },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar")
            }
        }
        BottomNavigation(modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewApp() {
    ESGWorldTheme {
        AddNewInitiativePage() // Altere conforme a página que deseja pré-visualizar
    }
}
