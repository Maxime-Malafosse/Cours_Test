package AppTest;

public class EmployeBusiness {
    public double calculateSalairAnnuel(Employe emp) {
        double yearlySalary = 0;
        yearlySalary = emp.getArgent() * 12;
        return yearlySalary;
    }

    // Calculer le montant de l'évaluation de l'employé
    public double calculateAppraisal(Employe emp) {

        double appraisal = 0;

        if(emp.getArgent() < 10000) {
            appraisal = 500;

        } else {
            appraisal = 1000;
        }

        return appraisal;
    }
}
