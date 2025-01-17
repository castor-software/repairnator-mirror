package fr.inria.spirals.repairnator.process.maven.output;

import fr.inria.spirals.repairnator.process.maven.MavenHelper;

/**
 * Created by urli on 09/01/2017.
 */
public class MavenFilterOutputHandler extends MavenOutputHandler {


    public MavenFilterOutputHandler(MavenHelper mavenHelper) {
        super(mavenHelper);
    }

    @Override
    public void consumeLine(String s) {
        super.consumeLine(s);

        if (s.contains("ERROR") || s.contains("error")) {
            this.getLogger().error(s);
            this.inspector.getJobStatus().addStepError(name, s);
        }
    }
}
