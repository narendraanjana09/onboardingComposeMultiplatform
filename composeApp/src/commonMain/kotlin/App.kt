import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
fun App() {
    val coroutineScope = rememberCoroutineScope()
    val list = OnboardingModel.getList()
    val pagerState = rememberPagerState {
        list.size
    }
    MaterialTheme {
        Box (
            modifier = Modifier.fillMaxSize()
                .paint(
                    painter = painterResource("background.jpg"),
                    contentScale = ContentScale.FillBounds
                )
                .safeDrawingPadding()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .weight(0.8f),
                    state = pagerState
                ) { index ->
                    OnBoardingPagerItem(
                        data = list[index]
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .weight(0.2f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ListIndicator(
                        totalItems = list.size,
                        currentSelected = pagerState.currentPage
                    )

                    FloatingActionButton(
                        modifier = Modifier.size(70.dp),
                        elevation = FloatingActionButtonDefaults.elevation(
                            defaultElevation = 0.dp
                        ),
                        shape = CircleShape,
                        contentColor = Color(0xffffffff),
                        backgroundColor = Color(0xff8D4F00),
                        onClick = {
                            if (pagerState.canScrollForward) {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Rounded.ArrowForward, contentDescription = null)
                    }
                }
            }
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.TopEnd).padding(end = 20.dp),
                visible = pagerState.currentPage in 1..2,
                enter = slideInHorizontally {
                    it
                },
                exit = slideOutHorizontally {
                    it
                }
            ) {
                Text(
                    text = "skip",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF5D5D5D),
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}