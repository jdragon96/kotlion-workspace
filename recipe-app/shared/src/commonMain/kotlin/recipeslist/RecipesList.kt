package recipeslist

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Recipe
import sugar


/**
 * Created by abdulbasit on 25/06/2023.
 */

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RecipesListScreen(
    items: List<Recipe>,
    onClick: (recipe: Recipe) -> Unit,
    isLarge: Boolean,
    sharedTransactionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    Box(
        modifier = Modifier.fillMaxSize().background(sugar)
    ) {
        val listState = rememberLazyGridState()
        // LazyVerticalGrid
        // - https://foso.github.io/Jetpack-Compose-Playground/foundation/lazyverticalgrid/
        // - columns: column 내 아이템의 사이즈를 결정
        //  => GridCells.Adaptive: cell 별 최소 너비 결정
        //  => Gridcells.Fixed: 셀 개수 설정
        LazyVerticalGrid(
            state = listState,
            // columns = GridCells.Adaptive(40.dp)
            columns = GridCells.Fixed(if (isLarge) 2 else 1)
        ) {
            if (isLarge.not())
                item {
                    Spacer(modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars))
                }
            items(items.size) { item ->
                val recipe = items[item]
                RecipeListItemWrapper(
                    id = recipe.id,
                    scrollDirection = listState.isScrollingUp(),
                    child = {
                        RecipeListItem(
                            recipe = recipe,
                            onClick = onClick,
                            sharedTransitionScope = sharedTransactionScope,
                            animatedVisibilityScope = animatedVisibilityScope,
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun LazyGridState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}