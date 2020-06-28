package com.kotlin.kotlin_navabar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import java.nio.channels.AsynchronousFileChannel.open

class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{

    lateinit var homefragment: Homefragment
    lateinit var aboutusfrag: aboutusfrag
    lateinit var contactfrag: contactfrag
lateinit var follow:followfrag
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val actiobar =supportActionBar
        actiobar?.title="Navigation bar"

        val drawerToggle:ActionBarDrawerToggle = object : ActionBarDrawerToggle(this,
            drawerlayout, toolbar,
            (R.string.open),
            (R.string.close)

        )
        {


        }
        drawerToggle.isDrawerIndicatorEnabled=true
        drawerlayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()


        nav_view.setNavigationItemSelectedListener(this)
        homefragment= Homefragment()
      supportFragmentManager
          .beginTransaction()
          .replace(R.id.framelayout,homefragment)
          .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
          .commit()

    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        when(menuItem.itemId)
        {

            R.id.home ->{

                Toast.makeText(this,"Home clicked",Toast.LENGTH_LONG).show()

                homefragment= Homefragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.framelayout,homefragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.about->{

                aboutusfrag= aboutusfrag()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.framelayout,aboutusfrag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.contact->{
                contactfrag= contactfrag()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.framelayout,contactfrag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.follow ->{

                follow=followfrag()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout,follow)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()




            }

        }
        drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {

        if(drawerlayout.isDrawerOpen(GravityCompat.START))
        {

            drawerlayout.closeDrawer(GravityCompat.START)
        }
        else
        {
            super.onBackPressed()
        }
    }
}

