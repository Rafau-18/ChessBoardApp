package rafal.example.szachownica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_new_game.view.*
val Gametempo = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 20, 25, 30)
val TimeIncrement = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20)
private  lateinit var myRef: DatabaseReference
private var ZegarIncrement =  ""
private var Zegar =  ""
private var start_flag = false
private  var WhiteName = ""
private var BlackName= ""
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firebase: FirebaseDatabase = FirebaseDatabase.getInstance()
        myRef = firebase.getReference("ClockSetting")



        new_button.setOnClickListener {
            // var nowaAktywność= Intent(applicationContext, NewGameActivity::class.java)
            // startActivity(nowaAktywność)

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_new_game, null);


            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
            val mAlertDialog = mBuilder.show()
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
            mDialogView.Start_button.setOnClickListener {
                WhiteName=mDialogView.InputWhiteName.text.toString()
                BlackName=mDialogView.InputBlackName.text.toString()

                start_flag=true;
                val firebaseInput = DatabaseClockSetup(Zegar.toInt(), ZegarIncrement.toInt(),WhiteName, BlackName, start_flag)
                myRef.setValue(firebaseInput)
                var nowaAktywność= Intent(applicationContext, ChessboardLive::class.java)
                //startActivity(nowaAktywność)

                val intent= Intent(this@MainActivity, ChessboardLive::class.java)
                intent.putExtra("white", mDialogView.InputWhiteName.text.toString())
                intent.putExtra("black", mDialogView.InputBlackName.text.toString())
                startActivity(intent)
            }

            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            // Finally, data bind the spinner object with dapter
            mDialogView.spinner_tempo.adapter = adapter;
            mDialogView.spinner12.adapter = adapter2;
            mDialogView.spinner_tempo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View,
                        position: Int,
                        id: Long)
                    {
                        // Display the selected item text on text view
                        //texttempo.text ="Spinner selected : ${parent.getItemAtPosition(position).toString()}"
                        Zegar = parent.getItemAtPosition(position).toString()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>)
                    {
                        // Another interface callback
                    }
            }
            mDialogView.spinner12.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long)
                {
                    // Display the selected item text on text view
                    //texttempo.text ="Spinner selected : ${parent.getItemAtPosition(position).toString()}"
                    ZegarIncrement = parent.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>)
                {
                }
            }
        }





            historical_button.setOnClickListener {
                var nowaAktywność = Intent(applicationContext, HistroicalActivity::class.java)
                startActivity(nowaAktywność)
            }
            settings_button.setOnClickListener {
                var nowaAktywność = Intent(applicationContext, SettingActivity::class.java)
                startActivity(nowaAktywność)
            }


        }

    }


