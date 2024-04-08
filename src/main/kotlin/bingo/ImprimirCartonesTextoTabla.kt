package bingo

import com.github.ajalt.mordant.table.table as mordantTable
import com.github.ajalt.mordant.terminal.Terminal

/**
 * Clase [ImprimirCartonesTextoTabla] que implementa la interfaz ImprimirCartones para imprimir los cartones de bingo
 * en formato de tabla utilizando la biblioteca Mordant.
 */
class ImprimirCartonesTextoTabla : ImprimirCartones {

    /**
     * Función que imprime los cartones de bingo en formato de tabla utilizando la biblioteca Mordant.
     * @param cartones Lista de cartones a imprimir.
     */
    override fun imprimir(cartones: List<List<List<Int>>>) {
        val terminal = Terminal()
        cartones.forEachIndexed { index, carton ->
            terminal.println("Cartón ${index + 1}:")
            val table = mordantTable {
                body {
                    carton.forEach { fila ->
                        row(*fila.map { it.toString() }.toTypedArray())
                    }
                }
            }
            terminal.println(table.render(terminal))
            terminal.println()
        }
    }
}