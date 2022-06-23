package com.yusa.homework1plugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.maven.artifact.repository.metadata.Plugin;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
@Mojo(name = "homework1plugin" , defaultPhase = LifecyclePhase.INSTALL)

public class SummarizeGoal extends AbstractMojo {

	private MavenProject project;
	
	@Parameter(defaultValue = "output path")
	private String outputFile;
	public void execute() throws MojoExecutionException, MojoFailureException {
		@SuppressWarnings("unchecked")
		List <Dependency> dependencies = project.getDependencies();
		@SuppressWarnings("unchecked")
		List <Plugin> plugins = project.getBuildPlugins();

		
		System.out.println("Project info : " + project.getArtifactId());
		System.out.println("Developers : " + project.getDevelopers());
		System.out.println("Release Date : 23.06.2022" );
		
		for(Dependency d : dependencies) {
			System.out.println("Depencies : " );
			d.getArtifactId();
		}

		for(Plugin p : plugins) {
			System.out.println("Plugins : " );
			p.getArtifactId();
		}

		
		 File f = new File("C:\\outputFile.txt");
	     FileWriter yazdir;
		 try {
			FileWriter fileWriter = new FileWriter ("outputFile");
			yazdir = new FileWriter(outputFile);
			yazdir.write("Project info : " + project.getArtifactId());
			yazdir.write("Developers : " + project.getDevelopers());
			yazdir.write("Release Date : 23.06.2022" );
			yazdir.write("Project info : " + project.getArtifactId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	



	}
}
