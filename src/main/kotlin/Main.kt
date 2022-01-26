
import com.krish.hms.ui.Activity
import com.krish.hms.ui.UIHandler
import com.krish.hms.ui.ViewModel

fun main() {

    val uiHandler = UIHandler()
    val viewModule = ViewModel(uiHandler)

    val activity = Activity(viewModule, uiHandler)
    activity.launch()

}