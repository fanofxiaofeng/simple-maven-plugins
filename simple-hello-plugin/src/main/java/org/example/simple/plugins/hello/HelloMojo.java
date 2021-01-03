package org.example.simple.plugins.hello;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;


/**
 * say Hello
 */
@Mojo(name = "hello")
public class HelloMojo extends AbstractMojo {

    @Parameter(property = "hello.name", defaultValue = "World")
    private String name;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info(String.format("Hello, %s!", name));
    }
}
