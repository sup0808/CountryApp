import androidx.annotation.NavigationRes
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.countryapp.presenter.Navigation.NavigationItem
import com.demo.countryapp.presenter.UserList.UserListViewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun NavigationCom(){
    val navController = rememberNavController()

    /*NavHost(navController = navController, startDestination =NavigationItem.UserListNavigationItem.route ){
        composable(route = NavigationItem.UserListNavigationItem.route){
                UserListScreen()
        }
        composable(route = NavigationItem.CountryListNavigationItem.route){

        }
    }*/

}