package com.pluralsight;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;
    private double processingFee;
    private boolean financeOption;
    private double salesTaxAmount;

    // Constructor
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption) {
        super(date, customerName, customerEmail, vehicleSold);
        this.financeOption = financeOption;
        this.processingFee = vehicleSold.getPrice() < 10000 ? 295.0 : 495.0;
        this.salesTaxAmount = vehicleSold.getPrice() * SALES_TAX_RATE;
    }
    @Override
public double getTotalPrice() {
        double totalPrice = getVehicle().getPrice() + salesTaxAmount + RECORDING_FEE + processingFee;
        return totalPrice;
}

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financeOption) {
            if (getVehicle().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }

    // Additional Getters for fields unique to SalesContract
    public boolean isFinanceOption() { return financeOption; }
}
