package bingo

/**
 * Interfaz [ImprimirCartones] para imprimir cartones de bingo en diferentes formatos.
 */
interface ImprimirCartones {

    /**
     * Función para imprimir los cartones en el formato especificado.
     * @param cartones Lista de cartones a imprimir.
     */
    fun imprimir(cartones: List<List<List<Int>>>)
}