import AppTest.*;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class mainTest {

//    @Test
//
//        public void testCalcul(){
//            Random r = new Random();
//
//            int a = r.nextInt(500);
//            int b = r.nextInt(500);
//            int calcul = main.calcul(a,b);
//            System.out.println(a+" "+b);
//            assertEquals(a+b,calcul);
//        }
//        @Test
//        public void testGrand(){
//            Random r = new Random();
//            int a = r.nextInt(500);
//            int b = r.nextInt(500);
//            int calcul = main.calcul(a,b);
//            System.out.println(a+" "+b);
//            assertTrue(main.plusOuEgal100(calcul));
//        }
//        @Test
//        public void pasChiffreEntre(){
//            Entreprise e = new Entreprise();
//
//            assertEquals(0,e.getChiffreAffaire());
//        }
//        @Test
//        public void ajoutEmploye(){
//            Entreprise e = new Entreprise();
//            Employe ea = new Employe("ooo");
//            e.ajouteEmploye(ea);
//            assertEquals(1,e.getEmploye());
//        }
//         @Test
//        public void ajoutSalaire(){
//            Entreprise e = new Entreprise();
//            Employe ea = new Employe("ooo");
//            Employe aaa = new Employe("aaa");
//            e.ajouteEmploye(ea);
//            e.ajouteEmploye(aaa);
//            e.payerSalaires();
//            assertEquals(e.getListEmpl().get(0).getArgent(),1500);
//            assertEquals(e.getListEmpl().get(1).getArgent(),1500);
//        }
//
//    @Test
//    public void ajoutSalairex2(){
//        Entreprise e = new Entreprise();
//        Employe ea = new Employe("ooo");
//        Employe aaa = new Employe("aaa");
//        e.ajouteEmploye(ea);
//        e.ajouteEmploye(aaa);
//        e.payerSalaires();
//        e.payerSalaires();
//        assertEquals(e.getListEmpl().get(0).getArgent(),3000);
//        assertEquals(e.getListEmpl().get(1).getArgent(),3000);
//    }

    private Champion yone;
    private Champion yasuo;

    @Given("a new champion $championName at $role in $lane")
    @Aliases(values={"a new champion: $championName at $role in $lane"})
    public void newChampion(String championName,String role, String lane){
        yone = new Champion(championName, role,  lane);
    }

    @When("I create the same $champion with only the role $role")
    @Aliases(values={"another champion : $champion at $role"})
    public void newChampionWithoutTheLane(String champion, String role){
        yasuo = new Champion(champion, role);
//      Champion yasuo = new Champion("Yasuo",  "top", "Toplane");
    }

    @Then("Both champions should have the same lane")
    public void theLaneShouldBeEqual() {
        assertTrue(yone.getVoie().equals(yasuo.getVoie()));
    }

    @Test
    public void TestChampionStory() {
        newChampion("Yasuo", "top", "Toplane");
        newChampionWithoutTheLane("Yasuo", "top");
        theLaneShouldBeEqual();
    }

}
