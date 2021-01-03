package org.example.simple.plugins.plus;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * calculate a plus b
 * version 2
 */
@Mojo(name = "plusV2")
public class PlusMojoV2 extends AbstractMojo {

    @Parameter(property = "plusV2.a")
    private int a;

    @Parameter(property = "plusV2.b")
    private int b;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("\na is: " + a);
        getLog().info("\nb is: " + b);
        getLog().info("\na + b is: " + (a + b));
    }
}
