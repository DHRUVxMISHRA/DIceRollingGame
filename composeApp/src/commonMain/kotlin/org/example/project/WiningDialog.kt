package org.example.project

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardElevation
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform


//@Composable
//fun winingDialog(
//    onDismiss: () -> Unit,
//    onConfirm: () -> Unit
//){
//    Dialog(
//        onDismissRequest = {
//            onDismiss()
//        }
//    )
//    {
//        Card(
//            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
//            shape = RoundedCornerShape(15.dp),
//            modifier = Modifier
//                .fillMaxWidth(0.90f)
//                .border(1.dp, color = Color.Black)
//        ){
//            Column(modifier=Modifier
//                .fillMaxWidth()
//                .padding(15.dp),
//                verticalArrangement = Arrangement.spacedBy(25.dp)
//            ) {
//           Text(text = "Won")
//                IconButton(
//                    onClick = {
//                        playerScores.value = Array(2) { 0 }
//                        isPlayer1.value = true
//                        currentDiceImage.value = Res.drawable.compose_multiplatform
//                    }
//            }
//        }
//    }
//
//}
