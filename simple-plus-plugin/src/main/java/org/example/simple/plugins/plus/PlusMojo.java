package org.example.simple.plugins.plus;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.util.Scanner;

/**
 * calculate a plus b
 */
@Mojo(name = "plus")
public class PlusMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        Scanner scanner = new Scanner(System.in);

        getLog().info("\nPlease input a:");
        int a = scanner.nextInt();

        getLog().info("\nPlease input b:");
        int b = scanner.nextInt();

        getLog().info(String.format("\nThe result of a + b is: %s", a + b));
    }
}
