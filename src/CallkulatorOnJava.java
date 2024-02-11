import java.util.Scanner;

public class CallkulatorOnJava {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String LINE_SEPARATOR = "________";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(LINE_SEPARATOR);
        System.out.println(ANSI_RED + "Вообщем, данная программа представляет собой что-то на подобие калькулятора, который будет выводить нам координаты." + ANSI_RESET);
        System.out.println("Введи информацию(координаты) для двух точек, чтобы узнать растояние между ними.");
        System.out.println(LINE_SEPARATOR);
        double lat1 = readCoordinate("широта первой точки");
        double lon1 = readCoordinate("долгота первой точки");
        double lat2 = readCoordinate("широта второй точки");
        double lon2 = readCoordinate("долгота второй точки");
        double distance = calculateDistance(lat1, lon1, lat2, lon2);

        System.out.println(LINE_SEPARATOR);
        System.out.println("Расстояние между двумя точками: " + ANSI_RED + distance + " км" + ANSI_RESET);
        suggestTransport(distance);
        System.out.println(LINE_SEPARATOR);
    }
    private static double readCoordinate(String coordinateType) {
        System.out.print("Введите " + coordinateType + " (в градусах): ");
        return Double.parseDouble(new Scanner(System.in).nextLine());
    }
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371.0;
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);
        double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
    private static void suggestTransport(double distance) {
        System.out.println("\n|Добавлен функционал для выбора транспорта.|");
        System.out.println("Примерный транспорт, который можно будет использовать: (Beta, ибо поспорить можно.):");
        if (distance < 100) {
            System.out.println("Пешком, на метро, " + ANSI_RED + "такси" + ANSI_RESET + " или на велосипеде.");
        } else if (distance < 500) {
            System.out.println("Личный автомобиль или какие-то местные варианты (второй вариант не рекомендую, но кто Вас знает.).");
        } else if (distance < 2000) {
            System.out.println("Поезд или, возможно, " + ANSI_RED + "личный самолет" + ANSI_RESET + " (второй вариант, конечно, для богатых xD).");
        } else {
            System.out.println("В данном случае лучше использовать " + ANSI_RED + "самолеты" + ANSI_RESET + ".. (или может быть - карабли).");
        }
    }
}