// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.TextField
var a = 0
val addInput: MutableList<TextField> = mutableListOf<TextField>()

@Composable
fun App() {

    var boletoOne by remember { mutableStateOf("") }


    Column (
        modifier = Modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

            ){
        TextField(
            value = boletoOne,
            onValueChange = { boletoOne = it.filterNot { it.isWhitespace() }.replace("\\.".toRegex(), "") },
            label = { Text("Lista dos Aprovados", modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)},
            modifier = androidx.compose.ui.Modifier.width(600.dp).padding(10.dp).height(180.dp),
            shape = RoundedCornerShape(10),
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledTextColor = Color.Transparent,

            )
        )


        Button(
            onClick = {},
            shape = RoundedCornerShape(50),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            modifier = androidx.compose.ui.Modifier.padding(10.dp)
        ) {

            Text("Inserir na lista", modifier = Modifier.width(200.dp),textAlign = TextAlign.Center)
        }
        Row {
            TextField(
                value = boletoOne,
                onValueChange = { boletoOne = it.filterNot { it.isWhitespace() }.replace("\\.".toRegex(), "") },
                label = { Text("Nome", modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)},
                modifier = androidx.compose.ui.Modifier.width(200.dp).padding(10.dp).height(180.dp),
                shape = RoundedCornerShape(10),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,

                )
            )
            TextField(
                value = boletoOne,
                onValueChange = { boletoOne = it.filterNot { it.isWhitespace() }.replace("\\.".toRegex(), "") },
                label = { Text("Turma", modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)},
                modifier = androidx.compose.ui.Modifier.width(200.dp).padding(10.dp).height(180.dp),
                shape = RoundedCornerShape(10),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,

                    )
            )
            TextField(
                value = boletoOne,
                onValueChange = { boletoOne = it.filterNot { it.isWhitespace() }.replace("\\.".toRegex(), "") },
                label = { Text("Curso", modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)},
                modifier = androidx.compose.ui.Modifier.width(200.dp).padding(10.dp).height(180.dp),
                shape = RoundedCornerShape(10),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,

                    )
            )
        }



        Button(
            onClick = {},
            shape = RoundedCornerShape(50),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            modifier = androidx.compose.ui.Modifier.padding(10.dp)
        ) {

            Text("Verificar aprovados", modifier = Modifier.width(200.dp),textAlign = TextAlign.Center)
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(50),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            modifier = androidx.compose.ui.Modifier.padding(10.dp)
        ) {

            Text("Limpar", modifier = Modifier.width(200.dp),textAlign = TextAlign.Center)
        }

        }

    }





fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        title = "NÃO SEI",
        state = rememberWindowState(
            width = 1024.dp,
            height = 768.dp
        )
    ) {
        App()
    }
}



fun comparaBoletos(boletoOne:String, boletoTwo:String): String {
    if(boletoOne.length == boletoTwo.length){
        val arrayBoletoOne = boletoOne.split("")
        val arrayBoletoTwo = boletoTwo.split("")
        for (i in 1..boletoOne.length) {
            if( arrayBoletoOne[i] != arrayBoletoTwo[i])
                return "Boletos diferentes!"
        }
        return "Boletos iguais!"
    }
    return "Boletos diferentes!"
}
