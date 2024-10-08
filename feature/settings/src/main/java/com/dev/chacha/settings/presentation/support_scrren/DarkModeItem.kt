package com.dev.chacha.settings.presentation.support_scrren

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.theme.DpDimensions


@Composable
fun DarkModeItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    title: String,
//    switchState: SwitchState,
    onState: () -> SwitchState,
    onCheckChange: (Boolean) -> Unit
) {

    Surface(
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = DpDimensions.Small,
                vertical = DpDimensions.Small
            )
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.inversePrimary
            )

            Text(
                text = title, style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier
                    .padding(horizontal = DpDimensions.Normal)
                    .weight(1f)
            )

            Switch(
                checked = onState().isChecked,
                onCheckedChange = { isChecked -> onCheckChange(isChecked) },
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = MaterialTheme.colorScheme.secondaryContainer,
//                    checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                )
            )

        }

    }

}

data class SwitchState(
    val isChecked: Boolean = false
)
