package com.codeenjoyers.graph

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val graph = Graph()

        findViewById<FloatingActionButton>(R.id.addBtn).setOnClickListener {
            graph.addNewEdge(findViewById<EditText>(R.id.iSeekbar).text.toString().toInt(), findViewById<EditText>(R.id.jSeekbar).text.toString().toInt())
        }
        findViewById<FloatingActionButton>(R.id.runBtn).setOnClickListener {
            if (!findViewById<CheckBox>(R.id.isdj).isChecked) {
                if (graph.containsEdge(
                        findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toInt(),
                        findViewById<EditText>(R.id.editTextNumberDecimal1).text.toString().toInt()
                    )
                )
                    Snackbar.make(
                        findViewById<ConstraintLayout>(R.id.viewLayout), "Connection found",
                        Snackbar.LENGTH_LONG
                    ).setAction("Action", null).setBackgroundTint(Color.GREEN).show()
                else
                    Snackbar.make(
                        findViewById<ConstraintLayout>(R.id.viewLayout),
                        "Unable to find connection",
                        Snackbar.LENGTH_LONG
                    ).setAction("Action", null).setBackgroundTint(Color.RED).show()
                return@setOnClickListener
            }
            Log.wtf("DZIALA?",graph.findP(
                findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toInt(),
                findViewById<EditText>(R.id.editTextNumberDecimal1).text.toString().toInt()
            ))
        }
    }
}