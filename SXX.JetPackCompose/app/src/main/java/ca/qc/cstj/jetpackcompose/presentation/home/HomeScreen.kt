package ca.qc.cstj.jetpackcompose.presentation.home

import androidx.compose.animation.core.animateRectAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ca.qc.cstj.jetpackcompose.R
import ca.qc.cstj.jetpackcompose.core.Constants
import ca.qc.cstj.jetpackcompose.presentation.theme.ButtonBlue
import ca.qc.cstj.jetpackcompose.presentation.theme.DarkerButtonBlue
import ca.qc.cstj.jetpackcompose.presentation.theme.TextWhite


@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()){
        Column {
            GreetingSection()
            ChipSection(chips = Constants.PLANET_COMPOSITION_TYPE)
        }
    }

}

@Composable
fun GreetingSection(name:String = "Olivier") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
            text = "Good morning $name",
            style= MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day",
                style= MaterialTheme.typography.body1
            )
        }

       Icon(
           painter = painterResource(id = R.drawable.ic_search),
           contentDescription = "Search",
           tint = TextWhite,
           modifier = Modifier.size(24.dp),

       )
    }

}

@Composable
fun ChipSection(chips:List<String>) {

    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow(modifier = Modifier.padding(end = 15.dp)){
        items(chips.size){
            // Comment chaque item est dessiné
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp,top=15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        selectedChipIndex = it

                    }
                    .background(if(selectedChipIndex == it )ButtonBlue else DarkerButtonBlue)
                    .padding(15.dp)


            ){
                Text(text = chips[it], color = TextWhite)
            }
        }
    }


}