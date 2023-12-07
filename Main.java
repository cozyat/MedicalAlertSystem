public abstract class Main extends MedicalAlertSystem {
    public static void main(String[] args) {
        ASCIIArt(); // call inherited method ASCIIArt()
        System.out.println("");
        System.out.println("______________________________________________________");

        // reference variables
        Double bodyTemp = bodyTemp();
        int bloodPressure = bloodPressure();
        int hydrationLevel = hydrationLevel();
        int heartRate = heartRate();

        // call patientResults() passing in 4 parameters
        patientResults(bodyTemp, bloodPressure, hydrationLevel, heartRate);
        System.out.println("");
    }
}