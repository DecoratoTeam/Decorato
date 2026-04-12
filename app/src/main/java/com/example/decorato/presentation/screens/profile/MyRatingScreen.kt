package com.example.decorato.presentation.screens.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
// 🔥 شيلنا NavController من هنا عشان نستخدم الـ Callback
import com.example.decorato.R
import com.example.decorato.presentation.screens.profile.components.my_rating.EmptyRatingContent
import com.example.decorato.presentation.screens.profile.components.my_rating.RatingItem
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.viewModel.profile.Effect.MyRatingEffect
import com.example.decorato.presentation.viewModel.profile.MyRatingViewModel
import com.example.decorato.presentation.viewModel.profile.UiState.MyRatingUiState
import com.example.decorato.presentation.viewModel.profile.InteractionListener.MyRatingInteractionListener

@Composable
fun MyRatingScreen(
    onBackClick: () -> Unit, // 🔥 غيرنا دي عشان تبقى زي الـ Posts
    viewModel: MyRatingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                // 🔥 هنا بننادي على الـ Callback اللي جاي من الـ NavGraph
                is MyRatingEffect.NavigateBack -> onBackClick()
                is MyRatingEffect.NavigateToRatingDetails -> {
                    // تفاصيل التقييم
                }
            }
        }
    }

    MyRatingContent(
        state = state,
        listener = viewModel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRatingContent(
    state: MyRatingUiState,
    listener: MyRatingInteractionListener
) {
    val colors = LocalDecoratoAppColors.current

    Scaffold(
        containerColor = Color(0xFFF9F9F9),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { listener.onBackClick() },
                    shape = RoundedCornerShape(12.dp),
                    color = Color.White,
                    shadowElevation = 2.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.Unspecified
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = stringResource(id = R.string.myRating),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontWeight = FontWeight.SemiBold,
                    color = colors.secondary
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (state.ratings.isEmpty() && !state.isLoading) {
                EmptyRatingContent()
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.ratings) { itemState ->
                        RatingItem(
                            state = itemState,
                            listener = listener
                        )
                    }
                }
            }

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = colors.primary
                )
            }
        }
    }
}