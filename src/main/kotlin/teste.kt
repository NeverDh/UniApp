// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun AppTwo() {
    var text by remember { mutableStateOf("Hello, World!") }

    Column {
        for (n in nomes){
            Text(
                text = n,
                style = fieldTextStyle(),

                )
            Spacer(modifier = Modifier.height(10.dp))
        }
        var nome = inserirNome()

        Button(
            onClick = {
                adicionarNomes(nome)
            },
            contentPadding =
            PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp,

                ),
        )
        {
            Text("Adicionar")
        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        AppTwo()
    }
}

val nomes = mutableListOf<String>()

fun adicionarNomes(nome: String){
    nomes.add(nome)
}

@Preview
@Composable

fun inserirNome(): String{
    var text by remember {mutableStateOf("") }
    BasicTextField(
        value = text,
        onValueChange = { text = it },
        Modifier.border(BorderStroke(1.dp, Color.Black)),
    )
    return text
}

@Composable
fun fieldTextStyle(): TextStyle {
    return TextStyle(
        background = Color.LightGray,
    )
}
