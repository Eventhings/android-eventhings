package com.eventhngs.feature_media_partner_menu.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.ui.component.bottomsheet.ChipFilterType
import com.eventhngs.ui.component.bottomsheet.FilterBottomSheetHeader
import com.eventhngs.ui.component.bottomsheet.MultipleChipFilterWithLabel
import com.eventhngs.ui.component.bottomsheet.SingleChipFilterWithLabel
import com.eventhngs.ui.component.button.SmallPrimaryButton
import com.eventhngs.ui.component.event.EventNeedItem
import com.eventhngs.ui.component.searchbar.SearchBarWithFilter
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@ExperimentalMaterialApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun MediaPartnerMenuScreen(
    modifier: Modifier = Modifier,
    viewModel: MediaPartnerViewModel = koinViewModel(),
    navigateUp: () -> Unit = {},
    navigateToMediaPartnerDetail: (String) -> Unit = {}
) {

    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )
    val scope = rememberCoroutineScope()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val query = uiState.query
    val eventNeedItems = uiState.mediaPartners.collectAsLazyPagingItems()

    LaunchedEffect(key1 = Unit) {
        viewModel.getMediaPartner()
    }

    val subcategoryFilter = remember {
        listOf("Career", "Community", "Education", "Event", "Magazine", "Organization", "Technology", "TV & Radio")
    }
    val selectedSubcategoryFilter = remember {
        mutableStateListOf("")
    }
    val onSubcategoryFilterSelected: (String) -> Unit = {
        val contains = selectedSubcategoryFilter.contains(it)
        if (contains) {
            selectedSubcategoryFilter.remove(it)
        } else {
            selectedSubcategoryFilter.add(it)
        }
    }

    val feesFilter = remember {
        listOf("Paid", "Free")
    }
    var selectedFeesFilter by remember {
        mutableStateOf("")
    }

    val onFilterClick: () -> Unit = {
        scope.launch {
            if (state.isVisible) {
                state.hide()
                return@launch
            }
            state.show()
        }
    }

    val onResetFilterClick: () -> Unit = {
        selectedSubcategoryFilter.clear()
        selectedFeesFilter = ""
    }


    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        sheetContent = {
            Spacer(modifier = Modifier.height(16.dp))
            FilterBottomSheetHeader(
                onResetClick = onResetFilterClick,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            MultipleChipFilterWithLabel(
                label = "Subcategory",
                selectedOption = selectedSubcategoryFilter,
                options = subcategoryFilter,
                onClick = onSubcategoryFilterSelected,
                type = ChipFilterType.MEDIA_PARTNER,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            SingleChipFilterWithLabel(
                label = "Fees",
                selectedOption = selectedFeesFilter,
                options = feesFilter,
                onClick = { selectedFeesFilter = it },
                type = ChipFilterType.MEDIA_PARTNER,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(42.dp))
            SmallPrimaryButton(
                text = "Active",
                onClick = onFilterClick,
                modifier = Modifier
                    .padding(20.dp)
                    .navigationBarsPadding()
                    .fillMaxWidth()
            )
        },
        modifier = modifier
    ) {
        MediaPartnerMenuContent(
            navigateUp = navigateUp,
            query = query,
            onQueryChange = viewModel::updateQuery,
            eventNeedItems = eventNeedItems,
            onFilterClick = onFilterClick
        ) { navigateToMediaPartnerDetail(it.id) }
    }
}

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun MediaPartnerMenuContent(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    query: String,
    onQueryChange: (String) -> Unit,
    eventNeedItems: LazyPagingItems<EventNeedItem>,
    onFilterClick: () -> Unit,
    onEventClick: (EventNeedItem) -> Unit
) {
    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Media Partner",
                onNavigationClick = navigateUp
            )
        },
        modifier = modifier
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.navigationBarsPadding(),
            contentPadding = paddingValues
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                SearchBarWithFilter(
                    value = query,
                    onValueChange = onQueryChange,
                    placeholder = "Search Media Partner",
                    onFilterClick = onFilterClick,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(eventNeedItems.itemCount) { index ->
                val modifierItem = if (index % 2 == 0) {
                    Modifier.padding(start = 20.dp, bottom = 8.dp)
                } else {
                    Modifier.padding(end = 20.dp, bottom = 8.dp)
                }
                val eventNeedItem = eventNeedItems[index] ?: return@items
                EventNeedItem(
                    eventNeedItem = eventNeedItem,
                    onClick = onEventClick,
                    modifier = modifierItem
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@Preview
@Composable
fun PreviewMediaPartnerMenuScreen() {
    EventhngsTheme {
        Surface {
            MediaPartnerMenuScreen()
        }
    }
}
