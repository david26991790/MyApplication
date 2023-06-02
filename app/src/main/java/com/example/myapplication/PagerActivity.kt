package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

const val POSITION_KEY = "POSITION_KEY"

data class Q(
    val number: Int,
    val question: String,
    val op_a: String,
    val op_b: String,
    val op_c: String
)

val qArrayList = arrayListOf<Q>(
    Q(1, "1+1=?", "1", "2", "3"),
    Q(1, "1+2=?", "1", "2", "3"),
    Q(1, "2-1=?", "1", "2", "3"),

    )

class PagerActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)

        viewPager = findViewById<ViewPager2>(R.id.pager)
        viewPager.adapter = MyPagerAdapter(this)
    }

    class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return qArrayList.size
        }

        override fun createFragment(position: Int): Fragment {
            val qf = QuestionFragment()
            qf.arguments = Bundle().apply {
                putInt(POSITION_KEY, position)
            }
            return qf
        }

    }

    class QuestionFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return inflater.inflate(R.layout.question_layout, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            arguments?.takeIf { it.containsKey(POSITION_KEY) }?.apply {
                val tv_number = view.findViewById<TextView>(R.id.tv_number)
                val tv_question = view.findViewById<TextView>(R.id.tv_question)
                val tv_op_a = view.findViewById<TextView>(R.id.tv_op_a)
                val tv_op_b = view.findViewById<TextView>(R.id.tv_op_b)
                val tv_op_c = view.findViewById<TextView>(R.id.tv_op_c)
            }
        }
    }
}
