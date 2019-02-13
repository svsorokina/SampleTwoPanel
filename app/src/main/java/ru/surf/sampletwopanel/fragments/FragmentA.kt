package ru.surf.sampletwopanel.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.surf.sampletwopanel.R

private const val STATE_CLICK_COUNT = "state_click_count"

class FragmentA : Fragment() {

    private lateinit var onFragmentAClickListener: OnFragmentAClickListener

    private var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            i = savedInstanceState.getInt(STATE_CLICK_COUNT)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (activity is OnFragmentAClickListener) {
            onFragmentAClickListener = activity as OnFragmentAClickListener
        } else {
            throw ClassCastException(activity!!.toString() + "not implement OnFragmentAClickListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button)
            .setOnClickListener { onFragmentAClickListener.onClick(++i) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_CLICK_COUNT, i)
    }
}
