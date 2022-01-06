package com.example.fitrm.data

import com.example.fitrm.R
import com.example.fitrm.model.Product

object DataSource {

    val products1 = listOf(
        Product("Whey Gold Standard", "порошок, сывороточный изолят, сывороточный концентрат", R.drawable.protein1,2000),
        Product("Fuze Protein", "порошок, многокомпонентный", R.drawable.protein2,1500),
        Product("Pure Protein", "порошок, многокомпонентный", R.drawable.protein3,2200))

    val products2 = listOf(
        Product("Optimum Nutrition Micronised Creatine", "микронизированный креатин с уникальной структурой", R.drawable.creatine1,1500),
        Product("Creatin Simple", "содержит чистый моногидрат креатина", R.drawable.creatine2,1300),
        Product("Creatin Maxler", "микронизированный креатин 1кг", R.drawable.creatine3,1000))

    val products3 = listOf(
        Product("Glutamine Maxler", "аминокислота L-Глутамин,способная ускорять метаболические процессы в мышцах ", R.drawable.glutamine1,1100),
        Product("Now-L Glutamine", "без аспартама, без глютена", R.drawable.glutamine2,1200),
        Product("Optimum Nutrition Glutamine", "cпортивная добавка, созданная на основе глютамина", R.drawable.glutamine3,1700))
}