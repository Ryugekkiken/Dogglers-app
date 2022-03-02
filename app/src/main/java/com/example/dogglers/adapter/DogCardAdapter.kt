package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(private val context: Context?, private val layout: Int, private val dataset: List<Dog>): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>()
{

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!)
    {
        val imageView: ImageView? = view?.findViewById(R.id.dog_picture)
        val imageViewGrid: ImageView? = view?.findViewById(R.id.dog_picture_grid)
        val nameView: TextView? = view?.findViewById(R.id.dog_name)
        val nameViewGrid: TextView? = view?.findViewById(R.id.dog_name_grid)
        val ageView: TextView? = view?.findViewById(R.id.dog_age)
        val ageViewGrid: TextView? = view?.findViewById(R.id.dog_age_grid)
        val hobbiesView: TextView? = view?.findViewById(R.id.dog_hobbies)
        val hobbiesViewGrid: TextView? = view?.findViewById(R.id.dog_hobbies_grid)
    }

    /**
     * Create new view depending on the layout id given
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder
    {
        val adapterLayout = when(layout)
        {
            1 -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            2 -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
        }

        return DogCardViewHolder(adapterLayout)
    }

    /**
     * Return the size of elements in the dataset
     */
    override fun getItemCount(): Int = dataset.size

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int)
    {
        val item = dataset[position]

        if(layout == 1 || layout == 2)
        {
            holder.nameView?.text = item.name

            if (context != null)
            {
                holder.ageView?.text = context.resources.getString(R.string.dog_age, item.age)
                holder.hobbiesView?.text = context.resources.getString(R.string.dog_hobbies, item.hobbies)
            }

            holder.imageView?.setImageResource(item.imageResourceId)
        }
        else if(layout == 3)
        {
            holder.nameViewGrid?.text = item.name

            if (context != null)
            {
                holder.ageViewGrid?.text = context.resources.getString(R.string.dog_age, item.age)
                holder.hobbiesViewGrid?.text = context.resources.getString(R.string.dog_hobbies, item.hobbies)
            }

            holder.imageViewGrid?.setImageResource(item.imageResourceId)
        }
    }
}
