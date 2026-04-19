package com.example.decorato.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.decorato.presentation.navigation.NavigationManager
import com.example.decorato.presentation.screens.profile.components.my_posts.PostItem
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.viewModel.profile.MyPostsViewModel
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource

@Composable
fun MyPostsScreen(
    viewModel: MyPostsViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val colors = LocalDecoratoAppColors.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colors.surface,
        topBar = {
            // الزتونة: نستخدم Column مع statusBarsPadding عشان نزيح الـ Row كله لتحت الساعة
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding() // دي اللي هتعمل حساب الـ 54px بتاعة الساعة والبطارية
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp, start = 15.dp, end = 15.dp) // قللنا الـ top padding شوية لأن الـ statusBarsPadding قامت بالواجب
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { onBackClick() },
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = colors.surfaceHigh),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_back),
                                contentDescription = "Back",
                                modifier = Modifier.size(16.dp),
                                tint = colors.secondary
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = stringResource(id = R.string.myPosts),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontWeight = FontWeight.SemiBold,
                        color = colors.secondary
                    )
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(top = 10.dp, bottom = 24.dp)
        ) {
            items(state.posts) { post ->
                PostItem(state = post, listener = viewModel)
            }
        }
    }
}