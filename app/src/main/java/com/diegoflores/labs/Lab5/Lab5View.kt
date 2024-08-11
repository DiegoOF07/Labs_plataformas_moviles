package com.diegoflores.labs.Lab5

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diegoflores.labs.R
import com.diegoflores.labs.ui.theme.LabsTheme

@Composable
fun MyView(modifier: Modifier = Modifier){
    val lab5Context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        ) {

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp))

        Row (modifier = Modifier //Header
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(0xe1, 0xf3, 0xf9, 0xff)),
            horizontalArrangement = Arrangement.SpaceBetween){

            IconButton(onClick = {}, modifier = Modifier
                .fillMaxHeight()
                .weight(0.15f)){
                Icon(painter = painterResource(id = R.drawable.ic_update),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .background(
                            Color(0x21, 0xa3, 0xd2, 0xff),
                            shape = RoundedCornerShape(50)
                        )
                        .size(35.dp)
                        .padding(7.dp)
                )
            }

            Text("Actualización disponible",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.55f))

            TextButton(onClick = {
                                    val wazeUri = Uri.parse("https://play.google.com/store/apps/details?id=com.waze")
                                    val toWaze = Intent(Intent.ACTION_VIEW, wazeUri)
                                    lab5Context.startActivity(toWaze)
                                 },
                modifier = Modifier.weight(0.3f)) {
                Text("Descargar", color = Color(0x21, 0xa3, 0xd2, 0xff))
            }
        }

        Row (modifier = Modifier //Fecha de cumpleaños
            .fillMaxWidth()
            .height(90.dp),
            horizontalArrangement = Arrangement.SpaceAround){

            Column(modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Center) {

                Text("Domingo",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)
                Text("14 de julio",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center)
            }

            Box(modifier = Modifier
                .fillMaxHeight(),
                contentAlignment = Alignment.BottomCenter) {
                OutlinedButton(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.Gray
                    )) {
                    Text("Terminar jornada", color = Color(0x62, 0x04, 0xda, 0xff),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center)
                }
            }

        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)){

            ElevatedCard(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(150.dp)){

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)){

                    Column(modifier = Modifier
                        .weight(0.6f)
                        .align(Alignment.CenterVertically)) {

                        Text("Vesuvio",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center)
                        Text("Portales, zona 17",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center)
                        Text("9:30AM - 10:00PM",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center)
                        Box(modifier = Modifier
                            .fillMaxSize(),
                            contentAlignment = Alignment.Center){
                            Button(onClick = { Toast.makeText(lab5Context, "Diego Oswaldo Flores Rivas", Toast.LENGTH_SHORT).show() },
                                colors = ButtonDefaults.buttonColors(
                                    Color(0xff,0x76,0x54,0xff)
                                ),
                                shape = RoundedCornerShape(20),
                                modifier = Modifier
                                    .width(120.dp)
                                ){
                                Text("Iniciar",
                                    style = MaterialTheme.typography.titleMedium)
                            }
                        }
                    }

                    Column(modifier = Modifier
                        .weight(0.4f)) {

                        Box(modifier = Modifier
                            .fillMaxSize()
                            .weight(0.15f)
                            .padding(5.dp),
                            contentAlignment = Alignment.CenterEnd){
                            IconButton(onClick = {
                                val restaurantAddress = "Pizza Vesuvio, Portales, Cdad. de Guatemala"
                                val location = Uri.parse("geo:0,0?q=${Uri.encode(restaurantAddress)}")
                                val intent = Intent(Intent.ACTION_VIEW, location).apply {
                                    setPackage("com.google.android.apps.maps")
                                }
                                if(intent.resolveActivity(lab5Context.packageManager) == null) lab5Context.startActivity(intent) else Toast.makeText(lab5Context, "No se puede ir a maps", Toast.LENGTH_SHORT).show()
                            },){
                                Icon(painter = painterResource(id = R.drawable.ic_map),
                                    contentDescription = "",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .background(
                                            Color(0x62, 0x04, 0xda, 0xff),
                                            shape = CutCornerShape(50)
                                        )
                                        .size(25.dp)
                                        .padding(5.dp)
                                )
                            }

                        }
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp))
                        TextButton(onClick = {
                            Toast.makeText(lab5Context,"Pastas\nQQ", Toast.LENGTH_SHORT).show()
                        },
                            modifier = Modifier
                                .width(120.dp)
                                .height(55.dp)) {
                            Text("Detalles",
                                color = Color(0xff,0x76,0x54,0xff),
                                style = MaterialTheme.typography.titleMedium)
                        }

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Lab5Preview() {
    LabsTheme {
        MyView()
    }
}

