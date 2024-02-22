package ru.job4j.chess;

import javafx.scene.Group;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenCellOccupied()
        throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
            Logic logic = new Logic();
            BishopBlack bb1 = new BishopBlack(Cell.C1);
            BishopBlack bb2 = new BishopBlack(Cell.D2);
            logic.add(bb1);
            logic.add(bb2);
            OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
                logic.move(Cell.C1, Cell.D2);
            });
            assertThat(exception.getMessage()).isEqualTo(null);
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bb1 = new BishopBlack(Cell.C1);
        logic.add(bb1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.C1, Cell.D3);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to D3");
    }

}
