package dam.pmdm.recyclerapp.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import dam.pmdm.recyclerapp.R
import dam.pmdm.recyclerapp.databinding.ActivityMainBinding
import dam.pmdm.recyclerapp.utils.NotificationHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recoge el NavController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Configuración de AppBar para sincronizar la barra de acción con NavController
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController)
        // Cambiar el color de la barra de estado
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        checkNotificationPermission()
        initializeNotificacion()

    }

    private fun initializeNotificacion() {
        // Crear y mostrar la notificación después de 5 segundos
        NotificationHelper(this).apply {
            createNotificationChannel()
            lifecycleScope.launch {
                delay(5000) // Pausar durante 5 segundos
                showGameNotification("¡Hola, Jugador!", "¡Echa un vistazo al nuevo juego de Super Mario!")
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
            }
        }
    }


}
