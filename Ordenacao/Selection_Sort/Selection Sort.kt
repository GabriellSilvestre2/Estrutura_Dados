package src.Ordenação.Selection_Sort

fun selection_sort(data: Array<Int>) {
    var sizeArray = data.size
    for (i in 0 until sizeArray-1){
        var minIndex = i
        for (j in i+1 until sizeArray){
            if (data[j] < data[minIndex])
                minIndex = j
        }
        if (minIndex != i){
            var aux = data[i]
            data[i] = data[minIndex]
            data[minIndex] = aux
        }
    }
}

fun main() {
    val dados = arrayOf(8, 5, 7, 1, 9, 2, 3, 4, 6)
    selection_sort(dados)
    println(dados.joinToString())
}
