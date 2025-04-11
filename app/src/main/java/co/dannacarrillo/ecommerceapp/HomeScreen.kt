package co.dannacarrillo.ecommerceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            val scrollBehavior =
                TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Bienvenido/a",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Promociones destacadas",
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 8.dp)
                )

            val listadoPromociones = listOf(
                "https://img.freepik.com/psd-gratis/plantilla-pagina-destino-buen-fin-diseno-plano_23-2150851933.jpg",
                "https://img.pikbest.com/backgrounds/20201007/special-offer-sale-fire-burn-template-discount-banner-promotion-concept-design-v_3122874jpg!w700wp",
                "https://img.freepik.com/vector-premium/plantilla-banner-promocion-venta_74379-177.jpg",
                "https://img.freepik.com/psd-premium/promocion-plantilla-banner-descuento-mega-venta_501916-114.jpg",
                "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/black-friday-poster-design-template-fda328238fd634d3c320ec9176dae814_screen.jpg?ts=1606403389"
            )

            LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {CardPromo(listadoPromociones[0]) }
                item {CardPromo(listadoPromociones[1]) }
                item {CardPromo(listadoPromociones[2]) }
                item {CardPromo(listadoPromociones[3]) }
                item {CardPromo(listadoPromociones[4]) }
            }

        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


@Composable
fun CardPromo(urlImage : String) {
    Card(
        modifier = Modifier
            .height(180.dp)
            .width(300.dp),
        shape = RoundedCornerShape(16.dp)

    ) {
        Image(
            painter = rememberAsyncImagePainter(urlImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    }
}