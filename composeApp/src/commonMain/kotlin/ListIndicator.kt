import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ListIndicator(
    modifier: Modifier = Modifier,
    totalItems: Int,
    currentSelected: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        for(i in 0 until totalItems){
            Box(
                modifier = Modifier
                    .animateContentSize()
                    .height(5.dp)
                    .width(if (i == currentSelected) 20.dp else 5.dp)
                    .background(
                        color = if (i == currentSelected) Color(0xff8D4F00) else Color(0xffB3B3B3),
                        shape = RoundedCornerShape(15.dp)
                    )
            )
        }
    }
}
