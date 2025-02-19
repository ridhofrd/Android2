package com.proyek.jtk.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.proyek.jtk.di.Injection
import com.proyek.jtk.model.OrderReward
import com.proyek.jtk.viewModel.ViewModelFactory
import com.proyek.jtk.ui.common.UiState
import com.proyek.jtk.ui.components.RewardItem
import com.proyek.jtk.viewModel.daoViewModel
import androidx.compose.runtime.livedata.observeAsState
import com.proyek.jtk.model.Reward





@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: daoViewModel
) {
    val rewardList by viewModel.rewardList.observeAsState(emptyList())
    if(rewardList.isEmpty()){
        val dataNul = null
        HomeContent(null,
            modifier = modifier,
            navigateToDetail = navigateToDetail)
    }
    else{
        HomeContent(rewardList,
            modifier = modifier,
            navigateToDetail = navigateToDetail)
    }
}

@Composable
fun HomeContent(
    Reward: List<Reward>? = null,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(reward) { data ->
            RewardItem(
                image = data.reward.image,
                title = data.reward.title,
                requiredPoint = data.reward.requiredPoint,
                modifier = Modifier.clickable {
                    navigateToDetail(data.reward.id)
                }
            )
        }
    }
}