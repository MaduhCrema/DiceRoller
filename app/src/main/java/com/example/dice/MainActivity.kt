 package com.example.dice
//import das bibliotecas
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)/**achar conteudo por ID, no caso o botão, salvando a referência
        de butoom, não o próprio buttom.
        Defininco o que ocorre com o botão, <nomeVariável>.setOnClickListener, {}-chamada por lambda**/
        rollButton.setOnClickListener {
            /**toast- breve mensagem ao usuário            mensagem curta que desaparece
            val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
            mensagem que aparecerá quando o botão "JOGAR" for clicado, mudando o textview
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"//.text definindo que é texto **/
            rollDice()
        }

        //inicia o app com o dado ja aparecendo
        rollDice()

    }
    private fun rollDice() {
        val dice = Dice(6)//numero de lados
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        //diceImage.setImageResource(R.drawable.dice_2)//método para mudao o ImageView
        when(diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        /** OU pdoe escrever assim, para simplificar, o when pode ser acompanhado com a variavel
         *  // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
        }
         **/
        diceImage.contentDescription = diceRoll.toString()
        /**val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()//convertendo o numero para string**/
    }
}
    //classe do dado
    class Dice(private val numSides: Int){
        fun roll(): Int {
            return (1..numSides).random()
        }
    }