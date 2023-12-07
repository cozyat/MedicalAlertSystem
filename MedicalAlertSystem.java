import java.util.Scanner; // import scanner library

public class MedicalAlertSystem {
  public static void ASCIIArt() { // display ASCII art welcome message
    System.out.println(
        " .       __         .                                        .                 .    _                            ");
    System.out.println(
        " /       |    ___   |     ___    __.  , _ , _     ___       _/_     __.       _/_   /        ___                 ");
    System.out.println(
        " |       |  .'   `  |   .'   ` .'   \\ |' `|' `. .'   `       |    .'   \\       |    |,---. .'   `                ");
    System.out.println(
        " |  /\\   /  |----'  |   |      |    | |   |   | |----'       |    |    |       |    |'   ` |----'                ");
    System.out.println(
        " |,'  \\,'   `.___, /\\__  `._.'  `._.' /   '   / `.___,       \\__/  `._.'       \\__/ /    | `.___,                ");
    System.out.println(
        "     .           .                             .                _      __   __             _                  .  ");
    System.out.println(
        "    /|    ,   . _/_     __.  , _ , _     ___  _/_     ___    ___/      |    |    ___    ___/ `   ___    ___   |  ");
    System.out.println(
        "   /  \\   |   |  |    .'   \\ |' `|' `.  /   `  |    .'   `  /   |      |\\  /|  .'   `  /   | | .'   `  /   `  |  ");
    System.out.println(
        "  /---'\\  |   |  |    |    | |   |   | |    |  |    |----' ,'   |      | \\/ |  |----' ,'   | | |      |    |  |  ");
    System.out.println(
        ",'      \\ `._/|  \\__/  `._.' /   '   / `.__/|  \\__/ `.___, `___,'      /    /  `.___, `___,' /  `._.' `.__/| /\\__");
    System.out.println(
        "     .     .                 .                  _____           `     .                    `                     ");
    System.out.println(
        "    /|     |     ___  .___  _/_     ____       (      ,    .    ____ _/_     ___  , _ , _                        ");
    System.out.println(
        "   /  \\    |   .'   ` /   \\  |     (            `--.  |    `   (      |    .'   ` |' `|' `.                      ");
    System.out.println(
        "  /---'\\   |   |----' |   '  |     `--.            |  |    |   `--.   |    |----' |   |   |                      ");
    System.out.println(
        ",'      \\ /\\__ `.___, /      \\__/ \\___.'      \\___.'   `---|. \\___.'  \\__/ `.___, /   '   /                     ");
  }

  // instantiate variables for medical stats
  private Double BT;
  private int BP;
  private int HL;
  private int HR;

  // MAS constructor, object reference
  public void MASMainConstructor(Double bodyTemp, int bloodPressure, int hydrationLevel, int heartRate) {
    this.BT = bodyTemp;
    this.BP = bloodPressure;
    this.HL = hydrationLevel;
    this.HR = heartRate;
  }

  public static Double bodyTemp() { // ask for body temperature
    Scanner input = new Scanner(System.in);
    System.out.println("");

    System.out.println("Enter temperature: ");
    Double bodyTemp = input.nextDouble();

    return bodyTemp; // store and return BT value
  }

  public static int bloodPressure() { // ask for blood pressure
    Scanner input = new Scanner(System.in);
    System.out.println("");

    System.out.println("Enter blood pressure (diastolic): ");
    int bloodPressure = input.nextInt();

    return bloodPressure; // store and return BP value
  }

  public static int hydrationLevel() { // ask for hydration level
    Scanner input = new Scanner(System.in);
    System.out.println("");

    System.out.println("Enter hydration level (OUT OF 100)");
    int hydrationLevel = input.nextInt();

    if (hydrationLevel > 100 || hydrationLevel < 0) {
      System.out.println("I'm sorry but this is an invalid percentage.");
      hydrationLevel = 0; // null HL value
    }

    return hydrationLevel; // store and return HL value
  }

  public static int heartRate() { // ask for heart rate
    Scanner input = new Scanner(System.in);
    System.out.println("");

    System.out.println("Enter heart rate: ");
    int heartRate = input.nextInt();

    return heartRate; // store and return HR value
  }

  /*
   * SO FAR:
   * 1. heart rate
   * 2. hydration level
   * 3. blood pressure
   * 4. body temperature
   * values should have been returned
   * 
   * 
   * FLOW CHART:
   * the non-returnable patientResults() method follows the flow chart that was
   * visualized in our presentation
   * [read comments for every condition that follow the chart]
   */

  public static final void patientResults(Double bodyTemp, int bloodPressure, int hydrationLevel, int heartRate) {
    System.out.println("");
    System.out.println("Results: ");

    // setting boolean variables to see if patient is healthy or not healthy
    boolean abnormalHydrationLevel = false;
    boolean abnormalBloodPressure = false;
    boolean abnormalBodyTemp = false;
    boolean abnormalHeartRate = false;

    // 4 conditionals [including one nested] is to check if patient isn't alright
    if (hydrationLevel < 50 || hydrationLevel > 70) {
      System.out.println("Two nurses will stop by to add water through your IV.");
      abnormalHydrationLevel = true;
    }
    if (bloodPressure < 20 || bloodPressure > 80) {
      System.out.println("One nurse from our ER will come to check on your blood pressure levels.");
      abnormalBloodPressure = true;
    }
    if (bodyTemp > 96.8) {
      if (bodyTemp > 100.4) {
        System.out.println("A general doctor and a nurse has been alerted to your high fever.");
        abnormalBodyTemp = true;
      }
    }
    if (heartRate < 60 || heartRate > 100) {
      System.out.println("Three nurses and two doctors from the OR have been alerted about abnormal heart rate.");
      abnormalHeartRate = true;
    }

    // final message for patient
    System.out.println("");

    if (!abnormalHydrationLevel && !abnormalBloodPressure && !abnormalBodyTemp && !abnormalHeartRate) {
      // discharge patient to go home
      System.out
          .println("Since you are identified as all healthy, you have been discharged, and you are free to go home!");
    } else {
      // keep patient for medical care
      System.out.println(
          "Since you are identified as unhealthy, you will need to stay for some time till you can get better.");
      System.out.println("");

      // give a random number of days that the patient needs to stay for
      int max = 10;
      int min = 1;
      int range = max - min + 1;
      int randomTime = (int) (Math.random() * range) + min;

      System.out.println("You will need to stay for " + randomTime + " days until you are fixed.");
    }
  }
}

// mutator methods will go here