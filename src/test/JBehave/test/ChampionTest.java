import AppTest.Champion;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.RethrowingFailure;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChampionTest extends JUnitStories {
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
        assertEquals(yone.getVoie(), yasuo.getVoie());
    }

    @Override
    protected List<String> storyPaths() {
        return Collections.singletonList("..story/champion_test.story");
    }

    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(StoryReporterBuilder.Format.CONSOLE, StoryReporterBuilder.Format.TXT));
    }

    // Here we specify the steps classes
    @Override
    public InjectableStepsFactory stepsFactory() {
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new Champion("Yasuo", "top"));
    }
}
