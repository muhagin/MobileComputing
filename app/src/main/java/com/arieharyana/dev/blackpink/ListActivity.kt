package com.arieharyana.dev.blackpink

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.arieharyana.dev.blackpink.adapter.AdapterRecycler
import com.arieharyana.dev.blackpink.adapter.MemberListener
import com.arieharyana.dev.blackpink.domain.Member
import kotlinx.android.synthetic.main.activity_list.rvMain

class ListActivity : AppCompatActivity(), MemberListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val listMember = listOf(
                Member(id = 1, name = "Deviate", position = "Rp. 1.400.000", image = "http://shop.consina-adventure.com/image/cache/data/product/PACKS/expert_series/Deviate/deviate-70-RD-800x800.jpg", bio = ""),
                Member(id = 2, name = "Jorasses", position = "Rp. 295.000", image = "http://shop.consina-adventure.com/image/cache/data/product/APPAREL/JACKET/WIND%20BREAKER/jorasses/jorasses-DGR-800x800.jpg", bio = ""),
                Member(id = 3, name = "Dry Bag 25L", position = "Rp. 155.000", image = "http://shop.consina-adventure.com/image/cache/data/product/PACKS/drybag/25L/Dry-Bag-25L-YL-800x800.jpg", bio=""),
                Member(id = 4, name = "Camping Table", position = "Rp. 140.000", image = "http://shop.consina-adventure.com/image/cache/data/product/camp-furniture/camping-table-01-800x800.jpg", bio="")
        )

        val membersAdapter = AdapterRecycler(listMember, this)

        val rv = findViewById<RecyclerView>(R.id.rvMain)
        rv.layoutManager = LinearLayoutManager(this@ListActivity)
        rv.adapter = membersAdapter

    }

    override fun onMemberClick(member: Member) {
        val myIntent = Intent(baseContext, DetailActivity::class.java)
        myIntent.putExtra("MEMBER_NAME", member.name)
        myIntent.putExtra("MEMBER_IMAGE", member.image)
        myIntent.putExtra("MEMBER_BIO", member.bio)

        startActivity(myIntent)
        //Toast.makeText(this, "Member: ${member.name}", Toast.LENGTH_SHORT).show()
    }
}