package Data;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class Program implements Serializable {
    private String name;
    private String description;
    private File execLocation;
    private URL link;
    private boolean hasDependencies;
    private ArrayList<Program> extras;

    Program(String name, File execLocation, boolean hasDependencies) {
        this.name = name;
        this.execLocation = execLocation;
        this.hasDependencies = hasDependencies;

        extras = new ArrayList<>(1);
    }

    Program(String name, URL link, File execLocation, boolean hasDependencies) {
        this(name, execLocation, hasDependencies);
        this.link = link;
    }

    Program(String name, String description, File execLocation, boolean hasDependencies) {
        this(name, execLocation, hasDependencies);
        this.description = description;
    }

    Program(String name, String description, URL link, File execLocation, boolean hasDependencies) {
        this(name, description, execLocation, hasDependencies);
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public URL getLink() {
        return link;
    }

    public File getExecLocation() {
        return execLocation;
    }

    public ArrayList<Program> getExtras() {
        return extras;
    }

    public boolean hasDependencies() {
        return hasDependencies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public void setExecLocation(File execLocation) {
        this.execLocation = execLocation;
    }

    public boolean setDependencies() {
        return hasDependencies;
    }
}