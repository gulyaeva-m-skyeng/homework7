import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        printIsLeapYear(2021);
        recommendApplicationVersion(0, 2016);
        calculateDeliveryDays(25);
    }

    public static void printIsLeapYear(int year) {
        boolean yearIsLeap = isLeap(year);
        printIsLeapYearResult(year, yearIsLeap);
    }

    private static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static void printIsLeapYearResult(int year, boolean yearIsLeap) {
        if (yearIsLeap) {
            System.out.println(year + " високосный");
        } else {
            System.out.println(year + " не является високосным");
        }
    }

    public static void recommendApplicationVersion(int clientOS, int deviceYear) {
        boolean deviceIsOld = isDeviceOld(deviceYear);
        System.out.print("Установите ");
        if (deviceIsOld) {
            System.out.print("lite ");
        }
        System.out.print("версию для ");
        if (clientOS == 0) {
            System.out.println("iOS");
        } else if (clientOS == 1) {
            System.out.println("Android");
        } else {
            throw new RuntimeException("Неизвестная система");
        }
    }

    private static boolean isDeviceOld(int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        return deviceYear <= currentYear;
    }

    public static int calculateDeliveryDays(int deliveryDistance) {
        int result = 1;
        if (deliveryDistance > 20) {
            result++;
        }
        if (deliveryDistance > 60) {
            result++;
        }
        if (deliveryDistance > 100) {
            result = -1;
        }
        return result;

        switch (deliveryDistance) {
            case 1:
            case 2:
            case 3:
                System.out.println("Количество дней для доставки составит " + deliveryDistance);
                break;
            case -1:
                System.out.println("Доставка невозможна");
                break;
        }
    }
}