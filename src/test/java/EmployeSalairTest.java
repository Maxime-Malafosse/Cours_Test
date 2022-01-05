import AppTest.Employe;
import AppTest.EmployeBusiness;
import org.junit.Test;
import org.testng.Assert;

public class EmployeSalairTest {
    EmployeBusiness empBusinessLogic = new EmployeBusiness();
    Employe employe = new Employe("oo");

    @Test
    public void testCalculateAppriasal() {

        employe.setNom("Emp1");
        employe.setArgent(8000);

        double appraisal = empBusinessLogic.calculateAppraisal(employe);
        Assert.assertEquals(500, appraisal, "500");
    }

    // Test to check yearly salary
    @Test
    public void testCalculSalairAnnuel() {

        employe.setNom("Emp2");
        employe.setArgent(8000);

        double salary = empBusinessLogic.calculateSalairAnnuel(employe);
        Assert.assertEquals(96000, salary, "8000");
    }
}
