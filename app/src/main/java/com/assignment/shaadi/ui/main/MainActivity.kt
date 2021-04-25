package com.assignment.shaadi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.TorrMonk.extension.setVisibility
import com.assignment.shaadi.adapters.UserAdapter
import com.assignment.shaadi.databinding.ActivityMainBinding
import com.assignment.shaadi.entities.user.UserEntity
import com.assignment.shaadi.ui.main.core.MainActivityPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityContractMVP.View {

    private lateinit var binding: ActivityMainBinding
    private var userAdapter: UserAdapter? = null

    @Inject
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.loadUserData()

    }

    override fun loadUserDataInAdapter(users: MutableList<UserEntity>) {
        binding.rvUserList.setHasFixedSize(true)
        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(this, users, presenter)
        binding.rvUserList.adapter = userAdapter
        userAdapter?.notifyDataSetChanged()
    }

    override fun initView() {

    }

    override fun updateUserInAdapter(user: UserEntity, adapterPosition: Int) {
        userAdapter?.updateUser(user, adapterPosition)
    }

    override fun toggleProgressBar(status: Boolean) {
        binding.progressBar.setVisibility(status)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
