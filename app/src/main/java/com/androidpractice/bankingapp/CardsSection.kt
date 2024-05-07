package com.androidpractice.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidpractice.bankingapp.data.Card
import com.androidpractice.bankingapp.ui.theme.BlueEnd
import com.androidpractice.bankingapp.ui.theme.BlueStart
import com.androidpractice.bankingapp.ui.theme.GreenEnd
import com.androidpractice.bankingapp.ui.theme.GreenStart
import com.androidpractice.bankingapp.ui.theme.OrangeEnd
import com.androidpractice.bankingapp.ui.theme.OrangeStart
import com.androidpractice.bankingapp.ui.theme.PurpleEnd
import com.androidpractice.bankingapp.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3664 7875 3875 3976",
        cardName = "Business",
        balance = 47.45,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "3664 7875 3875 3976",
        cardName = "Savings",
        balance = 7.45,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "0073 6375 3205 3976",
        cardName = "School",
        balance = 4.45,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "3664 7875 3875 3976",
        cardName = "Trips",
        balance = 4700.45,
        color = getGradient(GreenStart, GreenEnd)
    )
)

@Composable
fun CardsSection() {
    LazyRow {
        items(cards.size) {index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPadding = 0.dp
    if(index == cards.size) lastItemPadding = 16.dp

    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTERCARD") image = painterResource(id = R.drawable.ic_mastercard)

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPadding)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = image, contentDescription = "${card.cardType}", modifier = Modifier.width(250.dp))
            Spacer(Modifier.width(8.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}




fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        listOf(startColor, endColor)
    )
}