import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.academia.ui.theme.AcademiaTheme

// Modelo Cliente (simulando um banco de dados)
data class Cliente(val nome: String, val cpf: String)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcademiaTheme {
                // Chamando o componente de UI principal
                ClienteApp()
            }
        }
    }
}

@Composable
fun ClienteApp() {
    var clientes by remember { mutableStateOf(listOf<Cliente>()) }
    var nome by remember { mutableStateOf(TextFieldValue("")) }
    var cpf by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Título
        Text(text = "Gestão de Clientes", style = MaterialTheme.typography.h5)

        // TextFields para entrada de dados
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = { Text("CPF") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botão para adicionar cliente
        Button(
            onClick = {
                if (nome.text.isNotBlank() && cpf.text.isNotBlank()) {
                    clientes = clientes + Cliente(nome.text, cpf.text)
                    nome = TextFieldValue("") // Limpa os campos após adicionar
                    cpf = TextFieldValue("")
                } else {
                    Toast.makeText(
                        it.context,
                        "Preencha todos os campos!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Cliente")
        }

        // LazyColumn para listar os clientes
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(clientes) { cliente ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text("Nome: ${cliente.nome}", style = MaterialTheme.typography.body1)
                        Text("CPF: ${cliente.cpf}", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AcademiaTheme {
        ClienteApp()
    }
}
