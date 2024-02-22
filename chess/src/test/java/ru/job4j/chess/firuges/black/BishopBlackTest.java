package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void position() {
        BishopBlack bb = new BishopBlack(Cell.F8);
        Cell resultPosition = bb.position();
        Cell expectedPosition = Cell.F8;
        assertThat(resultPosition).isEqualTo(expectedPosition);
    }

    @Test
    void copy() {
        BishopBlack bb = new BishopBlack(Cell.F8);
        bb = (BishopBlack) bb.copy(Cell.D6);
        assertThat(bb.position()).isEqualTo(Cell.D6);
    }

    @Test
    void whenWayC1toG5() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] result = bb.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).isEqualTo(expected);
    }
}