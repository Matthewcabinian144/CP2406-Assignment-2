package Test;

import Model.Road;

public class CarTest {
    Model.Road road = new Model.Road("0", 1, 5, new int[]{0, 0}, Road.Orientation.VERTICAL);
    Model.Car car = new Model.Car("0", road);

}
