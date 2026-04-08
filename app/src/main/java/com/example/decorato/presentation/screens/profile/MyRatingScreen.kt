package com.example.decorato.presentation.screens.profile // تأكدي إن ده مسار الملف الصح

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.decorato.R
// ندي استدعاء للملفات اللي تعبنا فيها
import com.example.decorato.presentation.screens.profile.components.my_rating.EmptyRatingContent
import com.example.decorato.presentation.screens.profile.components.my_rating.RatingItem
import com.example.decorato.presentation.viewModel.profile.MyRatingViewModel
import com.example.decorato.presentation.viewModel.profile.UiState.MyRatingUiState
import com.example.decorato.presentation.viewModel.profile.InteractionListener.MyRatingInteractionListener

@Composable
fun MyRatingScreen(
    viewModel: MyRatingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My rating",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF1F1F1F)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { listener.onBackClick() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back",
                            tint = Color.Unspecified
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            if (state.ratings.isEmpty()) {
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
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}