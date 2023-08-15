package com.priyank.levitate.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.Purple

// TODO:  Change Fix the Ui
@Composable
fun ConsentScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(26.dp),

    ) {
        Text(
            modifier = Modifier.padding(start = 34.dp, top = 52.dp),
            text = "Welcome to,",
            fontSize = 32.sp,
            fontFamily = Lato,
        )
        Text(
            modifier = Modifier.padding(start = 34.dp),
            text = "Levitate",
            fontSize = 32.sp,
            fontFamily = FuturaMedium,

            fontWeight = FontWeight(700),
            color = Purple,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(30f)
                .padding(start = 34.dp, top = 35.dp, bottom = 30.dp)
                .heightIn(max = 400.dp)
                .verticalScroll(
                    rememberScrollState(),
                ),
            text = "Lorem ipsum dolor sit amet consectetur adipiscing elit\n\n, urna consequat felis vehicula class ultricies mollis dictumst\n, aenean non a in donec nulla\n\n. Phasellus ante pellentesque erat cufm risus\n consequat imperdiet aliquam\n, integer placerat et turpis mi eros nec lobortis taciti, vehicula nisl litora tellus ligula \nporttitor metus cufm risus consequat imperdiet aliquam\n, integer placerat et turpis.Phasellus ante pellentesque erat cufm risus\n" +
                " consequat imperdiet aliquam\n\"Lorem ipsum dolor sit amet consectetur adipiscing elit\\n\\n, urna consequat felis vehicula class ultricies mollis dictumst\\n, aenean non a in donec nulla\\n\\n. Phasellus ante pellentesque erat cufm risus\\n consequat imperdiet aliquam\\n, integer placerat et turpis mi eros nec lobortis taciti, vehicula nisl litora tellus ligula \\nporttitor metus cufm risus consequat imperdiet aliquam\\n, integer placerat et turpis.Phasellus ante pellentesque erat cufm risus\\n\" +\n" +
                "                    \" consequat imperdiet aliquam\\n\"" +
                ", integer placerat et turpis mi eros nec lobortis taciti, vehicula nisl litora tellus ligula \n  integer placerat et turpis mi eros nec lobortis taciti, vehicula nisl litora tellus ligula \\n\" integer placerat et turpis mi eros nec lobortis taciti, vehicula nisl litora tellus ligula \\n\"",

            fontSize = 16.sp,
            fontFamily = Lato,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            var check =
                true

            Checkbox(
                modifier = Modifier
                    .size(10.dp)
                    .padding(top = 4.dp),
                checked = check,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(
                    checkedColor = Purple,
                    uncheckedColor = Color.Gray,
                    checkmarkColor = Color.White,
                    disabledColor = Color.Gray,
                ),
            )
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "I accept the terms and conditions.",
                fontSize = 18.sp,
                fontFamily = Lato,
                fontWeight = FontWeight(700),

            )
        }
        Button(
            modifier = Modifier
                .padding(top = 40.dp)
                .align(Alignment.End),
            shape = RoundedCornerShape(25.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple),
        ) {
            Text(
                text = "Continue",
                fontSize = 24.sp,
                fontFamily = Lato,
                fontWeight = FontWeight(400),
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
fun PreviewConsentScreen() {
    ConsentScreen(navHostController = NavHostController(LocalContext.current))
}
