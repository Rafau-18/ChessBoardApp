package rafal.example.szachownica

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_chessboard_live.*
import kotlinx.android.synthetic.main.activity_new_game.view.*

import java.util.*


private  lateinit var myRef: DatabaseReference
private var licznik = 0


class ChessboardLive : AppCompatActivity() {
    private val chessViews: MutableMap<String, ImageView> = HashMap()
    private val mapa = Array(8) { arrayOfNulls<String>(8) }
    var dref: DatabaseReference? = null
    var A1: String? = null
    var A2: String? = null
    var A3: String? = null
    var A4: String? = null
    var A5: String? = null
    var A6: String? = null
    var A7: String? = null
    var A8: String? = null
    var B1: String? = null
    var B2: String? = null
    var B3: String? = null
    var B4: String? = null
    var B5: String? = null
    var B6: String? = null
    var B7: String? = null
    var B8: String? = null
    var C1: String? = null
    var C2: String? = null
    var C3: String? = null
    var C4: String? = null
    var C5: String? = null
    var C6: String? = null
    var C7: String? = null
    var C8: String? = null
    var D1: String? = null
    var D2: String? = null
    var D3: String? = null
    var D4: String? = null
    var D5: String? = null
    var D6: String? = null
    var D7: String? = null
    var D8: String? = null
    var E1: String? = null
    var E2: String? = null
    var E3: String? = null
    var E4: String? = null
    var E5: String? = null
    var E6: String? = null
    var E7: String? = null
    var E8: String? = null
    var F1: String? = null
    var F2: String? = null
    var F3: String? = null
    var F4: String? = null
    var F5: String? = null
    var F6: String? = null
    var F7: String? = null
    var F8: String? = null
    var G1: String? = null
    var G2: String? = null
    var G3: String? = null
    var G4: String? = null
    var G5: String? = null
    var G6: String? = null
    var G7: String? = null
    var G8: String? = null
    var H1: String? = null
    var H2: String? = null
    var H3: String? = null
    var H4: String? = null
    var H5: String? = null
    var H6: String? = null
    var H7: String? = null
    var H8: String? = null

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chessboard_live)
       // text.text=intent.getStringExtra("white")





        initMap(mapa)
        // val text = findViewById<TextView>(R.id.text)
        var counter = 0
        val chessboard = findViewById<LinearLayout>(R.id.linearlayout_cb)
        for (r in 0 until chessboard.childCount-2) {
            val row = chessboard.getChildAt(r) as LinearLayout
            for (c in 0 until row.childCount) {
                val iv = row.getChildAt(c) as ImageView
                chessViews[String.format("r%dc%d", r, row.childCount-1-c)] = iv
                iv.setImageResource(mapToImage(mapa[r][c]))
                counter++
            }
        }

        //updateTile(6, 7, "0")
        //updateTile(4, 7, "p")


        dref = FirebaseDatabase.getInstance().reference
        dref!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                A1 = dataSnapshot.child("ChessboardLive/00").getValue(String::class.java)
                A2 = dataSnapshot.child("ChessboardLive/10").getValue(String::class.java)
                A3 = dataSnapshot.child("ChessboardLive/20").getValue(String::class.java)
                A4 = dataSnapshot.child("ChessboardLive/30").getValue(String::class.java)
                A5 = dataSnapshot.child("ChessboardLive/40").getValue(String::class.java)
                A6 = dataSnapshot.child("ChessboardLive/50").getValue(String::class.java)
                A7 = dataSnapshot.child("ChessboardLive/60").getValue(String::class.java)
                A8 = dataSnapshot.child("ChessboardLive/70").getValue(String::class.java)
                B1 = dataSnapshot.child("ChessboardLive/01").getValue(String::class.java)
                B2 = dataSnapshot.child("ChessboardLive/11").getValue(String::class.java)
                B3 = dataSnapshot.child("ChessboardLive/21").getValue(String::class.java)
                B4 = dataSnapshot.child("ChessboardLive/31").getValue(String::class.java)
                B5 = dataSnapshot.child("ChessboardLive/41").getValue(String::class.java)
                B6 = dataSnapshot.child("ChessboardLive/51").getValue(String::class.java)
                B7 = dataSnapshot.child("ChessboardLive/61").getValue(String::class.java)
                B8 = dataSnapshot.child("ChessboardLive/71").getValue(String::class.java)
                C1 = dataSnapshot.child("ChessboardLive/02").getValue(String::class.java)
                C2 = dataSnapshot.child("ChessboardLive/12").getValue(String::class.java)
                C3 = dataSnapshot.child("ChessboardLive/22").getValue(String::class.java)
                C4 = dataSnapshot.child("ChessboardLive/32").getValue(String::class.java)
                C5 = dataSnapshot.child("ChessboardLive/42").getValue(String::class.java)
                C6 = dataSnapshot.child("ChessboardLive/52").getValue(String::class.java)
                C7 = dataSnapshot.child("ChessboardLive/62").getValue(String::class.java)
                C8 = dataSnapshot.child("ChessboardLive/72").getValue(String::class.java)
                D1 = dataSnapshot.child("ChessboardLive/03").getValue(String::class.java)
                D2 = dataSnapshot.child("ChessboardLive/13").getValue(String::class.java)
                D3 = dataSnapshot.child("ChessboardLive/23").getValue(String::class.java)
                D4 = dataSnapshot.child("ChessboardLive/33").getValue(String::class.java)
                D5 = dataSnapshot.child("ChessboardLive/43").getValue(String::class.java)
                D6 = dataSnapshot.child("ChessboardLive/53").getValue(String::class.java)
                D7 = dataSnapshot.child("ChessboardLive/63").getValue(String::class.java)
                D8 = dataSnapshot.child("ChessboardLive/73").getValue(String::class.java)
                E1 = dataSnapshot.child("ChessboardLive/04").getValue(String::class.java)
                E2 = dataSnapshot.child("ChessboardLive/14").getValue(String::class.java)
                E3 = dataSnapshot.child("ChessboardLive/24").getValue(String::class.java)
                E4 = dataSnapshot.child("ChessboardLive/34").getValue(String::class.java)
                E5 = dataSnapshot.child("ChessboardLive/44").getValue(String::class.java)
                E6 = dataSnapshot.child("ChessboardLive/54").getValue(String::class.java)
                E7 = dataSnapshot.child("ChessboardLive/64").getValue(String::class.java)
                E8 = dataSnapshot.child("ChessboardLive/74").getValue(String::class.java)
                F1 = dataSnapshot.child("ChessboardLive/05").getValue(String::class.java)
                F2 = dataSnapshot.child("ChessboardLive/15").getValue(String::class.java)
                F3 = dataSnapshot.child("ChessboardLive/25").getValue(String::class.java)
                F4 = dataSnapshot.child("ChessboardLive/35").getValue(String::class.java)
                F5 = dataSnapshot.child("ChessboardLive/45").getValue(String::class.java)
                F6 = dataSnapshot.child("ChessboardLive/55").getValue(String::class.java)
                F7 = dataSnapshot.child("ChessboardLive/65").getValue(String::class.java)
                F8 = dataSnapshot.child("ChessboardLive/75").getValue(String::class.java)
                G1 = dataSnapshot.child("ChessboardLive/06").getValue(String::class.java)
                G2 = dataSnapshot.child("ChessboardLive/16").getValue(String::class.java)
                G3 = dataSnapshot.child("ChessboardLive/26").getValue(String::class.java)
                G4 = dataSnapshot.child("ChessboardLive/36").getValue(String::class.java)
                G5 = dataSnapshot.child("ChessboardLive/46").getValue(String::class.java)
                G6 = dataSnapshot.child("ChessboardLive/56").getValue(String::class.java)
                G7 = dataSnapshot.child("ChessboardLive/66").getValue(String::class.java)
                G8 = dataSnapshot.child("ChessboardLive/76").getValue(String::class.java)
                H1 = dataSnapshot.child("ChessboardLive/07").getValue(String::class.java)
                H2 = dataSnapshot.child("ChessboardLive/17").getValue(String::class.java)
                H3 = dataSnapshot.child("ChessboardLive/27").getValue(String::class.java)
                H4 = dataSnapshot.child("ChessboardLive/37").getValue(String::class.java)
                H5 = dataSnapshot.child("ChessboardLive/47").getValue(String::class.java)
                H6 = dataSnapshot.child("ChessboardLive/57").getValue(String::class.java)
                H7 = dataSnapshot.child("ChessboardLive/67").getValue(String::class.java)
                H8 = dataSnapshot.child("ChessboardLive/77").getValue(String::class.java)
                Whitetime.text= dataSnapshot.child("Clock/White").getValue(String::class.java)
                Blacktime.text= dataSnapshot.child("Clock/Black").getValue(String::class.java)




                updateTile(0,0, A1.toString())
                updateTile(1,0, A2.toString())
                updateTile(2,0, A3.toString())
                updateTile(3,0, A4.toString())
                updateTile(4,0, A5.toString())
                updateTile(5,0, A6.toString())
                updateTile(6,0, A7.toString())
                updateTile(7,0, A8.toString())
                updateTile(0,1, B1.toString())
                updateTile(1,1, B2.toString())
                updateTile(2,1, B3.toString())
                updateTile(3,1, B4.toString())
                updateTile(4,1, B5.toString())
                updateTile(5,1, B6.toString())
                updateTile(6,1, B7.toString())
                updateTile(7,1, B8.toString())
                updateTile(0,2, C1.toString())
                updateTile(1,2, C2.toString())
                updateTile(2,2, C3.toString())
                updateTile(3,2, C4.toString())
                updateTile(4,2, C5.toString())
                updateTile(5,2, C6.toString())
                updateTile(6,2, C7.toString())
                updateTile(7,2, C8.toString())
                updateTile(0,3, D1.toString())
                updateTile(1,3, D2.toString())
                updateTile(2,3, D3.toString())
                updateTile(3,3, D4.toString())
                updateTile(4,3, D5.toString())
                updateTile(5,3, D6.toString())
                updateTile(6,3, D7.toString())
                updateTile(7,3, D8.toString())
                updateTile(0,4, E1.toString())
                updateTile(1,4, E2.toString())
                updateTile(2,4, E3.toString())
                updateTile(3,4, E4.toString())
                updateTile(4,4, E5.toString())
                updateTile(5,4, E6.toString())
                updateTile(6,4, E7.toString())
                updateTile(7,4, E8.toString())
                updateTile(0,5, F1.toString())
                updateTile(1,5, F2.toString())
                updateTile(2,5, F3.toString())
                updateTile(3,5, F4.toString())
                updateTile(4,5, F5.toString())
                updateTile(5,5, F6.toString())
                updateTile(6,5, F7.toString())
                updateTile(7,5, F8.toString())
                updateTile(0,6, G1.toString())
                updateTile(1,6, G2.toString())
                updateTile(2,6, G3.toString())
                updateTile(3,6, G4.toString())
                updateTile(4,6, G5.toString())
                updateTile(5,6, G6.toString())
                updateTile(6,6, G7.toString())
                updateTile(7,6, G8.toString())
                updateTile(0,7, H1.toString())
                updateTile(1,7, H2.toString())
                updateTile(2,7, H3.toString())
                updateTile(3,7, H4.toString())
                updateTile(4,7, H5.toString())
                updateTile(5,7, H6.toString())
                updateTile(6,7, H7.toString())
                updateTile(7,7, H8.toString())


                // updateTile1(status!!)
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        val intent = intent
        val wname = intent.getStringExtra("white")

        val bname = intent.getStringExtra("black")

        WhiteName.text=wname+" : "
        BlackName.text=bname+" : "


    }


    private fun updateTile(row: Int, column: Int, figura: String){
        mapa[row][column] = figura
        val iv = chessViews[String.format("r%dc%d", row, column)] as ImageView
        iv.setImageResource(mapToImage(mapa[row][column]))
    }
    private fun updateTile1(LastMove : String){
        val row = LastMove[0].toInt()
        val column= LastMove[1].toInt()
        mapa[row][column] = LastMove[2].toString()
        val iv = chessViews[String.format("r%dc%d", row, column)] as ImageView
        iv.setImageResource(mapToImage(mapa[row][column]))
    }

    private fun mapToImage(code: String?): Int {
        when (code) {
            "0" -> return R.drawable.empty
            "R" -> return R.drawable.rw
            "r" -> return R.drawable.rb
            "N" -> return R.drawable.nw
            "n" -> return R.drawable.nb
            "B" -> return R.drawable.bw
            "b" -> return R.drawable.bb
            "K" -> return R.drawable.kw
            "k" -> return R.drawable.kb
            "P" -> return R.drawable.pw
            "p" -> return R.drawable.pb
            "Q" -> return R.drawable.qw
            "q" -> return R.drawable.qb
        }
        return R.drawable.empty
    }

    private fun initMap(mapa: Array<Array<String?>>) {
        for (r in 0..7) {
            for (c in 0..7) {
                if (r > 1 && r < 6) {
                    mapa[r][c] = "0"
                } else if (r == 1) {
                    mapa[r][c] = "P"
                } else if (r == 6) {
                    mapa[r][c] = "p"
                } else {
                    when (c) {
                        0, 7 -> mapa[r][c] = "R"
                        1, 6 -> mapa[r][c] = "N"
                        2, 5 -> mapa[r][c] = "B"
                        3 -> mapa[r][c] = "K"
                        4 -> mapa[r][c] = "Q"
                    }
                    if (r == 7) {
                        mapa[r][c] = mapa[r][c]!!.toLowerCase()
                    }
                }
            }
        }
    }


}

