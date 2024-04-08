package bingo

/**
 * Clase [Consola] que representa la consola del juego de bingo.
 */
class Consola {

    /**
     * Función para imprimir un mensaje en la consola.
     * @param mensaje Mensaje a imprimir.
     */
    fun imprimirMensaje(mensaje: String) {
        println(mensaje)
    }

    /**
     * Función para imprimir los cartones en la consola.
     * @param cartones Lista de cartones a imprimir.
     * @param formato Formato de impresión de los cartones ("ts" para texto simple, "tt" para tabla).
     * @throws IllegalArgumentException Si el formato de impresión no es válido.
     */
    fun imprimirCartones(cartones: List<List<List<Int>>>, formato: String) {
        val impresor = when (formato) {
            "ts" -> ImprimirCartonesTextoSimple()
            "tt" -> ImprimirCartonesTextoTabla()
            else -> throw IllegalArgumentException("Formato de impresión no válido")
        }
        impresor.imprimir(cartones)
    }

    /**
     * Función para verificar si hay línea en algún cartón.
     * @param cartones Lista de cartones a verificar.
     * @param numerosGenerados Conjunto de números generados en el juego.
     * @return true si hay línea en algún cartón, false en caso contrario.
     */
    fun verificarLinea(cartones: List<List<List<Int>>>, numerosGenerados: Set<Int>): Boolean {
        return cartones.any { Bingo().verificarLinea(it, numerosGenerados) }
    }
}