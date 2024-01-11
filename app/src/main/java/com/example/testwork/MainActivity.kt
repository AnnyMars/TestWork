package com.example.testwork

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testwork.data.dto.ListItem
import com.example.testwork.data.network.ApiRepository
import com.example.testwork.ui.theme.TestWorkTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val data = ApiRepository()
            val items = produceState<List<ListItem>>(
                initialValue = emptyList(),
                producer = {
                    value = data.getResponse().result.list
                }
            )

            TestWorkTheme {
                Surface(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.fillMaxSize()
                ) {

                    LazyColumn {
                        items(items.value) {
                            ItemCard(
                                title = it.title,
                                description = it.description,
                                url = it.url,
                                tags = it.tags
                            )
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun ItemCard(title: String, description: String, url: String, tags: List<String>) {
    val openLink =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Title: $title",
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp
            )
            Text(
                text = "Description: $description",
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            ClickableText(
                text = buildAnnotatedString {
                    append("URL: $url")
                    addStyle(
                        style = SpanStyle(color = Color.Blue),
                        start = 5, end = url.length
                    )
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    openLink.launch(intent)
                }
            )
            Text(
                text = "Tags: ${tags.joinToString(", ")}",
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}
