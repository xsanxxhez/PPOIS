package org.example;

class Showroom {
    private Garage garage;
    private SalesEmployee employee;

    public Showroom(Garage garage, SalesEmployee employee) {
        this.garage = garage;
        this.employee = employee;
    }

    public void showVehicles() {
        System.out.println("Showroom managed by " + employee.getName());
    }

    // Геттеры и сеттеры
    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public SalesEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(SalesEmployee employee) {
        this.employee = employee;
    }
}
