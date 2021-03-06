package auto.calculators;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    /**
     * Calculates age from given birth date.
     * @param birthDate
     * @return age.
     */
    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else
            return 0;
    }
}
