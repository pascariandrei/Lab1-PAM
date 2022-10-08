package com.example.myapplication


import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.fragments.FloatCalculationFragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.MainFragment
import com.example.myapplication.fragments.SecondaryFragment
import com.example.myapplication.fragments.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

        setUpTabs()
//        val result = findViewById<TextView>(R.id.text1)
//val clickbtn = findViewById<Button>(R.id.button123)
//        val num = 10
//        clickbtn.setOnClickListener {
//            result.text = num.toString()
//        }

//        var decnum=findViewById<EditText>(R.id.edittext)
//        val result = findViewById<TextView>(R.id.text1)
//        val clickbtn = findViewById<Button>(R.id.button123)
//        clickbtn.setOnClickListener {
//             //val decnum1 = decnum.getText()
//            val decnum1 = Integer.parseInt(decnum.getText().toString())
//            val bin = Integer.toBinaryString(decnum1)
//            result.text = bin.toString()
//        }
}
    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), title = "10->2")
        adapter.addFragment(MainFragment(), title = "2->10")
        adapter.addFragment(SecondaryFragment(), title= "+,-")
        adapter.addFragment(FloatCalculationFragment(), title= "''")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_filter_1_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_filter_2_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_filter_3_24)
        tabs.getTabAt(3)!!.setIcon(R.drawable.ic_baseline_filter_3_24)

//        tabs.getTabAt(0)!!.getIcon()?.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
//        tabs.getTabAt(1)!!.getIcon()?.setColorFilter(Color.BLUE,PorterDuff.Mode.SRC_IN);
//        tabs.getTabAt(2)!!.getIcon()?.setColorFilter(Color.BLUE,PorterDuff.Mode.SRC_IN);
//
//        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(tabs.Tab tab) {
//                tabs.getIcon().setColorFilter(Color.GREEN,PorterDuff.Mode.SRC_IN);
//
//            }
//
//            @Override
//            public void onTabUnselected(tabs.Tab tab) {
//                //for removing the color of first icon when switched to next tab
//                tabs.getTabAt(0).getIcon().clearColorFilter();
//                //for other tabs
//                tab.getIcon().clearColorFilter();
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });}


    }


}