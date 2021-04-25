package com.assignment.shaadi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.TorrMonk.extension.setVisibility
import com.assignment.shaadi.R
import com.assignment.shaadi.constants.Status
import com.assignment.shaadi.databinding.RowItemUserListBinding
import com.assignment.shaadi.entities.user.UserEntity
import com.assignment.shaadi.utils.CircleTransform
import com.squareup.picasso.Picasso

class UserAdapter(
    private val context: Context,
    private val userData: MutableList<UserEntity>,
    private val userAdapterListener: UserAdapterListener
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            RowItemUserListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        )
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userData.get(position)
        holder.bind(currentUser)
    }

    fun updateUser(updatedUser: UserEntity, adapterPosition: Int) {
        userData[adapterPosition] = updatedUser
        notifyItemChanged(adapterPosition)
    }

    inner class UserViewHolder(val binding: RowItemUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

            // Accept
            binding.tvBtnAccept.setOnClickListener {
                val currentUser = userData.get(absoluteAdapterPosition)
                userAdapterListener.acceptUser(currentUser, absoluteAdapterPosition)
            }

            // Decline
            binding.tvBtnDecline.setOnClickListener {
                val currentUser = userData.get(absoluteAdapterPosition)
                userAdapterListener.declineUser(currentUser, absoluteAdapterPosition)
            }

        }

        fun bind(currentUser: UserEntity) {
            binding.apply {
                val name = currentUser.name
                tvUserName.text = "${name?.title} ${name?.first} ${name?.last}"
                ageAddress.text = currentUser.dob?.age.toString().plus(", ").plus(currentUser.location?.city).plus(", ").plus(currentUser.location?.state).plus( ", ").plus(currentUser.location?.country)
                tvDate.text = if(currentUser.registered?.age == 0) "Today" else if(currentUser.registered?.age == 1) "Yesterday" else currentUser.registered?.age.toString().plus(" days ago")

                currentUser.userStatus.let {
                    tvUserStatus.apply {
                        text = "User ${it.status?.name}!"
                    }
                }
                if(currentUser.userStatus.status.toString().equals(Status.ACCEPTED.toString()))
                    tvUserStatus.setTextColor(context.resources.getColor(R.color.colorAccent))
                else
                    tvUserStatus.setTextColor(context.resources.getColor(R.color.red))

                toggleButtonView(currentUser.userStatus.voted)

                Picasso.get()
                    .load( currentUser.picture?.large)
                    .transform(CircleTransform())
                    .into(binding.civPersonProfilePic)
            }
        }

        private fun toggleButtonView(voted: Boolean) {
            binding.llButton.setVisibility(!voted)
            binding.tvUserStatus.setVisibility(voted)
        }
    }
}