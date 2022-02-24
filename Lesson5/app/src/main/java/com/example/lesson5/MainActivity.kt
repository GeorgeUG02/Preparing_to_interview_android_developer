package com.example.lesson5
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var vm :MainViewModel
    private lateinit var adapter: PostsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = PostsAdapter()
        val rv = findViewById<RecyclerView>(R.id.postsList)
        rv.adapter=adapter
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.liveData.observe (this){
            adapter.setData(it.data.children)
        }
        vm.getData()
        var loading = true
        var pastVisiblesItems: Int
        var visibleItemCount: Int
        var totalItemCount: Int

        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    visibleItemCount = (recyclerView.layoutManager as LinearLayoutManager).getChildCount()
                    totalItemCount = (recyclerView.layoutManager as LinearLayoutManager).getItemCount()
                    pastVisiblesItems = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            vm.getData()
                            loading = true
                        }
                    }
                }
            }
        })

    }
}