package com.example.decorato.presentation.screens.community.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.decorato.R // تأكدي إن ده اسم الباكدج الصحيح لملف الـ Resources
import com.example.decorato.domain.entity.Post
import com.example.decorato.presentation.components.Text
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityInteractionListener


@Composable
fun PostCard(
    post: Post,
    listener: CommunityInteractionListener,
    modifier: Modifier = Modifier
) {
    val colors = LocalDecoratoAppColors.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        // الزتونة: تأكدي إن surfaceHigh متعرف في الدارك ثيم بلون غامق
        colors = CardDefaults.cardColors(containerColor = colors.surfaceHigh),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // --- Header: Profile Image + Name + Time ---
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = post.user.profileImage,
                    contentDescription = "User Profile Image",
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = post.user.fullName ?: post.user.name,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.W500,
                            color = colors.titleL
                        )
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = null,
                            modifier = Modifier.size(10.dp),
                            tint = colors.hint
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = post.postDate,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = colors.hint
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // --- Description ---
            Text(
                text = post.description,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = colors.body
                )
            )

            // --- Post Image ---
            post.postImageUrl?.let { imageUrl ->
                Spacer(modifier = Modifier.height(12.dp))
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Post Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(167.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
            }



            Spacer(modifier = Modifier.height(16.dp))

            // --- Bottom Bar: Interactions ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // عشان يرمي النص والأيقونة في اليمين
            ) {
                // سكشن الزراير (Like & Download)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Like button
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(colors.primary) // تأكدي إن الـ primary درجته مريحة في الدارك
                            .clickable { listener.onClickLike(post.id) },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like_outline),
                            contentDescription = "Like",
                            modifier = Modifier.size(20.dp),
                            tint = Color.Unspecified
                        )
                    }

                    // Download button
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(colors.primaryVariant) // في الدارك، الـ variant المفروض يبقى أغمق شوية
                            .clickable { listener.onClickDownload(post.postImageUrl) },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_download),
                            contentDescription = "Download",
                            modifier = Modifier.size(width = 14.dp, height = 20.dp),
                            tint = Color.Unspecified
                        )
                    }
                }

                // --- Social Proof Section ---
                Row(
                    verticalAlignment = Alignment.CenterVertically
                    // شلنا الـ padding top عشان يبقى على نفس محاذاة الزراير
                ) {
                    Text(
                        text = "Q&A with Mark & ${post.likesCount} others",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 10.sp,
                            // Hint.copy(alpha = 0.38f) في الدارك مود بيبان أبيض باهت وده صح
                            color = colors.hint.copy(alpha = 0.38f),
                            textAlign = TextAlign.End
                        )
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.ic_like_status),
                        contentDescription = null,
                        modifier = Modifier.size(17.72.dp),
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }
}