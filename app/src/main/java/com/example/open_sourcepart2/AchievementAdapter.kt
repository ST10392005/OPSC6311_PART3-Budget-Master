package com.example.open_sourcepart2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AchievementAdapter(
    private var achievements: List<Achievement>
) : RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_achievement, parent, false)
        return AchievementViewHolder(view)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        holder.bind(achievements[position])
    }

    override fun getItemCount(): Int = achievements.size

    fun updateAchievements(newAchievements: List<Achievement>) {
        achievements = newAchievements
        notifyDataSetChanged()
    }

    inner class AchievementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_achievement_title)
        private val tvDescription: TextView = itemView.findViewById(R.id.tv_achievement_description)
        private val ivIcon: ImageView = itemView.findViewById(R.id.iv_achievement_icon)

        fun bind(achievement: Achievement) {
            tvTitle.text = achievement.title
            tvDescription.text = achievement.description

            if (achievement.isUnlocked) {
                itemView.alpha = 1.0f
                tvTitle.setTextColor(Color.parseColor("#4CAF50"))
                ivIcon.setColorFilter(Color.parseColor("#4CAF50"))
                ivIcon.setImageResource(R.drawable.ic_achievement)
            } else {
                itemView.alpha = 0.5f
                tvTitle.setTextColor(Color.GRAY)
                ivIcon.setColorFilter(Color.GRAY)
                ivIcon.setImageResource(R.drawable.ic_achievement)
            }
        }
    }
}
