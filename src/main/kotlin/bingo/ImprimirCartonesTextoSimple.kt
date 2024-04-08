package bingo

/**
 * Clase [ImprimirCartonesTextoSimple] que implementa la interfaz ImprimirCartones para imprimir los cartones de bingo
 * en formato de texto simple.
 */
class ImprimirCartonesTextoSimple : ImprimirCartones {

    /**
     * Función que imprime los cartones de bingo en formato texto simple.
     * @param cartones Lista de cartones a imprimir.
     */
    override fun imprimir(cartones: List<List<List<Int>>>) {
        cartones.forEachIndexed { index, carton ->
            println("Cartón ${index + 1}:\n")
            carton.forEach { fila ->
                fila.forEach { numero ->
                    print("$numero ")
                }
                println()
            }
            println()
        }
    }
}