import java.io.*;
import java.util.*;

class Person {
    private String name;
    private int age;
    private char gender;
    private double height;
    private double weight;
    private double systolic;
    private double diastolic;
    private HealthData health;

    public Person(String name, int age, char gender, double height, double weight, double systolic, double diastolic) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.systolic = systolic;
        this.diastolic = diastolic;
        health = new HealthData(height, weight, systolic, diastolic);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public HealthData getHealthData() {
        return health;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getSystolic() {
        return systolic;
    }

    public double getDiastolic() {
        return diastolic;
    }
}

class HealthData {
    private double BMI;
    private String BloodPresure;

    public HealthData(double height, double weight, double systolic, double diastolic) {
        BMI = calculateBMI(height, weight);
        BloodPresure = determineBloodPressure(systolic, diastolic);
    }

    public double calculateBMI(double height, double weight) {
        return weight / Math.pow((height / 100), 2);
    }

    public String BMIStatus(double BMI) {
        String status = "";

        if (BMI <= 18.4) {
            status = "Underweight";
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            status = "Normal";
        } else if (BMI >= 25 && BMI <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        return status;
    }

    public String determineBloodPressure(double systolic, double diastolic) {
        String BloodPressureStatus = " ";
        if (systolic < 120 && diastolic < 80) {
            BloodPressureStatus = "Normal";
        } else if ((systolic >= 120 && systolic <= 129) && diastolic < 80) {
            BloodPressureStatus = "Elavated";
        } else if ((systolic >= 130 && systolic <= 139) || (diastolic >= 80 && diastolic <= 89)) {
            BloodPressureStatus = "Hypertension Stage 1";
        } else if ((systolic >= 140 && systolic <= 180) || (diastolic >= 90 && diastolic <= 120)) {
            BloodPressureStatus = "Hypertension Stage 2";
        } else if (systolic > 180 || diastolic > 120) {
            BloodPressureStatus = "Hypertension Crisis";
        }
        return BloodPressureStatus;
    }

    public double getBMI() {
        return BMI;
    }

    public String getBloodPressure() {
        return BloodPresure;
    }
}

class Ingredients {
    private String name;
    private double calories, carbohydrates, fats;

    public Ingredients(String name, double calroies, double carbohydrates, double fats) {
        this.name = name;
        this.calories = calroies;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public void getIngredientDetails(PrintWriter output) {
        System.out.println("Ingredient: " + getName());
        System.out.println("[Nutrients per 100g]");
        System.out.println("Calories: " + getCalories() + "kcal");
        System.out.println("Carbohydrates: " + getCarbohydrates() + "g");
        System.out.println("Fats: " + getFats() + "g");
        System.out.println();

        output.println("Ingredient: " + getName());
        output.println("[Nutrients per 100g]");
        output.println("Calories: " + getCalories() + "kcal");
        output.println("Carbohydrates: " + getCarbohydrates() + "g");
        output.println("Fats: " + getFats() + "g");
        output.println();
    }
}

class Meat extends Ingredients {
    private double protein;

    public Meat(String name, double calroies, double carbohydrates, double fats, double protein) {
        super(name, calroies, carbohydrates, fats);
        this.protein = protein;
    }

    public double getProtein() {
        return protein;
    }

    public void getIngredientDetails(PrintWriter output) {
        System.out.println("- Meat: " + super.getName());
        System.out.println("[Nutrients per 100g]");
        System.out.println("Calories: " + super.getCalories() + "kcal");
        System.out.println("Carbohydrates: " + super.getCarbohydrates() + "g");
        System.out.println("Fats: " + super.getFats() + "g");
        System.out.println("Protein: " + getProtein() + "g");
        System.out.println();

        output.println("- Meat: " + super.getName());
        output.println("[Nutrients per 100g]");
        output.println("Calories: " + super.getCalories() + "kcal");
        output.println("Carbohydrates: " + super.getCarbohydrates() + "g");
        output.println("Fats: " + super.getFats() + "g");
        output.println("Protein: " + getProtein() + "g");
        output.println();
    }
}

class Vege extends Ingredients {
    public double fiber;

    public Vege(String name, double calories, double carbohydrates, double fats, double fiber) {
        super(name, calories, carbohydrates, fats);
        this.fiber = fiber;
    }

    public double getFiber() {
        return fiber;
    }

