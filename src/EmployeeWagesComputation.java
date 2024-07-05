
import java.util.*;

public class EmployeeWagesComputation {

    public static final int FULL_TIME = 1;
    public static final int PART_TIME = 2;
    public static final int Emp_absent = 0;
    public static final int FULL_DAY_HOURS = 8;
    public static final int PART_TIME_HOURS = 4;

    private int wagePerHour;
    private int workingDaysPerMonth;
    private int maxHoursInMonth;
    private int totalWorkingDays = 0;
    private int totalWorkingHours = 0;
    private int totalEmployeeWage = 0;

    public EmployeeWagesComputation(int wagePerHour, int workingDaysPerMonth, int maxHoursInMonth) {
        this.wagePerHour = wagePerHour;
        this.workingDaysPerMonth = workingDaysPerMonth;
        this.maxHoursInMonth = maxHoursInMonth;
    }

    public int getWorkingHours() {
        int employeeType = (int) (Math.random()*3);
        switch (employeeType) {
            case FULL_TIME:
                return FULL_DAY_HOURS;
            case PART_TIME:
                return PART_TIME_HOURS;
            case Emp_absent:
                return Emp_absent;
            default:
                return 0;
        }
    }

    public void calculateWages() {
        while (totalWorkingDays < workingDaysPerMonth && totalWorkingHours <= maxHoursInMonth) {
            totalWorkingDays++;
            int workHours = getWorkingHours();
            totalWorkingHours += workHours;
            int dailyWage = workHours * wagePerHour;
            totalEmployeeWage += dailyWage;
            System.out.println("Day: " + totalWorkingDays + " Hours Worked: " + workHours + " Daily Wage: " + dailyWage);
        }
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Employee Wage: " + totalEmployeeWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the wage per hour: ");
        int wagePerHour = scanner.nextInt();

        System.out.print("Enter the number of working days per month: ");
        int workingDaysPerMonth = scanner.nextInt();

        System.out.print("Enter the maximum working hours per month: ");
        int maxHoursInMonth = scanner.nextInt();

        EmployeeWagesComputation computation = new EmployeeWagesComputation(wagePerHour, workingDaysPerMonth,maxHoursInMonth);
        computation.calculateWages();

        scanner.close();
    }

}
