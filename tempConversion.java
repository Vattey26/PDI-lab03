import java.util.Scanner;

class City{
    String name;
    double tempInCelsius;
    double tempInFahrenheit;
    City(String name, double tempInCelsius) {
        this.name = name;
        this.tempInCelsius = tempInCelsius;
    }

    void display() {
        tempInFahrenheit = (tempInCelsius * 9/5) + 32;
        System.out.printf("%-15s    %-5.2f         %-6.2f\n", name, tempInCelsius, tempInFahrenheit);
    }
}

class Country{
    City cities[];
    int index = 0;
    Country(int size) {
        cities = new City[size];
    }

    void addCity(City city) {
        cities[index] = city;
        index++;
    }

    void findLowestTemp() {
        double min = cities[0].tempInCelsius;
        for(int i = 1; i < index; i++) {
            if(cities[i].tempInCelsius < min) {
                min = cities[i].tempInCelsius;
            }
        }
        System.out.println("\nThe city with the lowest temparature: ");
        System.out.println("City           Celsius      Fahrenheit");
        System.out.println("----------------------------------------");
        for(int i = 0; i < index; i++) {
            if(cities[i].tempInCelsius == min) {
                cities[i].display();
            }
        }
        System.out.println();
    }

    void findHighestTemp() {
        Double max = cities[0].tempInCelsius;
        for(int i = 1; i < index; i++) {
            if (cities[i].tempInCelsius > max) {
                max = cities[i].tempInCelsius;
            }
        }
        System.out.println("\nThe city with the highest temparature: ");
        System.out.println("City           Celsius      Fahrenheit");
        System.out.println("----------------------------------------");
        for(int i = 0; i < index; i++) {
            if(cities[i].tempInCelsius == max) {
                cities[i].display();
            }
        }
        System.out.println();
    }

    void findAvgTemp() {
        double sum = 0;
        for(int i = 0; i < index; i++) {
            sum += cities[i].tempInCelsius;
        }
        System.out.println("\nThe average temparature in Celsius: " + (sum / index));
    }

    void displayAllCites() {
        System.out.println("City           Celsius      Fahrenheit");
        System.out.println("----------------------------------------");
        for(int i = 0; i < index; i++) {
            cities[i].display();
        }
        System.out.println();
    }

}

public class tempConversion {
    public static void main(String[] args) {
        Scanner accept = new Scanner(System.in);
        System.out.print("Input number of city: ");
        int n = accept.nextInt();
        Country country = new Country(n);
        for(int i = 1; i <= n; i++) {
            accept.nextLine();
            System.out.println();
            System.out.print("City name: ");
            String name = accept.nextLine();
            System.out.print("Temparature: ");
            double temp = accept.nextDouble();
            City city = new City(name, temp);
            country.addCity(city);
        }
        accept.close();
        country.displayAllCites();
        country.findHighestTemp();
        country.findLowestTemp();
        country.findAvgTemp();
    }
    
}
