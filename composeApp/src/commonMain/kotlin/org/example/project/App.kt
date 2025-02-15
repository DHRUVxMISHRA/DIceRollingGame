package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.BoxScopeInstance.matchParentSize
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
//import androidx.compose.ui.Res.painterResource
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinproject.composeapp.generated.resources.dice_1
import kotlinproject.composeapp.generated.resources.dice_2
import kotlinproject.composeapp.generated.resources.dice_3
import kotlinproject.composeapp.generated.resources.dice_4
import kotlinproject.composeapp.generated.resources.dice_5
import kotlinproject.composeapp.generated.resources.dice_6
import kotlinproject.composeapp.generated.resources.png_wining_image
import kotlinproject.composeapp.generated.resources.wining_image
import kotlinproject.composeapp.generated.resources.wining_image_png
import kotlinproject.composeapp.generated.resources.winner_logo_png_3

@Composable
@Preview
fun App() {
    MaterialTheme {

            val isPlayer1 = remember { mutableStateOf(true) }
            val playerScores = remember { mutableStateOf(Array(2) { 0 }) }
            val diceImages = remember {
                listOf(
                    Res.drawable.dice_1,
                    Res.drawable.dice_2,
                    Res.drawable.dice_3,
                    Res.drawable.dice_4,
                    Res.drawable.dice_5,
                    Res.drawable.dice_6
                )
            }
            val currentDiceImage = remember { mutableStateOf(Res.drawable.compose_multiplatform) }
//        if ( playerScores.value[0] >= 50 || playerScores.value[1] >= 50)
//            isPlayer1.value=!isPlayer1.value
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(if(isPlayer1.value) Color(100, 181, 246) else Color(255, 138, 128))
        ) {
//            playerScores.value[0] >= 50 || playerScores.value[1] >= 50
            if ( playerScores.value[0] >= 50 || playerScores.value[1] >= 50) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, // Centers children horizontally
                        verticalArrangement = Arrangement.Center, // Centers children vertically
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Image( painter = painterResource(Res.drawable.winner_logo_png_3),
                                contentDescription = null, )

                        Text(
                            text = if (playerScores.value[0] > playerScores.value[1]) "Player 1 Won" else "Player 2 Won",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (playerScores.value[0] > playerScores.value[1]) Color.Blue else Color.Red // Change color dynamically
                        )

                    }
                    }


                else {
                Column() {
                    Text(
                        text = "Welcome To Dice Rolling Game",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 25.sp,
                        fontWeight = FontWeight(800),

                        )
                    Spacer(modifier = Modifier.height(30.dp))
                    IconButton(
                        onClick = {
                            playerScores.value = Array(2) { 0 }
                            isPlayer1.value = true
                            currentDiceImage.value = Res.drawable.compose_multiplatform
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Icon(imageVector = Icons.Rounded.Refresh, contentDescription = null)

                    }
                    Image(
                        painter = painterResource(currentDiceImage.value),
                        contentDescription = "Dice",
                        modifier = Modifier.size(400.dp)

                    )
                    Button(
                        onClick = {
                            val randomNumber = (1..6).random()
                            currentDiceImage.value = diceImages[randomNumber - 1]

                            if (isPlayer1.value) {
                                playerScores.value[0] += randomNumber
                            } else {
                                playerScores.value[1] += randomNumber
                            }
                            if ( playerScores.value[0] < 50 && playerScores.value[1] < 50)
                            isPlayer1.value = !isPlayer1.value
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        colors = if (isPlayer1.value) {  // Corrected placement
                            ButtonDefaults.buttonColors(containerColor = Color.Blue)
                        } else {
                            ButtonDefaults.buttonColors(containerColor = Color.Red)
                        }

                    ) {
                        Text(
                            text = if (isPlayer1.value) "Roll the dice for Player 1" else "Roll the dice for Player 2",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Blue,
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight(800)
                                    )
                                ) {
                                    append("Player 1 \n ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight(400)
                                    )
                                ) {
                                    append("Score: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Blue,
                                        fontSize = 26.sp,
                                        fontWeight = FontWeight(400)
                                    )
                                ) {
                                    append("${playerScores.value[0]}")
                                }
                            },
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Red,
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight(800)
                                    )
                                ) {
                                    append("Player 2 \n")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight(400)
                                    )
                                ) {
                                    append("Score: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Red,
                                        fontSize = 26.sp,
                                        fontWeight = FontWeight(400)
                                    )
                                ) {
                                    append("${playerScores.value[1]}")
                                }
                            },
                            textAlign = TextAlign.Center
                        )
                    }

                }
//        IconButton{
//             Icon(imageVector = Icons.Rounded.Refresh)
//        }

            }
        }

    }
}
