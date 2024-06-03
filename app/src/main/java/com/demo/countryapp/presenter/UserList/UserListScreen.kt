import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demo.countryapp.domain.model.User
import com.demo.countryapp.presenter.UserList.UserListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite

import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun UserListScreen() {


    /*Scaffold(topBar = { TopAppBar(title = { Text("UserApp") }) }) {

    }
*/
    val viewModel = hiltViewModel<UserListViewModel>()
    val result = viewModel.list.value

    if (result.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    if (result.error.isBlank()) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "${result.error}")
        }
    }

    result.data.let {
        println("Loading Data")
        LazyColumn {
            println("data size =${result.data?.size} ")
            val data = result.data
            items(items = data!!) {
                QuoteListItem(user = it) {

                }
            }
        }
    } ?: "Not loading adata"
}

    @Composable
    fun QuoteListItem(user: User, onClick : (user : User) -> Unit) {

        Card(
            elevation = 4.dp,
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick(user) },
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Image(
                    imageVector = Icons.Filled.Close,
                    colorFilter = ColorFilter.tint(Color.White),
                    alignment = Alignment.TopStart,
                    contentDescription = "Quote Description",
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(180F)
                        .background(Color.Blue)

                )
                Spacer(modifier = Modifier.padding(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = user.name,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                    )

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFEEEEEE))
                            .fillMaxWidth(.4f)
                            .height(1.dp)
                    )
                    Text(
                        text = user.email!!,
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                    )
                }

            }

        }
    }



