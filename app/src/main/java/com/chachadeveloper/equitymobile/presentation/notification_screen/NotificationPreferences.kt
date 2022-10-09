package com.chachadeveloper.equitymobile.presentation.notification_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.ui.theme.primaryGray
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun NotificationPreferences(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            showBackArrow = true,
            title = "Notification Prefences"
        )


        Column (verticalArrangement = Arrangement.Top){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ){
                Column (modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                ){
                    Text(
                        text = "Set your notification_screen preferences" ,
                        maxLines = 1,
                        style= MaterialTheme.typography.body2,
                        color = Color.White

                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(text = "Select which notifications you would like to receive",
                        maxLines = 1,
                        style = MaterialTheme.typography.body2,
                        color = Color.White
                    )



                    /* Other cards */

                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column{
                            Text(
                                text = "Service update",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = " Get alerts about any upgrade,outages or schedule downtime",
                                maxLines = 2,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                        Column {
                            Box(modifier =
                            Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ){
                                Icon(
                                    painter =
                                    painterResource(id = R.drawable.ic_chevron_right),
                                    tint = primaryPink,
                                    contentDescription = null,

                                    /*finish on spamnser*/

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))


                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column{
                            Text(
                                text = "Reminders",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "get notified when your schedule payment are coming up",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                        Column {
                            Box(modifier =
                            Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ){
                                Icon(
                                    painter =
                                    painterResource(id = R.drawable.ic_chevron_right),
                                    tint = primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column{
                            Text(
                                text = "Bank account alters",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Get important update about your bankaccessor cards",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                        Column {
                            Box(modifier =
                            Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ){
                                Icon(
                                    painter =
                                    painterResource(id = R.drawable.ic_chevron_right),
                                    tint = primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))


                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column{
                            Text(
                                text = "Marketing content",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "We'll let you know about new product to promotion",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                        Column {
                            Box(modifier =
                            Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ){
                                Icon(
                                    painter =
                                    painterResource(id = R.drawable.ic_chevron_right),
                                    tint = primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column{
                            Text(
                                text = "Events",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Get notified about any upcominging important events",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                        Column {
                            Box(modifier =
                            Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ){
                                Icon(
                                    painter =
                                    painterResource(id = R.drawable.ic_chevron_right),
                                    tint = primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )







                }


            }
        }

    }


}