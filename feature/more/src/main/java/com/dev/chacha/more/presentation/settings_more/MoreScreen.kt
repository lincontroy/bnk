package com.dev.chacha.more.presentation.settings_more


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dev.chacha.more.presentation.MoreViewModel
import com.dev.chacha.more.presentation.component.MoreUserAccount
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItemWithCard
import com.dev.chacha.ui.common.components.StandardToolbar
import com.chachadeveloper.designsystem.theme.DefaultBackground
import com.chachadeveloper.designsystem.theme.ThemeMode
import com.chachadeveloper.designsystem.theme.switchTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MoreScreen(
    navigateToNotifications: () -> Unit,
    navigateToSecurity: () -> Unit,
    navigateToGetInTouch: () -> Unit,
    navigateToChangeLanguage: () -> Unit,
    navigateToRecommendToFriend: () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()


    val moreViewModel: MoreViewModel = hiltViewModel()
    val moreUiState by moreViewModel.moreUiState.collectAsStateWithLifecycle()
    val uriHandler = LocalUriHandler.current

    val userName = "Stephen Chacha"
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.background
            ) {
                Spacer(modifier = Modifier.height(12.dp))

                Column(
                    modifier = Modifier
                        .padding(NavigationDrawerItemDefaults.ItemPadding),
                    verticalArrangement = Arrangement.Top
                ) {

                    MoreUserAccount()


                    MoreVerticalItemWithCard(
                        drawable = R.drawable.whatsapp,
                        title = R.string.activate_chat_banking,
                        onClick = {
                            uriHandler.openUri("https://equitygroupholdings.com/ke")

                        },
                        showColorFilter = true
                    )
                    MoreVerticalItemWithCard(
                        drawable = R.drawable.outline_phone_android,
                        title = R.string.recommed,
                        onClick = {}
                    )
                    MoreVerticalItemWithCard(
                        drawable = R.drawable.outline_headset_mic_24,
                        title = R.string.get_in_touch,
                        onClick = {
                            navigateToGetInTouch()
                        }
                    )
                    MoreVerticalItemWithCard(
                        drawable = R.drawable.outline_light_mode_24,
                        title = R.string.dark_mode,
                        showSwitcher = true,
                        onClick = {},
                        onCheckChange = {
                        },
                        isChecked = moreUiState.isDarkModeEnabled?: false
                    )
                    MoreVerticalItemWithCard(
                        drawable = R.drawable.outline_power_settings_new_24,
                        title = R.string.sign_out,
                        onClick = {
                            navigateToGetInTouch()
                        }
                    )


                }

            }
        },
        drawerState = drawerState,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Scaffold(
            topBar = {
                StandardToolbar(
                    title = "Settings and more",
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = com.chachadeveloper.designsystem.theme.DefaultBackground
                    ),
                    showTitleWithUsername = true,
                    userName = "Stephen Chacha",
                    onNavigateBack = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
            containerColor = com.chachadeveloper.designsystem.theme.DefaultBackground
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(com.chachadeveloper.designsystem.theme.DefaultBackground)
                    .padding(paddingValues)
                    .padding(start = 24.dp, end = 16.dp)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            MoreUserAccount()
                            MoreVerticalItemWithCard(
                                drawable = R.drawable.outline_notifications_none_24,
                                title = R.string.notifications_title,
                                subtitle = R.string.notifications_subtitle,
                                onClick = {
                                    navigateToNotifications()
                                }
                            )
                            MoreVerticalItemWithCard(
                                drawable = R.drawable.outline_language_24,
                                title = R.string.change_language_title,
                                onClick = {
                                    navigateToChangeLanguage()
                                }
                            )
                        }

                    }
                    item {
                        Text(
                            text = "Support",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            MoreVerticalItemWithCard(
                                drawable = R.drawable.whatsapp,
                                title = R.string.activate_chat_banking,
                                subtitle = R.string.activate_chat_banking_desc,
                                onClick = {
                                    uriHandler.openUri("https://equitygroupholdings.com/ke")

                                },
                                showColorFilter = true
                            )
                            MoreVerticalItemWithCard(
                                drawable = R.drawable.outline_headset_mic_24,
                                title = R.string.get_in_touch,
                                subtitle = R.string.get_in_touch_subtitle,
                                onClick = {
                                    navigateToGetInTouch()
                                }
                            )


                        }

                    }

                    item {
                        Text(
                            text = "Security",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    item {
                        MoreVerticalItemWithCard(
                            drawable = R.drawable.outline_verified_user_24,
                            title = R.string.security_title,
                            subtitle = R.string.security_subtitle,
                            onClick = {
                                navigateToSecurity()
                            }
                        )
                    }

                    item {
                        Text(
                            text = "About us",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    item {
                        MoreVerticalItemWithCard(
                            drawable = R.drawable.outline_phone_android,
                            title = R.string.recommed,
                            subtitle = R.string.recommend_equity_to_friend_title,
                            onClick = {}
                        )
                    }

                    item {
                        Box {}
                    }

                }
            }

        }
    }

    fun handleSwitchTheme(mode: com.chachadeveloper.designsystem.theme.ThemeMode) {
        coroutineScope.launch {
            com.chachadeveloper.designsystem.theme.switchTheme(context, mode)
//            onClose()
        }
    }

}

fun handleSwitchTheme(mode: com.chachadeveloper.designsystem.theme.ThemeMode, context:Context, coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        com.chachadeveloper.designsystem.theme.switchTheme(context, mode)
//            onClose()
    }
}