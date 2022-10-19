package com.gnome.ui;

import com.gnome.dao.DvdLibraryDaoException;
import com.gnome.dao.dvdLibraryDao;
import com.gnome.dto.DvD;
import java.util.List;

public class DvdLibraryView {
    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }


    public int printMenuAndGetSelection() {
        //implement
        io.print("Main Menu");
        io.print("1. List Dvds");
        io.print("2. Create New dvd");
        io.print("3. View a dvd");
        io.print("4. Remove a Dvd");
        io.print("5. Edit a dvd");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.");
    }

    public int printEditMenuAndGetSelection(){
        io.print("Edit DVD Menu");
        io.print("1. Edit title");
        io.print("2. Edit release date");
        io.print("3. Edit MPAA rating");
        io.print("4. Edit director's name");
        io.print("5. Edit user rating");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.");
    }

    /*
     This method prompts the user for dvd ID, First Name, Last Name, and Cohort,
    gathers this information, creates a new dvd object, and returns it to the caller.
     */
    public DvD getNewDvDInfo() {
        //implement
        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter release date");
        String mpaa = io.readString("Please enter MPAA");
        String directorsName = io.readString("Please enter director's name");
        String studio = io.readString("Please enter studio");
        String userRating = io.readString("Please enter user rating");

        DvD currentDvD = new DvD(title);
        currentDvD.setReleaseDate(releaseDate);
        currentDvD.setMPAARating(mpaa);
        currentDvD.setDirectorName(directorsName);
        currentDvD.setStudio(studio);
        currentDvD.setUserRating(userRating);
        return currentDvD;
    }

    /*
    This method simply displays a banner or heading to the UI indicating that
    the next interactions on the screen will be for creating a new dvd
     */
    public void displayCreateDvDBanner() {
        io.print("=== Create DvD ===");
    }

    /*
    The second method displays a message that the new dvd was successfully created
    and waits for the user to hit Enter to continue
     */
    public void displayCreateSuccessBanner() {
        io.readString(
                "DvD successfully created.  Please hit enter to continue");
    }

    /*
    A method that takes a list of DVD objects as a parameter and displays the information for each Dvd to the screen.
     */
    public void displayDvdList(List<DvD> dvdList) {
        //implement
       for(DvD currentDvD : dvdList){
           printDvDInput(currentDvD);
       }
       pushEnter();
    }

    // when they press enter key
    private void pushEnter(){
        io.readString("Please hit enter to continue");
    }

    // print the dvd input from the user
    private void printDvDInput(DvD dvd){
        io.print(dvd.getTitle());
        io.print("\tRelease Date: " + dvd.getReleaseDate());
        io.print("\tMPAA Rating: " + dvd.getMPAARating());
        io.print("\tDirector: " + dvd.getDirectorName());
        io.print("\tStudio: " + dvd.getStudio());
        io.print("\tUser Rating: "+ dvd.getUserRating());
        io.print("");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }

    /*
    Shows the student banner
     */
    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    /*
    Get the dvd title to display information
     */
    public String getDvdTitleChoice() {
        return io.readString("Please enter the dvd title.");
    }

    /*
    Displays the dvd information
     */
    public void displayDvd(DvD dvd) {
        //implement
        if(dvd != null){
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAARating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        }else{
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");

    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(DvD dvdRecord) {
        //implement
        if(dvdRecord != null){
            io.print("dvd successfully removed");
        }else{
            io.print("No such dvd");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditDvdSuccess() {
        io.readString(
                "DVD successfully Edited.  Please hit enter to continue");
    }

    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }

    public void displayEditMpaaBanner() {
        io.print("=== Edit DVD MPAA rating ===");
    }

    public void displayEditDirectorNameBanner() {
        io.print("=== Edit DVD Director's Name ===");
    }

    public void displayEditStudio() {
        io.print("=== Edit DVD Studio ===");
    }

    public void displayEditUserRating() {
        io.print("=== Edit DVD User Rating ===");
    }

    public String getNewReleaseDate() {
        return io.readString("Please enter new release date.");
    }

    public String getNewMpaaRating() {
        return io.readString("Please enter new MPAA rating.");
    }

    public String getNewDirectorName() {
        return io.readString("Please enter new director's name.");
    }

    public String getNewUserRating() {
        return io.readString("Please enter new user rating.");
    }

    public String getNewStudio() {
        return io.readString("Please enter new studio.");
    }

    public void displayNullDVD() {
        io.print("No such DVD.");
        io.readString("Please hit enter to continue.");
    }
}

