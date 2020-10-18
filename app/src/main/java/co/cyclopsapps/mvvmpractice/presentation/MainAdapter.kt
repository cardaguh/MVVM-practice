package co.cyclopsapps.mvvmpractice.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.mvvmpractice.R
import co.cyclopsapps.mvvmpractice.data.Restaurant
import co.cyclopsapps.mvvmpractice.utils.BaseViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.restaurant_row.view.*

/**
 * Created by Carlos Daniel Agudelo on 18/10/2020.
 */

class MainAdapter(
    private val context: Context,
    private val restaurantList: List<Restaurant>
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.restaurant_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is MainViewHolder -> holder.bind(restaurantList[position], position)
        }
    }

    inner class MainViewHolder(itemView: View): BaseViewHolder<Restaurant>(itemView) {
        override fun bind(item: Restaurant, position: Int) {
            Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_restaurant)
            itemView.txt_titulo.text = item.nombre
            itemView.txt_descripcion.text = item.description
        }


    }

}



