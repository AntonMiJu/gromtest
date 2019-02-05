package gromcode.main.lesson10.homework;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if ((getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков") && (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков") && (getBasePrice() >= 100) && (getCustomerOwned().getGender() == "Женский")) {
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        if (getDateConfirmed() == null || getDateShipped() == null)
            return;
        if (getShipToCity() == "Киев" || getShipToCity() == "Одесса") {
            setTotalPrice(getBasePrice() + (getBasePrice() * 0.1));
        } else {
            setTotalPrice(getBasePrice() + (getBasePrice() * 0.15));
        }
        if (getTotalPrice() >= 1000)
            setTotalPrice(getTotalPrice() - getTotalPrice() * 0.05);
    }
}
