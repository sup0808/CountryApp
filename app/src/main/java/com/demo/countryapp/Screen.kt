package com.demo.countryapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.demo.country.R


@Composable
public fun BlogCategory(name : String, position : String) {
    Card(elevation = 10.dp, modifier = Modifier.padding(5.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_contact),
                contentDescription = "",
                modifier = Modifier.weight(.2f)
            )
            ItemDescription(name, position, Modifier.weight(.8f))
        }

    }
}


@Composable
public fun ItemDescription(name: String, position: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Supriya Gupta",
            style = MaterialTheme.typography.h6
        )
        Text(
            text = "Android Developer", modifier = Modifier.background(Color.White),
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Thin
        )
    }
}

data class Category(
    val name: String,
    val position : String
)


fun getCategoryList(): MutableList<Category>{
    var list = mutableListOf<Category>()
    list.add(Category("Supriya Gupta","Android Develper"));
    list.add(Category("Arvind Gupta","Manager Develper"));
    list.add(Category("Shreeja Gupta","Fashion Develper"));
    list.add(Category("Shresth Gupta","Business Develper"));
    list.add(Category("Supriya Gupta","Android Develper"));
    list.add(Category("Arvind Gupta","Manager Develper"));
    list.add(Category("Shreeja Gupta","Fashion Develper"));
    list.add(Category("Shresth Gupta","Business Develper"));
    list.add(Category("Supriya Gupta","Android Develper"));
    list.add(Category("Arvind Gupta","Manager Develper"));
    list.add(Category("Shreeja Gupta","Fashion Develper"));
    list.add(Category("Shresth Gupta","Business Develper"));
    return  list
}