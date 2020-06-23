package rafal.example.szachownica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.view.View
import kotlinx.android.synthetic.main.activity_new_game.*

class NewGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        val Gametempo = arrayOf(1,2, 3,4, 5,6, 7,8,9,10,12,15,20,25,30)
        val TimeIncrement = arrayOf(1,2, 3,4, 5,6, 7,8,9,10,15,20)
        val adapter = ArrayAdapter(
            this, // Context
            android.R.layout.simple_spinner_item, // Layout
            Gametempo// Array
        )
        val adapter2 = ArrayAdapter(
            this, // Context
            android.R.layout.simple_spinner_item, // Layout
            TimeIncrement// Array
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        // Finally, data bind the spinner object with dapter
        spinner_tempo.adapter = adapter;
        spinner12.adapter= adapter2

        spinner_tempo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // Display the selected item text on text view
                //texttempo.text ="Spinner selected : ${parent.getItemAtPosition(position).toString()}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
    }
}
