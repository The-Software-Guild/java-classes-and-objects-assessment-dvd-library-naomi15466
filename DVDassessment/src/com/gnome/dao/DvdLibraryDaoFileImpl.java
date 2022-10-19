package com.gnome.dao;

import com.gnome.dto.DvD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DvdLibraryDaoFileImpl implements dvdLibraryDao {
    public final String DVD_FILE;
    public static final String DELIMITER = "::";
    /*
    Hash Map to store and retrieve the dvd with title name
     */
    private Map<String, DvD> dvds = new HashMap<>();

    public DvdLibraryDaoFileImpl() { //no arg constructor typically used
        DVD_FILE = "dvdTest.txt";
    }

    public DvdLibraryDaoFileImpl(String libraryTextFile) {
        DVD_FILE = libraryTextFile;
    }

    @Override
    public DvD addDvd(String title, DvD dvd) {
        //implement
        DvD prevDvD = dvds.put(title, dvd);
        return prevDvD;
    }

    /*
    This code gets all of the DvDs objects out of the dvds map as a collection by calling the values() method.
     */
    @Override
    public List<DvD> getAllDvds() throws DvdLibraryDaoException {
        // implement
        // return the array list with values
        return new ArrayList<DvD>(dvds.values());
    }

    /*
    This method is quite simple — we just ask the dvds map for the dvd object with the given title and return it
     */
    @Override
    public DvD getDvd(String title) throws DvdLibraryDaoException {

        //implement
        // return title of the dvd
        return dvds.get(title);
    }

    @Override
    public DvD removeDvd(String title) throws DvdLibraryDaoException {

        //implement
        // declare variable to remove dvd title
        DvD removeDvd = dvds.remove(title);
        writeDvdFile();
        return removeDvd;
    }


    /*
    Method to unmarshall the object or read a line of string
    from the line and convert it into an object
     */
    private DvD unmarshallDvd(String dvdAsText) {
        //implement
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        System.out.println(title);
        DvD dvdFromFile = new DvD(title);
        System.out.println(dvdTokens[1]);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setMPAARating(dvdTokens[2]);
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRating((dvdTokens[5]));
        return dvdFromFile;
    }

    /*
    Method to Load file DVD_FILE into memory
     */
    private void loadDvdFile() throws DvdLibraryDaoException {
        //implement
        Scanner scanner;
        try {
// Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load dvd data into memory.", e);
        }

        String currentLine; // holds most recent line from scanner
        DvD currentDVD;     // holds most recent unmarshalled

        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDvd(currentLine);
            dvds.put(currentDVD.getTitle(),currentDVD);
        }
        scanner.close();
    }



    private String marshallDvd(DvD aDvd) {
        //implement
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        // add properties in accurate order
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getMPAARating() + DELIMITER;

        // DIRECTOR NAME
        dvdAsText += aDvd.getDirectorName() + DELIMITER;

        // STUDIO
        dvdAsText += aDvd.getStudio() + DELIMITER;
        dvdAsText += aDvd.getUserRating();

        // return the text
        return dvdAsText;

    }

    /**
     * Writes all Dvds in the library out to a DVD_FILE. See loadDvdFile
     * for file format.
     *
     * @throws Exception if an error occurs writing to the file
     */
    private void writeDvdFile() throws DvdLibraryDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        //implement
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(DVD_FILE));
        }catch(IOException e){
            throw new DvdLibraryDaoException("could not sve dvd data",e);
        }

        // Write out the DvD objects to the DVD file.
        // NOTE TO THE APPRENTICES: We could just grab the dvd map,
        // get the Collection of dvd and iterate over them but we've
        // already created a method that gets a List of dvds so
        // we'll reuse it.
        //implement
        String dvdAsText;
        List<DvD> dvdList = this.getAllDvds();
        for(DvD currentDvd: dvdList){
            // convert dvd to string
            dvdAsText = marshallDvd(currentDvd);
            System.out.println(dvdAsText);
            out.flush();
        }
        // close
        out.close();
    }

    @Override
    public DvD editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException {
        loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setReleaseDate(newReleaseDate);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public DvD editMPAA(String title, String newMpaaRating) throws DvdLibraryDaoException {
        loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setMPAARating(newMpaaRating);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public DvD editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException {
        loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setDirectorName(newDirectorName);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public DvD editUserRating(String title, String newUserRating) throws DvdLibraryDaoException {
        loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setUserRating(newUserRating);
        writeDvdFile();
        return currentDVD;
    }

    @Override
    public DvD editStudio(String title, String newStudioName) throws DvdLibraryDaoException {
        loadDvdFile();
        DvD currentDVD = dvds.get(title);
        currentDVD.setStudio(newStudioName);
        writeDvdFile();
        return currentDVD;
    }
}
