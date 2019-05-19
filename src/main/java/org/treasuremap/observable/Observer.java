package org.treasuremap.observable;

import org.treasuremap.board.Position;

public interface Observer {
    void update(int teamNumber, Position pos);
}
