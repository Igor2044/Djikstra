package com.codeenjoyers.graph

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val graph = Graph<Int>()

        findViewById<FloatingActionButton>(R.id.addBtn).setOnClickListener {
            graph.addNewEdge(findViewById<EditText>(R.id.iSeekbar).text.toString().toInt(), findViewById<EditText>(R.id.jSeekbar).text.toString().toInt(), true)
        }
        findViewById<FloatingActionButton>(R.id.runBtn).setOnClickListener {
            if (graph.containsEdge(findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toInt(),findViewById<EditText>(R.id.editTextNumberDecimal1).text.toString().toInt()))
                Snackbar.make(findViewById<ConstraintLayout>(R.id.viewLayout), "Znaleziono połączenie",
                    Snackbar.LENGTH_LONG).setAction("Action", null).setBackgroundTint(Color.GREEN).show()
            else
                Snackbar.make(findViewById<ConstraintLayout>(R.id.viewLayout), "Nie znaleziono połączenia",
                    Snackbar.LENGTH_LONG).setAction("Action", null).setBackgroundTint(Color.RED).show()
        }
    }
}