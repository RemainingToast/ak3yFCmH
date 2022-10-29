package me.remainingtoast.toastclient.api.events;

import me.bush.eventbus.event.Event;

public class PlayerTickEvent extends Event {
    public static class Pre extends PlayerTickEvent {

    }

    public static class Post extends PlayerTickEvent {

    }

    protected boolean isCancellable() {
        return false;
    }
}

