package ua.nure.zabara.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlAttribute;

public class Weapon {

    private int handy;
    private String origin;
    private Visuality visuality;
    boolean valueAble;


    public int getHandy() {
        return handy;
    }

    public void setHandy(int handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Visuality getVisuality() {
        return visuality;
    }

    public void setVisuality(Visuality visuality) {
        this.visuality = visuality;
    }

    public boolean isValueAble() {
        return valueAble;
    }

    public void setValueAble(boolean valueAble) {
        this.valueAble = valueAble;
    }

}






/*
2. Холодное оружие.
        Холодное оружие можно структурировать по следующей схеме:
        Type - тип (нож, кинжал, сабля и т.д.).
        Handy - одно или двуручное.
        Origin - страна производства.
        Visual (должно быть несколько) - визуальные характеристики: клинок (длина клинка [10 - n см], ширина клинка [10 - n мм]), материал (клинок [сталь, чугун, медь и т.д.]), рукоять (деревянная [если да, то указать тип дерева], пластик, металл), наличие кровостока (есть либо нет).
        Value - коллекционный либо нет.
        Элемент назвать Knife.*/