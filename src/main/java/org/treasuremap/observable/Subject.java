package org.treasuremap.observable;

import org.treasuremap.board.Position;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notify(int teamNumber, Position pos);
}
