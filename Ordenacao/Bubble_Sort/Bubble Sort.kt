package src.Ordenação.Bubble_Sort

import src.Ordenação.Selection_Sort.selection_sort

fun bubble_sort(integers: Array<Int>) {
    for (i in 0 until integers.size-1){
        for (j in 0 until integers.size-i-1){
            if (integers[j] > integers[j+1]){
                var aux = integers[j]
                integers[j] = integers[j+1]
                integers[j+1] = aux
            }
        }
    }
}
fun main(){
    var integers: Array<Int> = arrayOf(10,1,2,3,9,8,7,4,5,6)
    bubble_sort(integers)
    println(integers.joinToString())
}