package co.cyclopsapps.mvvmpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RestaurantAdapter: RecyclerView.Adapter<RestaurantAdapter.MyHolder>() {

    private var  restaurantList: MutableList<Restaurant> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_row, parent, false)
        return MyHolder(layoutView)
    }


    fun setRestaurantList(newDataList : MutableList<Restaurant>) {
        restaurantList.clear()
        restaurantList.addAll(newDataList)
        notifyDataSetChanged()
  }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val restaurantData = restaurantList[position]

        with(restaurantData) {
            Glide.with(holder.itemView.context).load(imagen).into(holder.imgRestaurant)
            holder.txtResturantTitle.text = nombre

        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgRestaurant: ImageView = itemView.findViewById(R.id.img_restaurant)
        val txtResturantTitle: TextView = itemView.findViewById(R.id.txt_titulo)
    }


}