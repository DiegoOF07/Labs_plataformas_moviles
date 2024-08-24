package com.diegoflores.labs.lab6

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegoflores.labs.R
import com.diegoflores.labs.ui.theme.LabsTheme

data class ElementoHistorial(
    val data: Int,
    val state: Boolean)

@Composable
fun CounterView(modifier: Modifier = Modifier){

    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    var incrementosTotales by rememberSaveable {
        mutableStateOf(0)
    }
    var decrementosTotales by rememberSaveable {
        mutableStateOf(0)
    }
    var maxVal by rememberSaveable {
        mutableStateOf(0)
    }
    var minVal by rememberSaveable {
        mutableStateOf(0)
    }
    var cambiosTotales by rememberSaveable {
        mutableStateOf(0)
    }
    val listadoHistorial = remember {
        mutableStateListOf<ElementoHistorial>()
    }
    Column(modifier = Modifier
        .fillMaxSize()){
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp))
        Text("Diego Oswaldo Flores Rivas",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp))

        Contador(modifier = Modifier
            .padding(0.dp, 60.dp),
            count = counter,
            onAddNumber = {number -> counter+=number
                incrementosTotales+=number
                cambiosTotales+=number
                if (maxVal<= counter) maxVal = counter
                listadoHistorial.add(ElementoHistorial(counter, true))
                          },
            onLessNumber = {number -> counter-=number
                decrementosTotales+=number
                cambiosTotales+=number
                if (minVal >= counter) minVal = counter
                listadoHistorial.add(ElementoHistorial(counter, false))
            })
        HorizontalDivider(thickness = 1.dp)
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
        ){
            ViewStat(message = "Total incrementos:", stat = incrementosTotales)
            ViewStat(message = "Total decrementos:", stat = decrementosTotales)
            ViewStat(message = "Valor máximo:", stat = maxVal)
            ViewStat(message = "Valor mínimo:", stat = minVal)
            ViewStat(message = "Total cambios:", stat = cambiosTotales)
        }
        Text("Historial:",
            modifier = Modifier
                .padding(18.dp, 0.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            color = MaterialTheme.colorScheme.onBackground)
        Historial(modifier = Modifier,
            history = listadoHistorial)

        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(onClick = {counter = 0
                incrementosTotales = 0
                decrementosTotales = 0
                maxVal = 0
                minVal = 0
                cambiosTotales = 0
                listadoHistorial.clear()},
                colors = ButtonColors(
                contentColor = MaterialTheme.colorScheme.onError,
                disabledContentColor = MaterialTheme.colorScheme.onSecondary,
                containerColor = MaterialTheme.colorScheme.error,
                disabledContainerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text("Reiniciar contador",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Justify)
            }
        }
    }
}

@Composable
private fun Contador(modifier: Modifier = Modifier,
                     count: Int = 0,
                     onAddNumber: (Int)-> Unit,
                     onLessNumber: (Int)-> Unit){
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        IconButton(onClick = { onLessNumber(1) },modifier = Modifier
            .size(56.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_remove_circle ), contentDescription = "+",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(56.dp))
        }
        Text("${count}",
            modifier = Modifier
                .padding(20.dp, 0.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = 65.sp)
        IconButton(onClick = { onAddNumber(1) },modifier = Modifier.size(56.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_add_circle ), contentDescription = "+",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(56.dp))
        }
    }
}

@Composable
private fun ViewStat(modifier: Modifier = Modifier,message: String, stat: Int){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text("${message}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            color = MaterialTheme.colorScheme.onBackground)
        Text("${stat}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            color = MaterialTheme.colorScheme.onBackground)
    }
}

@Composable
private fun Historial(modifier: Modifier = Modifier,
                      history: MutableList<ElementoHistorial>){
        if (history.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(272.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No se han realizado cambios",
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        } else {
            LazyVerticalGrid(columns = GridCells.Fixed(5),
                contentPadding = PaddingValues(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .height(272.dp)) {
                items(history){lastNum ->
                    HistorialItem(content = lastNum,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(56.dp))}
            }
        }
}

@Composable
private fun HistorialItem(modifier: Modifier = Modifier, content: ElementoHistorial){
    if(content.state){
        Box(modifier = Modifier
            .height(50.dp)
            .background(
                Color(0x1a, 0x7d, 0x28, 0xff),
                shape = RoundedCornerShape(30)
            )
            .padding(12.dp),
            contentAlignment = Alignment.Center){
            Text("${content.data}")
        }
    }else{
        Box(modifier = Modifier
            .height(50.dp)
            .background(
                Color(0xb3, 0x26, 0x1e, 0xff),
                shape = RoundedCornerShape(30)
            )
            .padding(12.dp),
            contentAlignment = Alignment.Center){
            Text("${content.data}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Lab6Preview() {
    LabsTheme {
        CounterView()
    }
}