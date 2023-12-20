package com.eventhngs.feature_all_menu

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
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType
import com.eventhngs.ui.component.bottomsheet.FilterBottomSheetHeader
import com.eventhngs.ui.component.bottomsheet.ChipFilterType
import com.eventhngs.ui.component.bottomsheet.MultipleChipFilterWithLabel
import com.eventhngs.ui.component.bottomsheet.SingleChipFilterWithLabel
import com.eventhngs.ui.component.button.SmallPrimaryButton
import com.eventhngs.ui.component.event.EventNeedItem
import com.eventhngs.ui.component.searchbar.SearchBarWithFilter
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun AllMenuScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    navigateToMediaPartnerDetail: (String) -> Unit = {},
    navigateToSponsorDetailScreen: (String) -> Unit = {},
    navigateToEquipmentDetail: (String) -> Unit = {}
) {

    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )
    val scope = rememberCoroutineScope()

    var query by remember { mutableStateOf("") }

    val categoryFilter = remember {
        listOf("Media Partner", "Sponsor", "Equipment Rental")
    }
    var selectedCategoryFilter by remember {
        mutableStateOf("")
    }
    val type = remember(key1 = selectedCategoryFilter) {
        when (selectedCategoryFilter) {
            "Media Partner" -> ChipFilterType.MEDIA_PARTNER
            "Sponsor" -> ChipFilterType.SPONSOR
            else -> ChipFilterType.EQUIPMENT
        }
    }

    val locationFilter = remember {
        listOf("Jakarta", "Surabaya", "Bandung", "Medan", "Semarang", "Purwokerto", "Makassar")
    }
    val selectedLocationFilter = remember {
        mutableStateListOf("")
    }
    val onLocationFilterSelected: (String) -> Unit = {
        val contains = selectedLocationFilter.contains(it)
        if (contains) {
            selectedLocationFilter.remove(it)
        } else {
            selectedLocationFilter.add(it)
        }
    }

    val feesFilter = remember {
        listOf("Paid", "Free")
    }
    var selectedFeesFilter by remember {
        mutableStateOf("")
    }

    val locationFilterEnabled = remember(key1 = selectedCategoryFilter) {
        selectedCategoryFilter == categoryFilter[2]
    }
    val feesFilterEnabled = remember(key1 = selectedCategoryFilter) {
        selectedCategoryFilter == categoryFilter[1]
    }

    val eventNeedItems = (1..10).map {
        val needItemType = if (it % 2 == 0) EventNeedItemType.EQUIPMENT else EventNeedItemType.SPONSOR
        EventNeedItem(
            id = it.toString(),
            logo = "",
            title = "Your Business Name Here",
            label = listOf("Equipment", "Sponsor", "Media Partner", "Photo Booth"),
            price = 100_000.0,
            rating = 4.0,
            type = needItemType
        )
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
        selectedCategoryFilter = ""
        selectedLocationFilter.clear()
        selectedFeesFilter = ""
    }

    val onItemClick: (EventNeedItem) -> Unit = {
        when (it.type) {
            EventNeedItemType.MEDIA_PARTNER -> navigateToMediaPartnerDetail(it.id)
            EventNeedItemType.SPONSOR -> navigateToSponsorDetailScreen(it.id)
            EventNeedItemType.EQUIPMENT -> navigateToEquipmentDetail(it.id)
        }
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
            SingleChipFilterWithLabel(
                label = "Category",
                selectedOption = selectedCategoryFilter,
                options = categoryFilter,
                onClick = { selectedCategoryFilter = it },
                type = type,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            MultipleChipFilterWithLabel(
                label = "Location",
                selectedOption = selectedLocationFilter,
                options = locationFilter,
                onClick = onLocationFilterSelected,
                enabled = locationFilterEnabled,
                type = type,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            SingleChipFilterWithLabel(
                label = "Fees",
                selectedOption = selectedFeesFilter,
                options = feesFilter,
                onClick = { selectedFeesFilter = it },
                enabled = feesFilterEnabled,
                type = type,
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
        AllMenuContent(
            navigateUp = navigateUp,
            query = query,
            onQueryChange = { query = it },
            eventNeedItems = eventNeedItems,
            onFilterClick = onFilterClick,
            onEventClick = onItemClick
        )
    }
}

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
private fun AllMenuContent(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    query: String,
    onQueryChange: (String) -> Unit,
    eventNeedItems: List<EventNeedItem>,
    onFilterClick: () -> Unit,
    onEventClick: (EventNeedItem) -> Unit
) {
    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "All",
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
                    placeholder = "Search All",
                    onFilterClick = onFilterClick,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(16.dp))
            }
            itemsIndexed(items = eventNeedItems, key = { _, event -> event.id }) { index, eventNeedItem ->
                val modifierItem = if (index % 2 == 0) {
                    Modifier.padding(start = 20.dp, bottom = 8.dp)
                } else {
                    Modifier.padding(end = 20.dp, bottom = 8.dp)
                }
                EventNeedItem(
                    eventNeedItem = eventNeedItem,
                    modifier = modifierItem,
                    onClick = onEventClick
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
fun PreviewAllMenuScreen() {
    EventhngsTheme {
        Surface {
            AllMenuScreen()
        }
    }
}
