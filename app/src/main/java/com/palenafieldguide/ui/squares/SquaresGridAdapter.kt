package com.palenafieldguide.ui.squares

import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.palenafieldguide.R
import com.palenafieldguide.api.models.SquaresModel
import com.palenafieldguide.ui.mvp.recycler.BaseViewHolder
import com.palenafieldguide.ui.squares.SquaresGridAdapter.SquaresGridViewHolder
import com.palenafieldguide.ui.squares.detail.SquaresDetailFragment
import javax.inject.Inject


class SquaresGridAdapter @Inject constructor(val fragment: SquaresFragment) : RecyclerView.Adapter<SquaresGridViewHolder>() {

    var items: ArrayList<SquaresModel> = ArrayList()
    var mViewHolderListener: ViewHolderListener

    init {
        mViewHolderListener = ViewHolderListenerImpl(fragment)
    }

    override fun onBindViewHolder(holder: SquaresGridViewHolder?, position: Int) {
        val squaresView: SquaresItemView = holder?.itemView as SquaresItemView
        squaresView.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SquaresGridViewHolder {
        return SquaresGridViewHolder(SquaresItemView(parent?.context), mViewHolderListener)
    }

    fun setItems(newItems: List<SquaresModel>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    interface ViewHolderListener {

//        fun onLoadCompleted(view: ImageView, adapterPosition: Int)

        fun onItemClicked(view: View?, adapterPosition: Int)
    }

    class ViewHolderListenerImpl(val fragment: Fragment) : ViewHolderListener {

        override fun onItemClicked(view: View?, adapterPosition: Int) {
            fragment.fragmentManager?.beginTransaction()
//                    ?.setReorderingAllowed(true) // Optimize for shared element transition
//                    ?.addSharedElement(transitioningView, transitioningView.getTransitionName())
                    ?.replace(
                            R.id.container,
                            SquaresDetailFragment.newInstance(),
                            SquaresDetailFragment::class.java.simpleName
                    )
                    ?.addToBackStack(null)
                    ?.commit()
        }

    }

    class SquaresGridViewHolder(val squaresView: SquaresItemView, val mViewHolderListener: ViewHolderListener)
        : BaseViewHolder<SquaresModel>(squaresView) {
        init {
            squaresView.setOnClickListener { v -> mViewHolderListener.onItemClicked(v, adapterPosition) }
        }
    }
}
