package com.russihersi.githubuserdicodingsubmission

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>

    private var userList = arrayListOf<User>()

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(this::onItemClick)
        val layoutManager = LinearLayoutManager(this)
        rvMain.adapter = adapter
        rvMain.layoutManager = layoutManager
        rvMain.addItemDecoration(DividerItemDecoration(applicationContext, layoutManager.orientation))

        prepare()
        addItem()
    }

    private fun onItemClick(user : User){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("datauser", user)
        startActivity(intent)
    }

    private fun prepare(){
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem(){
        for (position in dataName.indices) {
            val listuser = User(
                    dataUsername[position],
                    dataName[position],
                    dataAvatar.getResourceId(position, -1),
                    dataCompany[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataFollower[position],
                    dataFollowing[position]
            )
            userList.add(listuser)
        }
        dataAvatar.recycle()
        adapter.userAdapter = userList
    }

}






