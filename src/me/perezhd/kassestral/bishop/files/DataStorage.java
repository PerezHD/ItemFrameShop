package me.perezhd.kassestral.bishop.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class DataStorage {
    
    private File folder, file;
    private FileConfiguration fileFile;

    public DataStorage() {
    	this.folder = new File("plugins" + File.separator + "ItemFrameShop");
    	this.file = new File(folder, "shops.yml");
    	this.fileFile = null;
    }
   
    /**
     * Setups the file. Recommend you call this in your onEnable.
     *
     * @author HeadGam3z.
     */
    public void setupFile() {
    	getFile().options().header("Where all shops get saved to.");
    	getFile().options().copyDefaults(true);
    	saveFile();
    }
   
    /**
     * Gets the file.
     * If the file is not found, it will create a new one.
     *
     * @throws IOException.
     * @author HeadGam3z.
     */
    public FileConfiguration getFile() {
    	if (!folder.exists()) {
    		folder.mkdir();
    	}
    	if (!file.exists()) {
    		try {
    			file.createNewFile();
    		} catch (IOException e) {
    			e.getMessage();
    			e.printStackTrace();
    		}
    	}
    	if (fileFile == null) {
    		reloadFile();
    	}
    	return fileFile;
    }
   
    /**
     * Reloads the file.
     *
     * @author HeadGam3z.
     */
    public void reloadFile() {
    	fileFile = YamlConfiguration.loadConfiguration(file);
    }
   
    /**
     * Saves the file.
     *
     * @throws IOException.
     * @author HeadGam3z.
     */
    public void saveFile() {
    	try {
    		getFile().save(file);
    	} catch (IOException e) {
    		e.getMessage();
    		e.printStackTrace();
    	}
    }
}