package com.example.midterm_q2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerCountries: Spinner
    private lateinit var buttonGetFact: Button
    private lateinit var textviewFact: TextView

    private val countries = arrayOf("USA", "Canada", "Mexico", "UK", "France", "Germany", "Italy", "Spain")
    private val funFacts = mapOf(
        "USA" to arrayOf(
            "The shortest war in U.S. history was between the U.S. and the Hawaiian Islands. It lasted only 45 minutes.",
            "The longest word in the English language, according to the Oxford English Dictionary, is pneumonoultramicroscopicsilicovolcanoconiosis, a lung disease caused by inhaling very fine particles of silica.",
            "The largest living organism in the world is a fungus that covers over 2,200 acres in Oregon, USA.",
            "The highest point in the USA is Denali (formerly known as Mount McKinley), Alaska, which stands at 20,310 feet (6,190 meters) above sea level.",
            "The longest river in the USA is the Missouri River, which stretches for approximately 2,341 miles (3,767 kilometers) from Montana to Missouri."
        ),
        "Canada" to arrayOf(
            "Canada has more lakes than any other country in the world.",
            "The world's largest natural freshwater spring is located in Manitoba, Canada.",
            "Canada is home to the world's longest street, the Trans-Canada Highway, which spans over 4,860 miles (7,821 kilometers).",
            "The highest tides in the world can be found in the Bay of Fundy, Canada, which can rise as high as 56 feet (17 meters) in just a few hours.",
            "Canada is home to the oldest known living organism, a fungus called Armillaria ostoyae, which is estimated to be around 8,600 years old."
        ),
        "Mexico" to arrayOf(
            "Mexico is home to the world's largest pyramid, the Pyramid of Cholula, which is even larger than the Pyramid of Giza in Egypt.",
            "The oldest city in North America is Mexico City, which was founded in 1325.",
            "Mexico is home to the world's largest cave, the Cave of the Crystals, which contains some of the largest crystals ever found.",
            "The highest peak in Mexico is the Pico de Orizaba, a dormant volcano that stands at 18,491 feet (5,636 meters) above sea level.",
            "Mexico is home to the world's largest salt flat, the Salar de Uyuni, which covers over 4,000 square miles (10,360 square kilometers)."
        ),
        "UK" to arrayOf(
            "The UK is home to the world's oldest known tree, the Fortingall Yew, which is estimated to be between 2,000 and 3,000 years old.",
            "The longest place name in the UK is Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch, a village in Wales.",
            "The highest mountain in the UK is Ben Nevis, Scotland, which stands at 4,411 feet (1,345 meters) above sea level.",
            "The UK is home to the world's largest library, the British Library, which contains over 150 million items.",
            "The oldest known human settlement in the UK is the village of Skara Brae, Scotland, which dates back to around 3100 BC."
        ),
        "France" to arrayOf(
            "France is home to the world's most visited art museum, the Louvre, which attracts over 10 million visitors per year.",
            "The highest mountain in France is Mont Blanc, which stands at 15,781 feet (4,810 meters) above sea level.",
            "France is home to the world's oldest known wine, the Richebourg, which dates back to the 12th century.",
            "The longest river in France is the Loire, which stretches for approximately 620 miles (1,000 kilometers).",
            "France is home to the world's largest castle, the Château de Chambord, which has over 440 rooms."
        ),
        "Germany" to arrayOf(
            "Germany is home to the world's oldest known brewery, the Weihenstephaner Brewery, which was founded in 1046.",
            "The highest mountain in Germany is the Zugspitze, which stands at 9,718 feet (2,962 meters) above sea level.",
            "Germany is home to the world's largest cathedral, the Cologne Cathedral, which is over 515 feet (157 meters) tall.",
            "The longest river in Germany is the Rhine, which stretches for approximately 764 miles (1,230 kilometers).",
            "Germany is home to the world's largest Christmas market, the Nuremberg Christmas Market, which attracts over 2 million visitors per year."
        ),
        "Italy" to arrayOf(
            "Italy is home to the world's largest amphitheater, the Colosseum, which was built in 80 AD.",
            "The highest mountain in Italy is Mount Etna, which stands at 10,922 feet (3,329 meters) above sea level.",
            "Italy is home to the world's largest pizza, which was made in Rome in 2012 and measured over 1,260 square feet (117 square meters).",
            "The longest river in Italy is the Po, which stretches for approximately 405 miles (652 kilometers).",
            "Italy is home to the world's largest church, the Basilica of Saint Peter, which covers over 15,000 square meters (161,000 square feet)."
        ),
        "Spain" to arrayOf(
            "Spain is home to the world's largest cathedral, the Seville Cathedral, which covers over 11,500 square meters (123,785 square feet).",
            "The highest mountain in Spain is Teide, which stands at 12,198 feet (3,718 meters) above sea level.",
            "Spain is home to the world's largest bullring, the Plaza de Toros de Las Ventas, which has a capacity of over 23,000 spectators.",
            "The longest river in Spain is the Tagus, which stretches for approximately 626 miles (1,007 kilometers).",
            "Spain is home to the world's largest desert, the Tabernas Desert, which covers over 280 square miles (725 square kilometers)."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerCountries = findViewById(R.id.spinner_countries)
        buttonGetFact = findViewById(R.id.button_get_fact)
        textviewFact = findViewById(R.id.textview_fact)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountries.adapter = adapter

        spinnerCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedCountry = countries[position]
                buttonGetFact.isEnabled = true
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                buttonGetFact.isEnabled = false
            }
        }

        buttonGetFact.setOnClickListener {
            val selectedCountry = spinnerCountries.selectedItem as String
            val funFactsArray = funFacts[selectedCountry]!!
            val randomFact = funFactsArray.random()
            textviewFact.text = randomFact
        }
    }
}