package co.cyclopsapps.mvvmpractice.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Carlos Daniel Agudelo on 18/10/2020.
 */
abstract class BaseViewHolder<T> (itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position: Int)
}