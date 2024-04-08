package bingo

/**
 * Clase [Bingo] que representa el juego de bingo.
 *
 * @property filas Número de filas en el cartón de bingo.
 * @property columnas Número de columnas en el cartón de bingo.
 * @property numerosCarton Número total de números en el cartón de bingo.
 * @property rangoNumeros Rango de números posibles para el juego de bingo.
 */
class Bingo {

    private val filas = 3
    private val columnas = 5
    private val numerosCarton = filas * columnas
    private val rangoNumeros = (1..90).toList()

    /**
     * Función que genera uno o varios cartones de bingo.
     *
     * @param cantidad Cantidad de cartones a generar.
     * @return Lista de cartones generados.
     */
    fun generarCarton(cantidad: Int): List<List<List<Int>>> {
        val cartones = mutableListOf<List<List<Int>>>()
        val numerosDisponibles = rangoNumeros.toMutableList()

        repeat(cantidad) {
            val numerosCarton = numerosDisponibles.shuffled().take(numerosCarton)
            numerosDisponibles -= numerosCarton
            val carton = numerosCarton.chunked(columnas)
            cartones.add(carton)
        }
        return cartones
    }

    /**
     * Función que genera un número aleatorio para el bingo.
     *
     * @param numerosGenerados Lista de números generados anteriormente.
     * @return Número generado.
     */
    fun generarNumero(numerosGenerados: MutableList<Int>): Int {
        val numero = (rangoNumeros - numerosGenerados).random()
        numerosGenerados.add(numero)
        return numero
    }

    /**
     * Función que verifica si hay bingo en un cartón.
     *
     * @param carton Cartón a verificar.
     * @param numerosGenerados Conjunto de números generados durante el juego.
     * @return `true` si hay bingo, `false` en caso contrario.
     */
    fun verificarBingo(carton: List<List<Int>>, numerosGenerados: Set<Int>): Boolean {
        return carton.all { fila -> fila.all { it in numerosGenerados } }
    }

    /**
     * Función que verifica si hay línea en un cartón.
     *
     * @param carton Cartón a verificar.
     * @param numerosGenerados Conjunto de números generados durante el juego.
     * @return `true` si hay línea, `false` en caso contrario.
     */
    fun verificarLinea(carton: List<List<Int>>, numerosGenerados: Set<Int>): Boolean {
        return carton.any { fila -> fila.all { it in numerosGenerados } }
    }

}
