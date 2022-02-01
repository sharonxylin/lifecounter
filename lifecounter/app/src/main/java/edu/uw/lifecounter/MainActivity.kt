package edu.uw.lifecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class Player(val name: String){
    var life: Int = 20
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val players = arrayOf(
            Player("Player 1"),
            Player("Player 2"),
            Player("Player 3"),
            Player("Player 4"))

        var player0name = findViewById<TextView>(R.id.p0name)
        var player1name = findViewById<TextView>(R.id.p1name)
        var player2name = findViewById<TextView>(R.id.p2name)
        var player3name = findViewById<TextView>(R.id.p3name)
        var player0life = findViewById<TextView>(R.id.p0life)
        var player1life = findViewById<TextView>(R.id.p1life)
        var player2life = findViewById<TextView>(R.id.p2life)
        var player3life = findViewById<TextView>(R.id.p3life)
        var lose = findViewById<TextView>(R.id.loseMessage)

        player0name.text=players[0].name
        player1name.text=players[1].name
        player2name.text=players[2].name
        player3name.text=players[3].name
        player0life.text="Life Total: ${players[0].life}"
        player1life.text="Life Total: ${players[1].life}"
        player2life.text="Life Total: ${players[2].life}"
        player3life.text="Life Total: ${players[3].life}"

        fun btnListener(change: Int, player: Player, playerLife: TextView){
            player.life += change
            if(player.life>999){
                player.life=999
            }else if(player.life<=0){
                player.life=0
                lose.text="${player.name} LOSES!"
            }
            playerLife.text="Life Total: ${player.life}"
        }

        //add one listeners
        findViewById<Button>(R.id.p0addOne).setOnClickListener {btnListener(1, players[0], player0life)}
        findViewById<Button>(R.id.p1addOne).setOnClickListener {btnListener(1, players[1], player1life)}
        findViewById<Button>(R.id.p2addOne).setOnClickListener {btnListener(1, players[2], player2life)}
        findViewById<Button>(R.id.p3addOne).setOnClickListener {btnListener(1, players[3], player3life)}
        //add five listeners
        findViewById<Button>(R.id.p0addFive).setOnClickListener {btnListener(5, players[0], player0life)}
        findViewById<Button>(R.id.p1addFive).setOnClickListener {btnListener(5, players[1], player1life)}
        findViewById<Button>(R.id.p2addFive).setOnClickListener {btnListener(5, players[2], player2life)}
        findViewById<Button>(R.id.p3addFive).setOnClickListener {btnListener(5, players[3], player3life)}
        //minus one listeners
        findViewById<Button>(R.id.p0minusOne).setOnClickListener {btnListener(-1, players[0], player0life)}
        findViewById<Button>(R.id.p1minusOne).setOnClickListener {btnListener(-1, players[1], player1life)}
        findViewById<Button>(R.id.p2minusOne).setOnClickListener {btnListener(-1, players[2], player2life)}
        findViewById<Button>(R.id.p3minusOne).setOnClickListener {btnListener(-1, players[3], player3life)}
        //minus five listeners
        findViewById<Button>(R.id.p0minusFive).setOnClickListener {btnListener(-5, players[0], player0life)}
        findViewById<Button>(R.id.p1minusFive).setOnClickListener {btnListener(-5, players[1], player1life)}
        findViewById<Button>(R.id.p2minusFive).setOnClickListener {btnListener(-5, players[2], player2life)}
        findViewById<Button>(R.id.p3minusFive).setOnClickListener {btnListener(-5, players[3], player3life)}
    }



}