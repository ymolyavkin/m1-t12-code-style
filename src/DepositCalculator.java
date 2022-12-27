import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double annualRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + annualRate / 12), 12 * depositPeriod);
        return roundValue(pay, 2);
    }

    double сalculateSimplePercent(double amount, double annualRate, int depositPeriod) {
        return roundValue(amount + amount * annualRate * depositPeriod, 2);
    }

    double roundValue(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateAmountOnDeposit() {
        int period;
        int action;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = userInput.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = userInput.nextInt();
        double resultAmount = 0;

        if (action == 1) resultAmount = сalculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            resultAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultAmount);
    }

    public static void main(String[] args) {

        new DepositCalculator().calculateAmountOnDeposit();
    }


}
