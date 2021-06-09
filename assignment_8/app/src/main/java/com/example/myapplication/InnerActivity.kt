package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.adapter.UserListAdapter
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.api.dto.ReqresData
import com.example.myapplication.api.dto.User
import com.example.myapplication.api.dto.myData
import kotlinx.android.synthetic.main.activity_inner.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class InnerActivity : AppCompatActivity() {
    private var id = "1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inner)
        id = intent.getStringExtra("id").toString()

        RetrofitClient.reqResApi.getUserInfo(id)
            .enqueue(object : Callback<myData> {
                override fun onResponse(
                    call: Call<myData>,
                    response: Response<myData>
                ) {
                    Log.d("mariam", response.body()!!.data.toString())

                    inner.layoutManager = LinearLayoutManager(this@InnerActivity)

                    inner.adapter = response.body()!!.data?.let { UserAdapter(listOf(it) )}
                }

                override fun onFailure(call: Call<myData>, t: Throwable) {
                    Log.d("mariam", t.toString())
                }

            })
    }
}