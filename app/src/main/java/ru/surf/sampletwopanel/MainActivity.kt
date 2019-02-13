package ru.surf.sampletwopanel

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import ru.surf.sampletwopanel.fragments.FragmentB
import ru.surf.sampletwopanel.fragments.OnFragmentAClickListener

class MainActivity : AppCompatActivity(), OnFragmentAClickListener {

    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.fragment_b_container)

        frameLayout.visibility = if (supportFragmentManager.backStackEntryCount != 0) {
            View.VISIBLE
        } else {
            View.GONE
        }

        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                frameLayout.visibility = View.GONE
            }
        }
    }

    override fun onClick(i: Int) {
        frameLayout.visibility = View.VISIBLE
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_b_container, FragmentB.newInstance(i), "tag")
            .addToBackStack(null)
            .commit()
    }
}
