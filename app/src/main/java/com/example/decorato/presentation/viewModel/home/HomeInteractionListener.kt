package com.example.decorato.presentation.viewModel.home

interface HomeInteractionListener {
    fun onClickPopularItem(designId: String)
    fun onClickRecentlyWatchedItem(designId: String)
    fun onClickShowAllRecentlyWatched()
    fun onClickStyleItem(styleId: String)
    fun onTabSelected(tabIndex: Int)
    fun onClickRetryLoading()
}