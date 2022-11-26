package ar.edu.unlam.tallerapp

import ar.edu.unlam.tallerapp.data.CharactersService
import ar.edu.unlam.tallerapp.model.Characters
import kotlin.test.Test
import kotlin.test.assertEquals

internal class CharacterTest{
    @Test
    fun WhenApplyTheSorMethodToListItReturnsAnOrderedList(){
        val charactersService = CharactersService()
        val listaEsperada = listOf(
            Characters(1,"SpiderMan","SpiderMan","SpiderMan"),
            Characters(2,"Batman","Batman","Batman"),
            Characters(3,"DeadPool","DeadPool","DeadPool"),
            Characters(5,"SuperMan","SuperMan","SuperMan"),
            Characters(4,"Wonder","","oijoihjo"),
        )
        val listaAOrdenar = listOf(
            Characters(4,"Wonder","Wonder","Wonder"),
            Characters(5,"SuperMan","SuperMan","SuperMan"),
            Characters(3,"DeadPool","DeadPool","DeadPool"),
            Characters(2,"Batman","Batman","Batman"),
            Characters(1,"SpiderMan","SpiderMan","SpiderMan"),
        )

        val listaOrdenada  = charactersService.sort(listaAOrdenar)

        assertEquals(listaEsperada[0] , listaOrdenada[0])
        assertEquals(listaEsperada[1] , listaOrdenada[1])
        assertEquals(listaEsperada[2] , listaOrdenada[2])
        assertEquals(listaEsperada[3] , listaOrdenada[3])
        assertEquals(listaEsperada[4] , listaOrdenada[4])
        assertEquals(listaEsperada[5] , listaOrdenada[5])
        assertEquals(listaEsperada[6] , listaOrdenada[6])

    }
}

