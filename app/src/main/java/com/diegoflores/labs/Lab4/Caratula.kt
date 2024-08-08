package com.diegoflores.labs.Lab4

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diegoflores.labs.R


@Composable
fun Caratula(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.mipmap.logo_uvg),
            contentDescription = "MainLogo",
            modifier = Modifier
                .size(320.dp)
                .align(Alignment.Center)
                .graphicsLayer(alpha = 0.2f)
        )
    }
    Column(modifier = Modifier.fillMaxHeight().border(5.dp, Color(0x27, 0x38, 0x28, 0xFF)), verticalArrangement = Arrangement.Center) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text("Universidad del Valle de Guatemala",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text("Programación de plataformas móviles, Sección 30",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp))

        Row(modifier = Modifier.fillMaxWidth()){
            Box(modifier = Modifier
                .weight(0.5f)) {
                Text("INTEGRANTES",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)
            }
            Column(modifier = Modifier.weight(0.5f)) {
                Text("Diego Flores",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center)
                Text("Nils Muralles",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center)
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp))
        Row(modifier = Modifier.fillMaxWidth()){
            Box(modifier = Modifier
                .weight(0.5f)) {
                Text("CATEDRÁTICO",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)
            }
            Column(modifier = Modifier.weight(0.5f)) {
                Text("Juan Carlos Durini",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center)
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp))
        Column {
            Text("Diego Oswaldo Flores Rivas",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center)
            Text("23714",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center)
        }
    }
}