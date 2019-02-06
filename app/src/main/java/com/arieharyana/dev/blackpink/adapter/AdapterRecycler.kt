package com.arieharyana.dev.blackpink.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arieharyana.dev.blackpink.R
import com.arieharyana.dev.blackpink.domain.Member
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*


class AdapterRecycler(private val members: List<Member>,
                      private val listener: MemberListener) : RecyclerView.Adapter<MemberHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MemberHolder {
        return MemberHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_layout, viewGroup, false))
    }

    override fun getItemCount(): Int = members.size

    override fun onBindViewHolder(holder: MemberHolder, position: Int) {
        holder.bindMember(members[position], listener)
    }
}

interface MemberListener {
    fun onMemberClick(member: Member)
}

class MemberHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvMemberName = view.txtName
    private val tvMemberPos = view.txtPosition
    private val imgMember = view.imgMembers

    fun bindMember(member: Member, listener: MemberListener) {
        tvMemberName.text = member.name
        tvMemberPos.text = member.position
        Picasso.get().load(member.image).into(imgMember)

        itemView.setOnClickListener { listener.onMemberClick(member) }

    }
}