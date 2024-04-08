package bingo

/**
 * Clase [Jugar] que maneja la lógica principal del juego de bingo.
 * @param consola Instancia de Consola utilizada para la interacción con el usuario.
 * @param formato El formato en el que se imprimirán los cartones ('ts' para texto simple, 'tt' para tabla).
 */
class Jugar(private val consola: Consola, private val formato: String) {

    private val bingo = Bingo()

    /**
     * Función [jugarBingo] principal que inicia el juego de bingo.
     */
    fun jugarBingo() {
        var cartones = bingo.generarCarton(3)
        consola.imprimirCartones(cartones, formato)

        val numerosGenerados = mutableListOf<Int>()
        val cartonesConLinea = mutableListOf<Int>()
        val cartonesConBingo = mutableListOf<Int>()
        var bingoCompleto = false

        while (!bingoCompleto) {
            val numeroGenerado = bingo.generarNumero(numerosGenerados)
            numerosGenerados.add(numeroGenerado)
            consola.imprimirMensaje("Número generado: $numeroGenerado")

            cartones = actualizarCartones(cartones, numeroGenerado)

            if (consola.verificarLinea(cartones, numerosGenerados.toSet())) {
                consola.imprimirMensaje("¡LÍNEA!")
                cartonesConLinea.add(1)
            }

            val cartonConBingo = cartones.indexOfFirst { bingo.verificarBingo(it, numerosGenerados.toSet()) }
            if (cartonConBingo != -1 && !cartonesConBingo.contains(cartonConBingo)) {
                cartonesConBingo.add(cartonConBingo)
                consola.imprimirMensaje("¡BINGO en el cartón ${cartonConBingo + 1}!")
            }

            bingoCompleto = cartones.any { carton -> carton.flatten().all { it == 0 } }
            consola.imprimirCartones(cartones, formato)
        }

        consola.imprimirMensaje("¡BINGO en uno de los cartones!")
        consola.imprimirMensaje("Números generados: $numerosGenerados")
    }

    /**
     * Función que actualiza los cartones después de generar un número y verificar si coincide con algún número del cartón.
     * @param cartones Lista de cartones.
     * @param numeroGenerado Número generado en el juego.
     * @return Lista de cartones actualizada.
     */
    private fun actualizarCartones(cartones: List<List<List<Int>>>, numeroGenerado: Int): List<List<List<Int>>> {
        return cartones.map { carton ->
            carton.map { fila ->
                fila.map { if (it == numeroGenerado)
                    0
                else
                    it
                }
            }
        }
    }
}
