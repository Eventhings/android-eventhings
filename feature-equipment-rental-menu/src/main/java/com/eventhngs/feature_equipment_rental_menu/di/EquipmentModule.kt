package com.eventhngs.feature_equipment_rental_menu.di

import com.eventhngs.feature_equipment_rental_menu.detail.DetailEquipmentViewModel
import com.eventhngs.feature_equipment_rental_menu.list.EquipmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val equipmentModule = module {
    viewModel { EquipmentViewModel(get()) }
    viewModel { DetailEquipmentViewModel(get()) }
}