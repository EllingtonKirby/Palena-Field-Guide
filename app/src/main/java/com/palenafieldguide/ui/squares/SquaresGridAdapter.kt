package com.palenafieldguide.ui.squares

import android.support.transition.Fade
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.palenafieldguide.R
import com.palenafieldguide.api.models.SquaresModel
import com.palenafieldguide.ui.mvp.recycler.BaseViewHolder
import com.palenafieldguide.ui.squares.SquaresGridAdapter.SquaresGridViewHolder
import com.palenafieldguide.ui.squares.detail.DetailsTransition
import com.palenafieldguide.ui.squares.detail.SquaresDetailFragment
import kotlinx.android.synthetic.main.item_squares_view.*
import kotlinx.android.synthetic.main.item_squares_view.view.*
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
        squaresView.transitionName = position.toString()
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
            val squaresView = view as SquaresItemView
            val newFragment = SquaresDetailFragment.newInstance()

            newFragment.sharedElementEnterTransition = DetailsTransition()
            newFragment.enterTransition = Fade()
            newFragment.sharedElementReturnTransition = DetailsTransition()
            newFragment.exitTransition = Fade()

            fragment.fragmentManager?.beginTransaction()
                    ?.setReorderingAllowed(true) // Optimize for shared element transition
                    ?.addSharedElement(squaresView.squares_image, "squaresImage")
                    ?.add(
                            R.id.container,
                            newFragment,
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
//            squares_image.transitionName = "squaresImage"
        }
    }
}
