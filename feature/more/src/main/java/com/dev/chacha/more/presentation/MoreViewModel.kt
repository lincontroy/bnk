package com.dev.chacha.more.presentation

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.chacha.data.use_case.BiometricUseCase
import com.dev.chacha.ui.common.theme.ThemeMode
import com.dev.chacha.ui.common.theme.switchTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreViewModel  @Inject constructor(
    private val biometricUseCase: BiometricUseCase
): ViewModel() {
    private val _moreUiState = MutableStateFlow(MoreUiState())
    val moreUiState: StateFlow<MoreUiState> = _moreUiState

    private val _shouldShowDialog = mutableStateOf(true)
    val shouldShowDialog: State<Boolean> = _shouldShowDialog

    fun setShowDialogState(value: Boolean) {
        _shouldShowDialog.value = value
    }

    init {
        getBiometrics()
    }


    fun onEvent(event: MoreUiEvent){
        when(event){
            is MoreUiEvent.EnableBiometricToggled -> {
                saveBiometric(isBiometricEnabled  = event.isBiometricEnabled)
                getBiometrics()
            }

            is MoreUiEvent.EnableBankAlertToggled -> {
                saveBankAlert(isMarketContentEnabled   = event.isBankAlertEnabled)
                getBiometrics()

            }
            is MoreUiEvent.EnableEventToggled -> {
                saveBankEvent(isMarketContentEnabled   = event.isEventEnabled)
                getBiometrics()

            }
            is MoreUiEvent.EnableMarketContentToggled -> {
                saveMarketContent(isMarketContentEnabled   = event.isMarketContentEnabledEnabled)
                getBiometrics()

            }
            is MoreUiEvent.EnableServiceUpdateToggled -> {
                saveServiceUpdate(isMarketContentEnabled   = event.isServiceUpdateEnabled)
                getBiometrics()
            }
        }
    }



    private fun getBiometrics() {
        viewModelScope.launch {
            biometricUseCase.execute().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isBiometricEnabled  = enabled) }
                }
            }

            biometricUseCase.executeBankAlert().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isBankAlertAlertEnabled = enabled) }
                }
            }
            biometricUseCase.executeMarketContent().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isMarketContentEnabled = enabled) }
                }
            }

            biometricUseCase.executeBankService().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isServiceUpdateEnabled = enabled) }
                }
            }

            biometricUseCase.executeBankEvent().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isEventEnabled = enabled) }
                }
            }


        }
    }

    private fun saveBiometric(isBiometricEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.execute(isBiometricEnabled  = isBiometricEnabled)
        }
    }

    private fun saveBankAlert(isMarketContentEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.executeBankAlert(isBankAlertEnabled  = isMarketContentEnabled)
        }
    }

    private fun saveServiceUpdate(isMarketContentEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.executeMarketContent(isMarketContentEnabled  = isMarketContentEnabled)
        }
    }
    private fun saveBankEvent(isMarketContentEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.executeMarketContent(isMarketContentEnabled  = isMarketContentEnabled)
        }
    }
    private fun saveMarketContent(isMarketContentEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.executeMarketContent(isMarketContentEnabled  = isMarketContentEnabled)
        }
    }
}