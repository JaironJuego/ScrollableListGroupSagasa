package com.example.scrollablelistgroupsagasa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrollablelistgroupsagasa.ui.theme.ScrollableListGroupSagasaTheme

data class GroupMember(
    val name: String,
    val role: String = "Member",
    @param:DrawableRes val imageRes: Int? = null
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollableListGroupSagasaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GroupMemberList(
                        members = getGroupMembers(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun getGroupMembers(): List<GroupMember> {
    return listOf(
        GroupMember(name = "Juego, Jairon", role = "Leader"),
        GroupMember(name = "Macul, Gabriel", role = "Member"),
        GroupMember(name = "Abdula, Jireh", role = "Member"),
        GroupMember(name = "Samantha, Lamasa", role = "Member"),
        GroupMember(name = "Bantillo, Jane Camille", role = "Member"),
        GroupMember(name = "Gabac, Maria Jamaica", role = "Member"),
        GroupMember(name = "Andrino, Carlz", role = "Member"),
        GroupMember(name = "Ostan,John mark ", role = "Member"),
        GroupMember(name = "Nikko, Payadyad", role = "Member"),
        GroupMember(name = "Capili,John gabriel ", role = "Member"),

    )
}

@Composable
fun MemberCard(member: GroupMember, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            member.imageRes?.let { resId ->
                Image(
                    painter = painterResource(id = resId),
                    contentDescription = member.name,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
            }

            Column {
                Text(
                    text = member.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = member.role,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun GroupMemberList(members: List<GroupMember>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(members) { member ->
            MemberCard(
                member = member,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GroupMemberListPreview() {
    ScrollableListGroupSagasaTheme {
        GroupMemberList(members = getGroupMembers())
    }
}