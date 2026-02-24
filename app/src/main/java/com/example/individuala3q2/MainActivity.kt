@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.individuala3q2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

private val AppColors = lightColorScheme(
    primary = Color(0xFFD81B60),
    secondary = Color(0xFF757575),
    surface = Color(0xFFFFFFFF),
    background = Color(0xFFF5F5F5),
    onPrimary = Color.White,
    onSurface = Color(0xFF212121)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme(colorScheme = AppColors) { ProfileScreen() } }
    }
}

@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") }
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            ProfileHeader()
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
private fun ProfileHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(MaterialTheme.colorScheme.primary)
        )

        Box(
            modifier = Modifier
                .size(92.dp)
                .align(Alignment.TopCenter)
                .offset(y = 104.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .zIndex(2f),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Person, contentDescription = null)
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 44.dp)
                .zIndex(1f),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Rafal Alzaid", style = MaterialTheme.typography.titleMedium)
                    Text("Computer Science • UI/UX", color = MaterialTheme.colorScheme.onSurface)
                }
                FilledTonalButton(
                    onClick = {},
                    modifier = Modifier
                        .height(40.dp)
                ) {
                    Text("Add")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfilePreview() {
    MaterialTheme(colorScheme = AppColors) { ProfileScreen() }
}