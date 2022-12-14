package com.example.demo;

public interface Transportierbar {

    public abstract float gewicht();

    public abstract boolean zerbrechlich();

    public abstract void wrap(Transportierbar item);

    public abstract Transportierbar[] getItems();

    public abstract BubbleWrap wrap();

    public abstract SecureBox secureBox();

    // include countAdequateItems() in the interface
    public abstract int countAdequateItems();

}

