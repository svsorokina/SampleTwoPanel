package ru.surf.sampletwopanel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.surf.sampletwopanel.R

class FragmentB : Fragment() {

    private lateinit var textView: TextView

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            count = arguments!!.getInt(ARG_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.text_view)
        textView.text = count.toString()
    }

    companion object {

        private const val ARG_COUNT = "arg_count"

        fun newInstance(count: Int): FragmentB {
            val fragment = FragmentB()
            val args = Bundle()
            args.putInt(ARG_COUNT, count)
            fragment.arguments = args
            return fragment
        }
    }
}
