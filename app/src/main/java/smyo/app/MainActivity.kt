package smyo.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_login.*
import kotlinx.android.synthetic.main.user_registration.*
import kotlinx.android.synthetic.main.fragment_addoutfit.*


class MainActivity : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    private fun showRegistration(){
        register_layout.visibility=View.VISIBLE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.GONE
    }

    private fun showLogin(){
        login_layout.visibility=View.VISIBLE
        register_layout.visibility=View.GONE
        home_ll.visibility=View.GONE
    }

    private fun showHome(){
        register_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler=DatabaseHelper(this)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_trading, R.id.navigation_addoutfit))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        showHome()

        btnLoginLoad.setOnClickListener{
            showLogin()
        }

        btnRegisterLoad.setOnClickListener{
            showRegistration()
        }

        btnRegister.setOnClickListener{
            handler.insertUserData(name.text.toString(),email.text.toString(),password.text.toString())
            setContentView(R.layout.user_login)
        }

        btnLogin.setOnClickListener{
        if(handler.userPresent(email_login.text.toString(),password_login.text.toString()))
            Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show()
            else
            Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
        }

    }


}