    public void getIngredientDetails(PrintWriter output) {
        System.out.println("- Vegetable: " + super.getName());
        System.out.println("[Nutrients per 100g]");
        System.out.println("Calories: " + super.getCalories() + "kcal");
        System.out.println("Carbohydrates: " + super.getCarbohydrates() + "g");
        System.out.println("Fats: " + super.getFats() + "g");
        System.out.println("Fiber: " + getFiber() + "g");
        System.out.println();

        output.println("- Vegetable: " + super.getName());
        output.println("[Nutrients per 100g]");
        output.println("Calories: " + super.getCalories() + "kcal");
        output.println("Carbohydrates: " + super.getCarbohydrates() + "g");
        output.println("Fats: " + super.getFats() + "g");
        output.println("Fiber: " + getFiber() + "g");
        output.println();
    }
}

class Meal {
    private Vector<Ingredients> IngredientList;
    private String mealName;

    public Meal(String mealName, Ingredients... IngredientList) {
        this.mealName = mealName;
        this.IngredientList = new Vector<Ingredients>();
        for (Ingredients i : IngredientList) {
            this.IngredientList.add(i);
        }
    }

    public String getMealName() {
        return mealName;
    }

    public Vector<Ingredients> getIngredientList() {
        return IngredientList;
    }
}

class MealPlan {
    private Vector<Meal> MealList;

    public MealPlan(Meal... MealList) {
        this.MealList = new Vector<Meal>();
        for (Meal m : MealList) {
            this.MealList.add(m);
        }
    }

    public Vector<Meal> getMealList() {
        return MealList;
    }
}

class HealthTracker {
    private Person p;

    public HealthTracker(Person p) {
        this.p = p;
    }

    public Person getPerson() {
        return p;
    }

    public void decidePlan(PrintWriter output) {
        double bmi = p.getHealthData().getBMI();
        String bmiStatus = p.getHealthData().BMIStatus(bmi);

        if (bmiStatus.equals("Underweight")) {
            suggestHighCalorieMealPlan(output);
        } else if (bmiStatus.equals("Normal")) {
            suggestBalancedMealPlan(output);
        } else if (bmiStatus.equals("Overweight")) {
            suggestReducedCalorieMealPlan(output);
        } else if (bmiStatus.equals("Obese")) {
            suggestReducedCalorieMealPlan(output);
        }
    }

    private void suggestHighCalorieMealPlan(PrintWriter output) {
        // Suggest a meal plan with higher calorie intake for underweight individuals
        MealPlan mealPlan = new MealPlan(
                new Meal("Breakfast", new Vege("Broccoli", 34.0, 6.6, 0.4, 2.6),
                        new Meat("Chicken", 239.0, 0.0, 14.0, 27.0), new Vege("Avocado", 160.0, 8.5, 14.7, 6.7),
                        new Vege("Potatoes", 77.0, 17.0, 0.1, 3.8)),
                new Meal("Lunch", new Vege("Brussel Sprouts", 43.0, 9.0, 0.3, 3.8),
                        new Meat("Salmon", 206.0, 0.0, 13.0, 22.0), new Meat("Beef", 250.0, 0.0, 17.0, 26.0)),
                new Meal("Dinner", new Vege("Corn", 96.0, 21.0, 1.2, 4.0), new Vege("Peanuts", 567.0, 16.0, 49.0, 8.0),
                        new Meat("Prawns", 99.0, 0, 1.4, 21.6)));

        System.out.println("\n\nSuggested meal plan for underweight individuals: \n");
        output.println("\n\nSuggested meal plan for underweight individuals: \n");
        displayMealPlan(mealPlan, output);
    }

    private void suggestBalancedMealPlan(PrintWriter output) {
        // Suggest a balanced meal plan for individuals with normal weight
        MealPlan mealPlan = new MealPlan(
                new Meal("Breakfast", new Meat("Chicken", 239.0, 0.0, 14.0, 27.0),
                        new Vege("Long Beans", 47.0, 7.6, 0.4, 3.6)),
                new Meal("Lunch", new Meat("Beef", 250.0, 0.0, 17.0, 26.0), new Vege("Lettuce", 5.0, 1.0, 0.1, 0.5),
                        new Vege("Cucumber", 15.0, 3.6, 0.1, 0.5)),
                new Meal("Dinner", new Meat("Mutton", 294.0, 0.0, 21.0, 25.7), new Vege("Spinach", 23.0, 3.6, 0.4, 2.2),
                        new Vege("Carrot", 41.0, 9.6, 0.2, 2.8)));

        System.out.println("\n\nSuggested balanced meal plan for normal weight individuals: \n");
        output.println("\n\nSuggested balanced meal plan for normal weight individuals: \n");
        displayMealPlan(mealPlan, output);
    }

