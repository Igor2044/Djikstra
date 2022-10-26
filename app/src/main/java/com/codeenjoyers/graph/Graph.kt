package com.codeenjoyers.graph

import java.lang.StringBuilder
import java.util.*

internal class Graph<T> {
    //creating  an  object  of  the  Map  class  that  stores  the  edges  of  the  graph
    private val map: MutableMap<T, MutableList<T>> = HashMap()

    //the  method  adds  a  new  vertex  to  the  graph
    fun addNewVertex(s: T) {
        map[s] = LinkedList()
    }

    //the  method  adds  an  edge  between  source  and  destination
    fun addNewEdge(source: T, destination: T, bidirectional: Boolean) {
        //
        if (!map.containsKey(source)) addNewVertex(source)
        if (!map.containsKey(destination)) addNewVertex(destination)
        Objects.requireNonNull(map[source])?.add(destination)
        if (bidirectional) {
            Objects.requireNonNull(map[destination])?.add(source)
        }
    }

    //the  method  counts  the  number  of  vertices
    fun countVertices() {
        println("Total  number  of  vertices:  " + map.keys.size)
    }

    //the  method  counts  the  number  of  edges
    fun countEdges(bidirection: Boolean) {
        //variable  to  store  number  of  edges
        var count = 0
        for (v in map.keys) {
            count += Objects.requireNonNull<List<T>>(map[v]).size
        }
        if (bidirection) {
            count /= 2
        }
        println("Total  number  of  edges:  $count")
    }

    //checks  a  graph  has  vertex  or  not
    fun containsVertex(s: T) {
        if (map.containsKey(s)) {
            println("The  graph  contains  $s  as  a  vertex.")
        } else {
            println("The  graph  does  not  contain  $s  as  a  vertex.")
        }
    }

    //checks  a  graph  has  edge  or  not
    //where  s  and  d  are  the  two  parameters  that  represent  source(vertex)  and  destination  (vertex)
    fun containsEdge(s: T, d: T): Boolean {
        return if (Objects.requireNonNull<List<T>>(map[s]).contains(d)) {
            println("The  graph  has  an  edge  between  $s  and  $d.")
            true
        } else {
            println("There  is  no  edge  between  $s  and  $d.")
            false
        }
    }

    //prints  the  adjacencyS  list  of  each  vertex
    //here  we  have  overridden  the  toString()  method  of  the  StringBuilder  class
    override fun toString(): String {
        val builder = StringBuilder()
        //foreach  loop  that  iterates  over  the  keys
        for (v in map.keys) {
            builder.append(v.toString()).append(":  ")
            //foreach  loop  for  getting  the  vertices
            for (w in Objects.requireNonNull<List<T>>(map[v])) {
                builder.append(w.toString()).append("  ")
            }
            builder.append("\n")
        }
        return builder.toString()
    }
}