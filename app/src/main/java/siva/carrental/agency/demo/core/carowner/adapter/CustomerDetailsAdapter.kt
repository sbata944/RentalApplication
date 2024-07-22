package siva.carrental.agency.demo.core.carowner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import siva.android.car.agency.R
import siva.carrental.agency.demo.api.model.CustomerDetailsModel

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/12/2024.
 *
 */
internal class CustomerDetailsAdapter (private var customerDetailsList: List<CustomerDetailsModel>) :
    RecyclerView.Adapter<CustomerDetailsAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mIDNameGender: TextView = view.findViewById(R.id.id_name_gender)
        var mCrossedLimit: TextView = view.findViewById(R.id.crossed_limit)
        var mModelLimit: TextView = view.findViewById(R.id.model_limit)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_car_rented_list, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val customerDetails = customerDetailsList[position]
        holder.mIDNameGender.text = "${customerDetails.getUserID()} -- ${customerDetails.getUserName()} -- ${customerDetails.getGender()}"
        holder.mCrossedLimit.text = "${customerDetails.getCrossedLimit()}"
        holder.mModelLimit.text = "${customerDetails.getCarModel()} -- ${customerDetails.getSpeedLimit()}"

        holder.mModelLimit.setOnClickListener{
            // Show Alert dialog and set the speed to the user.
            // API call from Activity to model class.
        }
    }
    override fun getItemCount(): Int {
        return customerDetailsList.size
    }
}