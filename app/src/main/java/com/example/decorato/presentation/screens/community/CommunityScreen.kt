package com.example.decorato.presentation.screens.community

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.decorato.presentation.screens.community.sections.CommunitySection
import com.example.decorato.presentation.viewModel.community.community_screen.CommunityViewModel

@Composable
fun CommunityScreen(
    viewModel: CommunityViewModel = hiltViewModel(),

    ) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        // ضبط لون الخلفية ليكون متناسق مع تصميم التطبيق
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        // استدعاء السكشن اللي فيه الـ LazyColumn والبوستات
        CommunitySection(
            state = state,
            listener = viewModel,
            modifier = Modifier.padding(paddingValues)
        )
    }
}