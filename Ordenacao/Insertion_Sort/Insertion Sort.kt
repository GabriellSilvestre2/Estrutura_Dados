package src.Ordenação.Insertion_Sort

fun insertion_sort(integers: Array<Int>) {
    for (i in 1 until integers.size) {
        val key = integers[i]
        var j = i - 1

        while (j >= 0 && integers[j] > key) {
            integers[j + 1] = integers[j]
            j--
        }
        integers[j + 1] = key
    }
}

fun main(){
    var integers = arrayOf(30,50,10,70,60,20,40,100,90,80)
    insertion_sort(integers)
    println(integers.joinToString())
}