import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun OnBoardingPagerItem(
    data: OnboardingModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        ) {
        Image(
            modifier = Modifier.fillMaxWidth().weight(0.7f),
            painter = painterResource(data.image),
            contentDescription = null
        )
            Column(
                modifier = Modifier.fillMaxWidth().weight(0.3f).padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.Center,
                ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = data.title,
                    style = TextStyle(
                        fontSize = 26.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = data.body,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF000000).copy(
                            alpha = 0.55f
                        ),
                        textAlign = TextAlign.Center
                    )
                )
            }
    } 
}