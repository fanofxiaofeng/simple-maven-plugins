package org.example.simple.plugins.clean;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "clean")
public class CleanMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.directory}", readonly = true, required = true)
    private File directory;

    public void execute() throws MojoExecutionException, MojoFailureException {
        delete(directory);
    }

    private void delete(File directory) {
        // 递归删除目录，参考了 https://www.cnblogs.com/eczhou/archive/2012/01/16/2323431.html 一文

        // 如果是不是目录，则直接删除
        if (directory.isFile()) {
            getLog().info("Deleting " + directory);
            directory.delete();
            return;
        }

        // 如果是目录，则需要递归地现将其子元素删除，最后再将此目录删除
        for (String filename : directory.list()) {
            delete(new File(directory, filename));
        }
        getLog().info("Deleting " + directory);
        directory.delete();
    }
}
