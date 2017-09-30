package com.tsunderebug.smw.frame.event.state;

public interface BeforeLoadEvent {

    void queueForLoadFrame(Runnable r);

}