    private void suggestReducedCalorieMealPlan(PrintWriter output) {
        // Suggest a meal plan with reduced calorie intake for overweight and obese
        // individuals
        MealPlan mealPlan = new MealPlan(
                new Meal("Breakfast", new Vege("Broccoli", 34.0, 6.6, 0.4, 2.6),
                        new Vege("Tomatoes", 18.0, 3.9, 0.2, 1.2), new Vege("Mushrooms", 22.0, 3.3, 0.3, 1.0)),
                new Meal("Lunch", new Vege("Lettuce", 239.0, 27.0, 0.0, 2.5),
                        new Vege("Eggplant", 25.0, 5.7, 0.18, 3.0)),
                new Meal("Dinner", new Vege("Corn", 239.0, 27.0, 0.0, 2.5),
                        new Vege("Cauliflower", 25.0, 5.0, 0.3, 2.0), new Meat("Chicken Breast", 165.0, 0, 3.6, 31.0)));

        System.out.println("\n\nSuggested meal plan for overweight or obese individuals: \n");
        output.println("\n\nSuggested meal plan for overweight or obese individuals: \n");
        displayMealPlan(mealPlan, output);
    }

    private void displayMealPlan(MealPlan mealPlan, PrintWriter output) {
        Vector<Meal> meals = mealPlan.getMealList();
        for (Meal meal : meals) {
            System.out.println("========================================================");
            System.out.printf("%31s\n", meal.getMealName());
            System.out.println("========================================================");
            System.out.println("Ingredients: ");

            output.println("========================================================");
            output.printf("%31s\n", meal.getMealName());
            output.println("========================================================");
            output.println("Ingredients: ");

            Vector<Ingredients> ingredients = meal.getIngredientList();
            for (Ingredients ingredient : ingredients) {
                if (ingredient instanceof Meat) {
                    Meat meat = (Meat) ingredient;
                    meat.getIngredientDetails(output);

                } else if (ingredient instanceof Vege) {
                    Vege vege = (Vege) ingredient;
                    vege.getIngredientDetails(output);
                }
            }
        }
    }
}

class HealthList {
    private Vector<HealthTracker> HealthL;

    public HealthList() {
        HealthL = new Vector<HealthTracker>();
    };

    public void addPersonIntoList(HealthTracker h) {
        HealthL.add(h);
    }

