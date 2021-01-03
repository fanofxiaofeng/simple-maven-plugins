package org.example.simple.plugins.show;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "show")
public class ShowMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.directory}", readonly = true, required = true)
    private File directory;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("All class files in target directory will be listed below");
        show(directory);
    }

    private void show(File directory) {
        if (directory.isFile()) {
            // 只展示名称以 ".class" 结尾的文件的名称
            if (directory.toString().endsWith(".class")) {
                getLog().info(directory.toString());
            }
            return;
        }

        for (String filename : directory.list()) {
            show(new File(directory, filename));
        }
    }
}
