package net.edmacdonald.javaPlayground.metaProgramming;

import net.edmacdonald.javaPlayground.metaProgramming.annotation.BusyWork;

public interface Author {

    /**
     * Sorry Authors. For the purposes of this example, writing books is busy work. Don't read too much
     * into it.
     *
     * @return
     */
    @BusyWork
    public String writeBook();
}