    public Vector<HealthTracker> getHealthTrackerVector() {
        return HealthL;
    }
}

class HealthTrackerApp {
    public static void main(String[] a) throws IOException {
        String name, bloodpressure;
        int age = 0;
        double height = 0.0, weight = 0.0, bmi, systolic = 0.0, diastolic = 0.0;
        char gender;
        HealthList hList = new HealthList();

        Scanner sc = new Scanner(System.in);
        PrintWriter fileOutput = new PrintWriter("HealthTrack.txt");

        System.out.println("Welcome to Health Tracker App\n\n");
        int i = 0;

        boolean useStatus = true;
        do{
            System.out.println(":::::::::::::::::: Enter User Details ::::::::::::::::::");
            System.out.print("Name : ");
            name = sc.nextLine();

            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Age : ");
                    age = sc.nextInt();
                    validInput = true;
                    if (age < 0) {
                        System.out.println("Invalid age! Please enter a non-negative value.");
                        validInput = false;
                    }
                    else if (age < 17 || age > 66) {
                        System.out.println("Invalid age! Please enter a value from 18 to 65.");
                        validInput = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid age! Please enter a valid age.");
                    sc.nextLine(); // Clear the invalid input from the scanner
                }
            }

            System.out.print("Gender (M/F) : ");
            while (true) {
                String input = sc.next();
                if (input.length() == 1 && (input.charAt(0) == 'M' || input.charAt(0) == 'F' || input.charAt(0) == 'm'
                        || input.charAt(0) == 'f')) {
                    gender = input.charAt(0);
                    break;
                } else {
                    System.out.println("Invalid gender! Please enter 'M' or 'F'.");
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Height (cm) : ");
                    height = sc.nextDouble();
                    validInput = true;
                    if (height < 0) {
                        System.out.println("Invalid height! Please enter a non-negative value.");
                        validInput = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid height! Please enter a valid height.");
                    sc.nextLine(); // Clear the invalid input from the scanner
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Weight (kg) : ");
                    weight = sc.nextDouble();
                    validInput = true;
                    if (weight < 0) {
                        System.out.println("Invalid weight! Please enter a non-negative value.");
                        validInput = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid weight! Please enter a valid weight.");
                    sc.nextLine(); // Clear the invalid input from the scanner
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Blood Pressure(Systolic)(mmHg) : ");
                    systolic = sc.nextDouble();
                    validInput = true;
                    if (systolic < 0) {
                        System.out.println("Invalid Blood Pressure(Systolic)! Please enter a non-negative value.");
                        validInput = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Systolic! Please enter a valid Systolic.");
                    sc.nextLine(); // Clear the invalid input from the scanner
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Blood Pressure(Diastolic)(mmHg) : ");
                    diastolic = sc.nextDouble();
                    validInput = true;
                    if (systolic < 0) {
                        System.out.println("Invalid Blood Pressure(Diastolic)! Please enter a non-negative value.");
                        validInput = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Diastolic! Please enter a valid Diastolic.");
                    sc.nextLine(); // Clear the invalid input from the scanner
                }
            }

            Person p = new Person(name, age, gender, height, weight, systolic, diastolic);

            bmi = p.getHealthData().calculateBMI(height, weight);
            bloodpressure = p.getHealthData().determineBloodPressure(systolic, diastolic);

            System.out.println("\n\n:::::::::::::::::::: Health Details ::::::::::::::::::::");
            System.out.printf("Body Mass Index (BMI) : %.2f", bmi);
            System.out.print(" (" + p.getHealthData().BMIStatus(bmi) + ")");
            System.out.println("\nBlood Pressure Status : " + bloodpressure);

            HealthTracker tracker = new HealthTracker(p);
            hList.addPersonIntoList(tracker);

        System.out.println("Proceed with printing out details..........");

            fileOutput.println("::::::::::::::::::::: User Details :::::::::::::::::::::");
            fileOutput.println("Name: " + hList.getHealthTrackerVector().elementAt(i).getPerson().getName());
            fileOutput.println("Age: " + hList.getHealthTrackerVector().elementAt(i).getPerson().getAge());
            fileOutput.println("Gender (M/F) : " + hList.getHealthTrackerVector().elementAt(i).getPerson().getGender());
            fileOutput.printf("Height (cm) : %.2f", hList.getHealthTrackerVector().elementAt(i).getPerson().getHeight());
            fileOutput.printf("\nWeight (kg) : %.2f", hList.getHealthTrackerVector().elementAt(i).getPerson().getWeight());
            fileOutput.printf("\nBlood Pressure(Systolic)(mmHg) : %.2f", hList.getHealthTrackerVector().elementAt(i).getPerson().getSystolic());
            fileOutput.printf("\nBlood Pressure(Diastolic)(mmHg) : %.2f", hList.getHealthTrackerVector().elementAt(i).getPerson().getDiastolic());
            fileOutput.println("\n\n:::::::::::::::::::: Health Details ::::::::::::::::::::");
            fileOutput.printf("Body Mass Index (BMI) : %.2f", hList.getHealthTrackerVector().get(i).getPerson().getHealthData().getBMI());
            fileOutput.print(" (" + hList.getHealthTrackerVector().elementAt(i).getPerson().getHealthData().BMIStatus(hList.getHealthTrackerVector().get(i).getPerson().getHealthData().getBMI()) + ")");
            fileOutput.println("\nBlood Pressure Status : " + hList.getHealthTrackerVector().elementAt(i).getPerson().getHealthData().getBloodPressure());
            hList.getHealthTrackerVector().elementAt(i).decidePlan(fileOutput);
        i++;
        
        System.out.print("Continue to use? (Y/N) : ");
        while (true) {
                String input = sc.next();
                if (input.length() == 1 && (input.charAt(0) == 'Y' || input.charAt(0) == 'y' || input.charAt(0) == 'n' || input.charAt(0) == 'N')) 
                {
                    if(input.charAt(0) == 'Y' || input.charAt(0) == 'y')
                    {
                        useStatus = true;
                    }
                    else{
                        useStatus = false;
                        break;
                    }
                    break;
                } 
                else {
                    System.out.println("Invalid choice! Please enter 'Y' or 'N'.");
                }
            }
            sc.nextLine();
        }while(useStatus);

        fileOutput.close();

        sc.close();
    }
}