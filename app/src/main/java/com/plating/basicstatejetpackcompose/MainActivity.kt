package com.plating.basicstatejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plating.basicstatejetpackcompose.ui.theme.BasicStateJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }

    @Composable
    fun WaterCounter(modifier: Modifier=Modifier){
        Column(modifier = modifier.padding(16.dp)) {
            var count by rememberSaveable  { mutableStateOf(0)}

            if (count > 0) {
                Text(
                    text = "you've had $count glasses.",
                )
            }
            Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count<10) {
                Text("Add one")
            }
        }

    }

    @Composable
    fun WellnessScreen(modifier: Modifier = Modifier) {
        WaterCounter(modifier)
    }
}
