package bingo

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.choice

/**
 * Clase [ComandoPrincipal] que representa el comando principal para iniciar el juego de bingo.
 */
class ComandoPrincipal : CliktCommand() {

    /**
     * Opción para seleccionar el formato de impresión de los cartones.
     */
    private val formato by option(
        "-f", "--formato",
        help = "Choose table implementation"
    ).choice("ts", "tt")

    /**
     * Función que se ejecuta al iniciar el comando principal.
     */
    override fun run() {
        var formatoElegido = formato

        while (formatoElegido !in listOf("ts", "tt")) {
            formatoElegido = prompt(
                text = "Elije un formato (ts o tt)",
                showDefault = false,
                default = "ts",
                hideInput = false
            )
        }

        val jugar = Jugar(Consola(), formatoElegido!!)
        jugar.jugarBingo()
    }
}
