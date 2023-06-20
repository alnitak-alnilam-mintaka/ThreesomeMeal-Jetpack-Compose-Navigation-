package com.polinasmogi.threesomemeal.data

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("firstIngredient")
    val firstIngredient: Ingredient = Ingredient(
        name = "",
        amount = 0,
        unit = "",
        image = ""
    ),
    @SerializedName("secondIngredient")
    val secondIngredient: Ingredient = Ingredient(
        name = "",
        amount = 0,
        unit = "",
        image = ""
    ),
    @SerializedName("thirdIngredient")
    val thirdIngredient: Ingredient = Ingredient(
        name = "",
        amount = 0,
        unit = "",
        image = ""
    ),
    @SerializedName("instructions")
    val instructions: List<String> = listOf(),
    @SerializedName("tags")
    val tags: List<String> = listOf()
)
data class Ingredient(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("amount")
    val amount: Int? = null,
    @SerializedName("unit")
    val unit: String? = null,
    @SerializedName("image")
    val image: String = ""
)

object SampleData {
    private val instructions = listOf(
        "In a medium bowl, whisk together balsamic vinegar, olive oil, brown sugar, garlic, and dried herbs, and season generously with salt and pepper. Reserve ¼ cup.",
        "Add chicken to the bowl and toss to combine. Let marinate at least 20 minutes and up to overnight.",
        "Preheat grill to medium high. Add chicken and grill, basting with reserved marinade, until cooked through, 6 minutes per side.",
        "Garnish with parsley before serving."
    )
    val potatoes = Recipe(
        id = 1,
        name = "Crispy hash browns",
        image = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/hashbrowns-f35727a.jpg",
        firstIngredient = Ingredient(
            name = "Medium-sized potatoes",
            amount = 370,
            unit = "g",
            image = "https://www.macmillandictionary.com/external/slideshow/full/141151_full.jpg"
        ),
        secondIngredient = Ingredient(
            name = "Butter, melted",
            amount = 50,
            unit = "g",
            image = "https://cdn.britannica.com/27/122027-050-EAA86783/Butter.jpg"
        ),
        thirdIngredient = Ingredient(
            name = "Sunflower oil",
            amount = 4,
            unit = "tbsp",
            image = "https://www.homestratosphere.com/wp-content/uploads/2020/12/black-oil-sunflower-seed-Dec162020-1-min.jpg"
        ),
        instructions = instructions,
        tags = listOf("vegan", "easy")
    )

    private val chips = Recipe(
        id = 2,
        name = "Cheat's real chips",
        image = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/cheats-real-chips-a5cbdb1.jpg",
        firstIngredient = Ingredient(
            name = "Maris Piper potatoes",
            amount = 450,
            unit = "g",
            image = "https://www.macmillandictionary.com/external/slideshow/full/141151_full.jpg"
        ),
        secondIngredient = Ingredient(
            name = "flaky sea salt",
            image = "https://cdn.britannica.com/27/122027-050-EAA86783/Butter.jpg"
        ),
        thirdIngredient = Ingredient(
            name = "Sunflower oil",
            amount = 300,
            unit = "ml",
            image = "https://www.homestratosphere.com/wp-content/uploads/2020/12/black-oil-sunflower-seed-Dec162020-1-min.jpg"
        ),
        instructions = instructions,
        tags = listOf("vegan", "salty")
    )

    val martini = Recipe(
        id = 3,
        name = "Earl Grey martini",
        image = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/earl-grey-martini-d966b7e.jpg",
        firstIngredient = Ingredient(
            name = "Earl Grey tea",
            amount = 1,
            unit = "tbsp",
            image = "https://www.whittard.com/on/demandware.static/-/Sites-whittard-master-catalog/default/dw3548273a/images/hi-res/314583-earl_grey_loose-1.jpg"
        ),
        secondIngredient =  Ingredient(
            name = "Gin",
            amount = 700,
            unit = "ml",
            image = "https://www.homewetbar.com/blog/wp-content/uploads/2019/09/8146-550x550.jpg"
        ),
        thirdIngredient =  Ingredient(
            name = "Ice",
            image = "https://www.clearwaycommunitysolar.com/wp-content/uploads/2019/05/iStock-177131518.jpg"
        ),
        instructions = instructions,
        tags = listOf("vegan", "beverage")
    )

    val recipesData = listOf(
        potatoes, chips, martini,
        potatoes, chips, martini,
        potatoes, chips, martini
    )
}