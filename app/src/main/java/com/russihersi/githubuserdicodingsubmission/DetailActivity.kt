package com.russihersi.githubuserdicodingsubmission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_user_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val data = intent.getParcelableExtra<User>("datauser")

        Glide.with(this)
            .load(data?.Avatar)
            .into(image_user)

        name.text = data?.Name.toString()
        username_detail.text = data?.Username
        repository.text = "${data?.Repository.toString()}"
        followers.text = "${data?.Follower.toString()}"
        following.text = "${data?.Following.toString()}"
        location.text = "${data?.Location.toString()}"
        company.text = "${data?.Company.toString()}"

    }
}